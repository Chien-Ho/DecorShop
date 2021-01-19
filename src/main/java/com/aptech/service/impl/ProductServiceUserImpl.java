package com.aptech.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aptech.dto.ProductDTO;
import com.aptech.model.Category;
import com.aptech.model.Product;
import com.aptech.repository.CategoryRepository;
import com.aptech.repository.ProductRepository;
import com.aptech.service.IProductService;
import com.aptech.service.IProductServiceUser;
@Service
public class ProductServiceUserImpl implements IProductServiceUser{
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAllByStatus(boolean status, int limit) {
		
		return productRepository.findAllByStatus(status,limit);
	}

	@Override
	public List<Product> findAllByStatusAndFeatured(boolean status, boolean featured, int limit) {
		return productRepository.findAllByStatusAndFeatured(status, featured, limit);
	}

	@Override
	public Product findById(Long id) {
		return productRepository.findById(id).get();
	}

	@Override
	public List<Product> relatedProduct(boolean status, Long categoryId, int limit) {
		
		return productRepository.relatedProduct(status, categoryId, limit);
	}

	@Override
	public List<Product> searchByCategory(boolean status, int categoryId, String keywords) {
		return productRepository.searchByCategory(status, keywords, categoryId);
	}

	@Override
	public List<Product> searchAll(boolean status, String keywords) {
		
		return productRepository.searchAll(status, keywords);
	}
	

}
