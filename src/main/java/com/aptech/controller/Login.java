package com.aptech.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aptech.model.Role;
import com.aptech.model.User;
import com.aptech.repository.RoleRepository;
import com.aptech.service.ICategoryService;
import com.aptech.service.IUserService;

@Controller
public class Login {
	@Autowired 
	private RoleRepository roleRepository;
	@Autowired 
	private IUserService userService;
	@RequestMapping(value = "/login",method = {RequestMethod.GET, RequestMethod.POST })
	public String loginForm(RedirectAttributes redirAttrs) {
		redirAttrs.addFlashAttribute("success", "Register Success");
		return "login";
	}
	
	@RequestMapping(value = "/admin-success",method = {RequestMethod.GET})
	public String successLogin() {
		
		return "redirect:/admin";
	}
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "redirect:/login?accessDenied";
		
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		new SecurityContextLogoutHandler().logout(request, response, auth);
		return "redirect:/";
	}
	@GetMapping("/register")
	public String register(Model model,User user) {
		model.addAttribute("user", user);
		return "register";
	}
	@PostMapping("/register")
	public String addUser(@ModelAttribute("user") User user,Model model,RedirectAttributes redirAttrs) {
		try {
			String hash = new BCryptPasswordEncoder().encode(user.getPassword());
			user.setPassword(hash);
			Set<Role> roles = new HashSet<>();
			Role role = roleRepository.findByName("USER");
			roles.add(role);
			user.setRoles(new HashSet<Role>(Arrays.asList(role)));
			userService.save(user);
		} catch(Exception e){
			redirAttrs.addFlashAttribute("error", e.getMessage());
		}
	
		return "login";
	}
}