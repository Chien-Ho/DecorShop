package com.aptech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aptech.model.Product;
@Service
public interface IProductServiceUser {
	public Product findById(Long id);
	List<Product> findAllByStatus(boolean status, int limit);
	List<Product> findAllByStatusAndFeatured(boolean status, boolean featured, int limit);
	List<Product> relatedProduct(boolean status, Long categoryId, int limit);
	List<Product> searchByCategory(boolean status, int categoryId, String keywords);
	List<Product> searchAll(boolean status, String keywords);


}
