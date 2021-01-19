package com.aptech.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aptech.model.Category;
@Service
public interface ICategoryService {
	public List<Category> findAll();
	public Category findById(Long id);
	public Page<Category> findById(Long id, Pageable pageable);
	public Page<Category> findAll(Pageable pageable);
	public Page<Category> findParentCategory(Pageable pageable);
	public List<Category> findParentCategory();
	public List<Category> findParentCategoryWithStatus(boolean status);
	public Category save(Category category);
	public Category saveSub(Category category);
	public void delete(Long id);
	int getTotalItem();
}
