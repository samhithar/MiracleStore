package com.mss.app.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name="TBL_category")
public class Category {

	@Id
	@Column(name="category_name", nullable = false)
	@NotBlank
	private String categoryName;
	
	@ManyToMany(mappedBy="categories")
	private Set<Product> products;
	
	@ManyToMany
	@JoinTable(name="category_brand", joinColumns={@JoinColumn(name="category_name_fk", nullable = false)},inverseJoinColumns={@JoinColumn(name="brand_name_fk", nullable = false)})
	private Set<Brand> brands;
	
	
	public Category(){
		
	}
	
	public Category(String categoryName) {
		super();		
		this.categoryName = categoryName;
	}
	
	
	
	public Category(String categoryName, Set<Product> products,
			Set<Brand> brands) {
		super();
		this.categoryName = categoryName;
		this.products = products;
		this.brands = brands;
	}

	public Set<Brand> getBrands() {
		return brands;
	}

	public void setBrands(Set<Brand> brands) {
		this.brands = brands;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
