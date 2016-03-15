package com.mss.app.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="TBL_address")
public class Address {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="address_id", nullable = false)
	private int addressId;
	@Column(name="address_line1", nullable = false)
	@NotBlank
	private String addressLine1;
	@Column(name="address_line2")
	private String addressLine2;
	@Column(name="city", nullable = false)
	@NotBlank
	private String city;
	@Column(name="state", nullable = false)
	@NotBlank
	private String state;
	@Column(name="country", nullable = false)
	@NotBlank
	private String country;
	@Column(name="zipcode", nullable = false)
	@NotBlank	
	private String zipcode;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id_fk", nullable = false)
	private Customer customer;
	
	public Address(){
				
	}
	
	public Address(String addressLine1, String addressLine2, String country, String city,
			String state, String zipcode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}
	
	
	
	public Address(String addressLine1, String addressLine2, String city,
			String state, String zipcode, Customer customer) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
