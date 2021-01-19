package com.aptech.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aptech.dto.ProductDTO;
import com.aptech.model.Category;
import com.aptech.model.Product;
@Service
public interface IProductService {
	public Product findById(Long id);
	Page<Product> findById(Long id, Pageable pageable);
	public Product save(Product product);
	public Product save(ProductDTO productDTO);
	public void  delete(Long id);
	Page<Product> findAll(Pageable pageable);

}
