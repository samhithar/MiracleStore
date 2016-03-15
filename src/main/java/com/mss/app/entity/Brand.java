package com.mss.app.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;



@Entity
@Table(name = "TBL_brand")
public class Brand {

	@Id
	@Column(name = "brand_name", nullable = false)
	@NotBlank
	private String brandName;
	
	@OneToMany(mappedBy="brand")
	private Set<Product> products;
	
	@ManyToMany(mappedBy="brands")
	private Set<Category> categories;
	
	public Brand() {

	}

	public Brand(String brandName) {
		super();
		this.brandName = brandName;
	}
		

	public Brand(String brandName, Set<Product> products,
			Set<Category> categories) {
		super();
		this.brandName = brandName;
		this.products = products;
		this.categories = categories;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}


}
