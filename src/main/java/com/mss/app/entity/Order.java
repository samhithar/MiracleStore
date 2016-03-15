package com.mss.app.entity;

import java.util.Date;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="TBL_order")
//@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class Order {
	
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Id    
	@Column(name="order_id", nullable = false)	
	private int orderId;	
	@Column(name="billing_address_id", nullable = false)
	private int billingAddressId;
	@Column(name="shipping_address_id", nullable = false)
	private int shippingAddressId;
	@Column(name="amount", nullable = false)
	private double amount;
	@Column(name="status", nullable = false)
	private String status;
	@Column(name="date", nullable = false)
	private String date;
	
	@ManyToMany
	@JoinTable(name="order_product", joinColumns={@JoinColumn(name="order_id_fk", nullable = false)},inverseJoinColumns={@JoinColumn(name="product_id_fk", nullable = false)})
	private Set<Product> products;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id_fk", nullable = false)
	private Customer customer;
	
	public Order(){
		
	}
		
	public Order(int orderId, int billingAddressId, int shippingAddressId,
			double amount, String status, String date) {
		super();
		this.orderId = orderId;
		this.billingAddressId = billingAddressId;
		this.shippingAddressId = shippingAddressId;
		this.amount = amount;
		this.status = status;
		this.date = date;
	}

	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order(int orderId, int billingAddressId, int shippingAddressId,
			double amount, String status, String date, Customer customer) {
		super();
		this.orderId = orderId;
		this.billingAddressId = billingAddressId;
		this.shippingAddressId = shippingAddressId;
		this.amount = amount;
		this.status = status;
		this.date = date;
		this.customer = customer;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getBillingAddressId() {
		return billingAddressId;
	}
	public void setBillingAddressId(int billingAddressId) {
		this.billingAddressId = billingAddressId;
	}
	public int getShippingAddressId() {
		return shippingAddressId;
	}
	public void setShippingAddressId(int shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
