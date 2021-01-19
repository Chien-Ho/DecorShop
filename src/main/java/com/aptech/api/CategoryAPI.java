package com.aptech.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aptech.model.Category;
import com.aptech.service.ICategoryService;
@RestController
@RequestMapping("/category")
public class CategoryAPI {
	@Autowired
	private ICategoryService categoryService;
	@GetMapping
	public List<Category> getCategory() {
		List<Category> categories = categoryService.findParentCategory();
		
		return categories;
		
	}
	@PostMapping
	public Category add(@RequestBody Category category) {
		category.setParent(null);
		return categoryService.save(category);
		
	}
	@PutMapping
	public Category update(@RequestBody Category category) {
		category.setParent(null);
		return categoryService.save(category);
	}


}
