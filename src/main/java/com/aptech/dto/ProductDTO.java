package com.aptech.dto;

import java.util.ArrayList;
import java.util.List;


import com.aptech.model.Category;
import com.aptech.model.Photo;
import com.aptech.model.Product;

public class ProductDTO extends AbstractDTO<ProductDTO>{
	private String name;
	private float price;
	private int quantity;
	private String description;
	private String content;
	private boolean featured;
	private List<Photo> photos = new ArrayList<>();
	private Category category;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isFeatured() {
		return featured;
	}
	public void setFeatured(boolean featured) {
		this.featured = featured;
	}
	public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	
	

}
