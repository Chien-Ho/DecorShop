package com.aptech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aptech.dto.ProductDTO;
import com.aptech.model.Category;
import com.aptech.model.Product;
import com.aptech.service.ICategoryService;
import com.aptech.service.IProductService;
@Controller
@RequestMapping("/admin")
public class ProductController {
	@Autowired
	private IProductService productService;
	@Autowired
	private ICategoryService categoryService;
	@GetMapping("/product-list")
	public String List(Pageable pageable,Model model) {
		
		Page<Product> products = productService.findAll(pageable);
		
		model.addAttribute("number",products.getNumber());
		model.addAttribute("size",products.getSize());
		model.addAttribute("totalElements",products.getTotalElements());
		model.addAttribute("totalPages",products.getTotalPages());
		model.addAttribute("productList",products);
		return "admin/product-list";
	}
	@GetMapping("/product-add")
	public String Add(@RequestParam(value="id", required = false) Long id,Model model) {
		Product product = new Product();
		product.setFeatured(true);
		product.setStatus(true);
		if(id!=null) {
			product = productService.findById(id);
		}
		model.addAttribute("parentList", categoryService.findParentCategory());
		model.addAttribute("product", product);
		return "admin/product-add";
	}
	@PostMapping("/product-add")
	public String add(@ModelAttribute("product") Product product) {
		
		productService.save(product);
		return "redirect:/admin/product-list?page=0&size=5";
		
	}
	@GetMapping("/product-detele/{id}")
	public String detele(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		try {
		productService.delete(id);
		}catch(Exception ex){
		redirectAttributes.addAttribute("error", "delete failed");
		}
		return "redirect:/admin/product-list?page=0&size=5";
		
	}

}
