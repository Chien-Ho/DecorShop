package com.aptech.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.aptech.model.Category;
import com.aptech.model.Item;
import com.aptech.model.Photo;
import com.aptech.model.Product;
import com.aptech.service.ICategoryService;
import com.aptech.service.IProductServiceUser;

@Controller
public class Index {
	@Autowired 
	private ICategoryService categoryService;
	@Autowired 
	private IProductServiceUser productServiceUser;

	@GetMapping("/")
	public String index(Model model,HttpSession session) {
	
		model.addAttribute("categoryParent",categoryService.findParentCategory());
		List<Product> featured = productServiceUser.findAllByStatusAndFeatured(true, true, 9);
		int total= 0;
		if(session.getAttribute("cart") != null) {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			
			for(Item item: cart) {
				total += item.getProduct().getPrice()* item.getQuantity();
			}
			session.setAttribute("cart", cart);
		}
		
		model.addAttribute("total", total);
		model.addAttribute("featuredProduct",featured);
		return "user/index";
	}

}
