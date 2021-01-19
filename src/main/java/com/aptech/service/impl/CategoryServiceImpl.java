package com.aptech.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aptech.repository.CategoryRepository;
import com.aptech.service.ICategoryService;
import com.aptech.model.Category;

@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	

	

	@Override
	@Transactional
	public Category save(Category category) {
		
		if(category.getId()!= null) {
			Category category2 = new Category();
			category2.setId(category.getId());
			category2.setName(category.getName());
			category2.setStatus(category.isStatus());
			category2.setChildren(category.getChildren());
			category2.setParent(category.getParent());
			return categoryRepository.save(category2);
		} else{
			return categoryRepository.save(category);
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {
			categoryRepository.deleteById(id);
		
	}



	@Override
	public Page<Category> findById(Long id,Pageable pageable) {
		
		return categoryRepository.findById(id, pageable);
	}



	@Override
	public Page<Category> findAll(Pageable pageable) {
		
		return categoryRepository.findAll(pageable);
	}



	@Override
	public int getTotalItem() {
		return (int) categoryRepository.count();
	}





	@Override
	public List<Category> findParentCategory() {
		
		return categoryRepository.findParentCategory();
	}





	@Override
	public Page<Category> findParentCategory(Pageable pageable) {
		// TODO Auto-generated method stub
		return categoryRepository.findParentCategory(pageable);
	}





	@Override
	public Category findById(Long id) {
		
		return categoryRepository.findById(id).get();
	}





	@Override
	public Category saveSub(Category category) {
		
		return categoryRepository.save(category);
	}





	@Override
	public List<Category> findParentCategoryWithStatus(boolean status) {
		
		return categoryRepository.findParentCategoryWithStatus(status);
	}



	

	


}
