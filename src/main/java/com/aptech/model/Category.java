package com.aptech.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="category")
public class Category extends AbstractModel{
	private String name;
	// self-referencing relationship
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="parent_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Category parent;
	@OneToMany(mappedBy = "parent")
	private List<Category> children = new ArrayList<>(); 
	// match product
	@OneToMany(mappedBy = "category")
	private List<Product> products = new ArrayList<>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
