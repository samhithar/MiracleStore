package com.mss.app.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name="TBL_product")
public class Product {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="product_id", nullable = false)
	private int id;
	@Column(name="product_name", nullable = false)
	@NotBlank
	private String name;
	@Column(name="product_quantity", nullable = false)
	@NotBlank
	private int quantity;
	@Column(name="product_description", nullable = false)
	@NotBlank
	private String description;
	@Column(name="product_price", nullable = false)
	@NotBlank
	private double price;
	@Column(name="product_image", nullable = false)
	@NotBlank
	private String image;
	@Column(name = "enabled", columnDefinition = "boolean default true", nullable = false)
	private Boolean isActive = true;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="brand_name_fk")
	private Brand brand;
	
	@ManyToMany
	@JoinTable(name="product_category", joinColumns={@JoinColumn(name="product_id_fk")},inverseJoinColumns={@JoinColumn(name="category_name_fk")})
	private Set<Category> categories;
	
	@ManyToMany(mappedBy="products")
	private Set<Order> orders;
	
	public Product() {
		
	}

	
	public Product(String name, String description, int quantity, double price, String image,
			Boolean isActive) {
		super();		
		this.name = name;
		this.quantity = quantity;
		this.description = description;
		this.price = price;
		this.image = image;
		this.isActive = isActive;
	}

	public Set<Order> getOrders() {
		return orders;
	}


	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}


	public Brand getBrand() {
		return brand;
	}


	public void setBrand(Brand brand) {
		this.brand = brand;
	}


	public Set<Category> getCategories() {
		return categories;
	}


	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	

		
	

}

