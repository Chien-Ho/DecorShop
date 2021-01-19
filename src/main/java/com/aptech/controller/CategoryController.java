package com.aptech.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aptech.dto.AbstractDTO;
import com.aptech.dto.CategoryDTO;
import com.aptech.model.Category;
import com.aptech.service.ICategoryService;


@Controller
@RequestMapping("/admin")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;
	@GetMapping("/category-list")
	public String List( Pageable pageable,Model model) {
		
		Page<Category> categories = categoryService.findParentCategory(pageable);
		model.addAttribute("number",categories.getNumber());
		model.addAttribute("size",categories.getSize());
		model.addAttribute("totalElements",categories.getTotalElements());
		model.addAttribute("totalPages",categories.getTotalPages());
		model.addAttribute("parentList",categories);
		return "admin/category-list";
	}
	@GetMapping("/category-add")
	public String Add(@RequestParam(value="id", required = false) Long id, Model model) {
		Category category = new Category();
		if(id!= null) {
			category = categoryService.findById(id);
		}
		category.setStatus(true);
		model.addAttribute("parent", category);
		return "admin/category-add";
	}
	@GetMapping("/subCategory-list/{id}")
	public String subList(@PathVariable("id") Long id, Pageable pageable,Model model) {
//		model.addAttribute("parent", categoryService.findById(id));
		Page<Category> categories = categoryService.findById(id, pageable);
		model.addAttribute("number",categories.getNumber());
		model.addAttribute("size",categories.getSize());
		model.addAttribute("totalElements",categories.getTotalElements());
		model.addAttribute("totalPages",categories.getTotalPages());
		int ele =  (int) (categories.getTotalElements()/categories.getTotalPages());
		model.addAttribute("ele",ele);
		model.addAttribute("categoryId",id);
		model.addAttribute("parent",categories);
		return "admin/subcategory-list";
	}
	@GetMapping(value={"/subCategory-add/{pId}/{cId}","/subCategory-add/{pId}"})
	public String subAdd(@PathVariable(value = "pId") Long pId,@PathVariable(value = "cId",required = false) Long cId, Model model) {
		Category category = new Category();
		if(cId!=null) {
			category = categoryService.findById(cId);
		}
		category.setParent(categoryService.findById(pId));
		category.setStatus(true);
		model.addAttribute("category", category);
		return "admin/subcategory-add";
	}
	@PostMapping("/category-add")
	public String add(@ModelAttribute("category") Category category) {
		
		categoryService.save(category);
		return "redirect:/admin/category-list?page=0&size=5";
		
	}
	@GetMapping("/category-detele/{id}")
	public String detelePr(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		try {
		categoryService.delete(id);
		}catch(Exception ex){
		redirectAttributes.addAttribute("error", "delete failed");
		}
		return "redirect:/admin/category-list?page=0&size=5";
		
	}
	@PostMapping("/subcategory-add")
	public String subAdd(@ModelAttribute("category") Category category) {
		
		categoryService.saveSub(category);
		return "redirect:/admin/category-list?page=0&size=5";
		
	}
	@GetMapping("/subcategory-detele/{id}")
	public String deteleSub(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		try {
		categoryService.delete(id);
		}catch(Exception ex){
		redirectAttributes.addAttribute("error", "delete failed");
		}
		return "redirect:/admin/subcategory-list?page=0&size=5";
		
	}

}
