package com.aptech.dto;

import java.util.ArrayList;
import java.util.List;


import com.aptech.model.Category;
import com.aptech.model.Product;

public class CategoryDTO extends AbstractDTO<CategoryDTO>{
	private Category parent;
	private List<Category> children = new ArrayList<>(); 
	private List<Product> products = new ArrayList<>();
	public Category getParent() {
		return parent;
	}
	public void setParent(Category parent) {
		this.parent = parent;
	}
	public List<Category> getChildren() {
		return children;
	}
	public void setChildren(List<Category> children) {
		this.children = children;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
