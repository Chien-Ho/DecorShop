package com.aptech.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aptech.model.Product;
import com.aptech.service.IProductService;
@RestController
@RequestMapping("/product")
public class ProductAPI {
	@Autowired
	private IProductService productService;
//	@PostMapping
//	public Product add(@ModelAttribute Product product) {
//		return productService.save(product);
//		
//	}
//	@PutMapping
//	public Product update(@ModelAttribute Product product) {
//		return productService.save(product);
//		
//	}
//	@DeleteMapping
//	public void delete(@RequestBody Long[] ids) {
//		productService.delete(ids);
//	}

}
