package com.mss.app.entity;



public class Roles {
	
	
	private String customerId;
	String authority;
		
	private Customer customer;
	
	public Roles(){
		
	}
	public Roles(String customerId) {
		super();
		this.customerId = customerId;
	}



	public Roles(String customerId, String authority) {
		super();
		this.customerId = customerId;
		this.authority = authority;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
}
