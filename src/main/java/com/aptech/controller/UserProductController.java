package com.aptech.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aptech.model.BillDetail;
import com.aptech.model.Bills;
import com.aptech.model.Category;
import com.aptech.model.Item;
import com.aptech.model.Product;
import com.aptech.repository.BillsDetailRepository;
import com.aptech.repository.BillsRepository;
import com.aptech.service.ICategoryService;
import com.aptech.service.IProductServiceUser;
import com.aptech.service.impl.BillDetailService;
import com.aptech.service.impl.BillsService;

@Controller
public class UserProductController {
	@Autowired 
	private ICategoryService categoryService;
	@Autowired 
	private IProductServiceUser productServiceUser;
	@Autowired 
	private BillsService billsService;
	@Autowired 
	private BillDetailService billDetailService;

	@GetMapping("/product-category/{id}")
	public String productCategory(Model model,@PathVariable Long id) {
		model.addAttribute("categoryParent",categoryService.findParentCategory());
		model.addAttribute("category",categoryService.findById(id));
	
		return "user/product-category";
	}

	@GetMapping("/detail/{id}")
	public String productDetail(Model model,@PathVariable Long id) {
		model.addAttribute("categoryParent",categoryService.findParentCategory());
		Product product = productServiceUser.findById(id);
		model.addAttribute("product",product);
		List<Product> p = productServiceUser.relatedProduct(true, product.getCategory().getId(), 6);
		model.addAttribute("relatedProducts",p);
		model.addAttribute("id",id);
		return "user/product-detail";
	}
	@GetMapping("/user-search")
	public String userSearch(@RequestParam(value="keywords") String keywords,@RequestParam(value="categoryId") int categoryId,Model model) {
		List<Product> productSearch = null;
		if(categoryId == -1) {
			productSearch = productServiceUser.searchAll(true, keywords);
		}else {
			productSearch = productServiceUser.searchByCategory(true, categoryId, keywords);
		}
		model.addAttribute("categoryParent",categoryService.findParentCategory());
		model.addAttribute("productSearch", productSearch);
		model.addAttribute("keywords", keywords);
		return "user/product-search";
	}
	@GetMapping("/cart/{id}")
	public String cart(Model model,@PathVariable Long id, HttpSession session) {
		if(session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<>();
			cart.add(new Item(productServiceUser.findById(id),1));
			session.setAttribute("cart", cart);
		}else {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index = exist(id, cart);
			if(index == -1) {
				cart.add(new Item(productServiceUser.findById(id),1));
			}else {
				int newQuantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(newQuantity);
			}
			
			session.setAttribute("cart", cart);
			
		}
		
		return "redirect:/cart-index";
	}
	@GetMapping("/remove-cart/{id}")
	public String removeCart(Model model,@PathVariable Long id, HttpSession session) {
		if(session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<>();
			cart.add(new Item(productServiceUser.findById(id),1));
			session.setAttribute("cart", cart);
		}else {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			for(int i=0; i < cart.size();i++) {
				
				if(cart.get(i).getProduct().getId() == id) {
					cart.remove(i);
				}
			}
			session.setAttribute("cart", cart);
		}
		
		return "redirect:/cart-index";
	}
	public int exist(Long id, List<Item> cart) {
		for(int i=0; i < cart.size();i++) {
			
			if(cart.get(i).getProduct().getId() == id) {
				return i;
			}
		}
		return -1;
		
	}
	@GetMapping("/cart-index")
	public String cartIndex(Model model,HttpSession session) {
		model.addAttribute("categoryParent",categoryService.findParentCategory());
		int total= 0;
		if(session.getAttribute("cart") != null) {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			
			for(Item item: cart) {
				total += item.getProduct().getPrice()* item.getQuantity();
			}
		}
		model.addAttribute("total", total);
		return "user/cart";
	}
	@PostMapping("/update-cart")
	public String updateCart(Model model,HttpSession session,@RequestParam("quantities") int[] quantities) {
		if(session.getAttribute("cart") != null) {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			
			for(int i=0; i<cart.size(); i++) {
				cart.get(i).setQuantity(quantities[i]);
			}
			session.setAttribute("cart", cart);
		}
		return "redirect:/cart-index";
	}
	@GetMapping("/checkout")
	public String checkout(Model model, Authentication authentication,HttpSession session) {
		int total= 0;
		if(session.getAttribute("cart") != null) {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			
			for(Item item: cart) {
				total += item.getProduct().getPrice()* item.getQuantity();
			}
			session.setAttribute("cart", cart);
		}
		
		model.addAttribute("total", total);
		model.addAttribute("categoryParent",categoryService.findParentCategory());
	
		if(authentication == null) {
			return "login";
		}else {
			model.addAttribute("bills", new Bills());
			return "user/checkout";
		}
	
	}
	@PostMapping("/checkout")
	public String saveBills(Model model, Bills bills, HttpSession session) {
		bills.setDate(new Timestamp(new Date().getTime()));
		bills.setStatus(true);
		billsService.save(bills);
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		for(Item item : cart) {
			BillDetail billDetail = new BillDetail();
			billDetail.setBills(bills);
			billDetail.setProduct(item.getProduct());
			billDetail.setPrice(item.getProduct().getPrice());
			billDetail.setQuantity(item.getQuantity());
			billDetail.setStatus(true);
			billDetailService.save(billDetail);
		}
		session.removeAttribute("cart");
		return "redirect:/?checkoutSuccess";
	}


}
