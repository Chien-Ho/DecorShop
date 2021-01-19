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
@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryServiceImpl categoryService;


	@Override
	public Product findById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).get();
	}

	@Override
	@Transactional
	public Product save(Product product) {
		Category category = categoryService.findById(product.getCategory().getId());
		Product entity = new Product();
		if(product.getId()!= null) {
			entity.setId(product.getId());
			entity.setName(product.getName());
			entity.setStatus(product.isStatus());
			entity.setContent(product.getContent());
			entity.setDescription(product.getDescription());
			entity.setFeatured(product.isFeatured());
			entity.setPrice(product.getPrice());
			entity.setQuantity(product.getQuantity());
			entity.setPhotos(product.getPhotos());
			entity.setCategory(category);
			return productRepository.save(entity);
		} else{
			product.setCategory(category);
			return productRepository.save(product);
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {
		productRepository.deleteById(id);
		
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	@Override
	public Product save(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Product> findById(Long id, Pageable pageable) {
		
		return productRepository.findById(id, pageable);
	}

}
