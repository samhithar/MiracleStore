package com.mss.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;


public class OrderConfirmation {

	//Order ID
	private int orderID;
	
	//EMAIL Id details
	private String email;
	
	//Payment Details
	private String cardNumber;
	private String cardHolderName;
	private double totalAmount;
	
	public double getTotalAmount() {
//		Payment amount = new Payment();
//		totalAmount = amount.getAmount();
		return totalAmount;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}


		//Shipping Address Details
		private String addressLine1;
		private String addressLine2;
		private String city;
		private String state;
		private String zipcode;
		
	//addressID details
		private int billingId;
		private int shippingId;
	
	//Product Details
		private List<CartDetails> cartDetails;
		
	
	public OrderConfirmation(int orderID, String email, String cardNumber, String cardHolderName,
				String addressLine1, String addressLine2, String city, String state, String zipcode, List<CartDetails> cartDetails,
				 double totalAmount) {
			super();
			this.orderID = orderID;
			this.email = email;
			this.cardNumber = cardNumber;
			this.cardHolderName = cardHolderName;
			this.addressLine1 = addressLine1;
			this.addressLine2 = addressLine2;
			this.city = city;
			this.state = state;
			this.zipcode = zipcode;
			this.cartDetails = cartDetails;
			this.totalAmount=totalAmount;
		}


	public OrderConfirmation() {
		super();
	}
	
	
	public OrderConfirmation(int orderID, String addressLine1, String addressLine2, String city, String state,
			String zipcode, String email, String cardNumber, String cardHolderName) {
		super();
		this.orderID = orderID;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.email = email;
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
	}


	public int getOrderID() {
//		 String orderID = UUID.randomUUID().toString();
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}


	public int getBillingId() {
		return billingId;
	}


	public void setBillingId(int billingId) {
		this.billingId = billingId;
	}


	public int getShippingId() {
		return shippingId;
	}


	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
	}


	public List<CartDetails> getCartDetails() {
		CartDetails cartDetailsList = new CartDetails();
		cartDetailsList.getName();
		cartDetailsList.getProductquant();
		cartDetailsList.getTotalprice();
		List<CartDetails> cartDetails = new ArrayList<CartDetails>();
		cartDetails.add(cartDetailsList);
		System.out.println(cartDetailsList.getName() + "in order confirmation");
		return cartDetails;
	}


	public void setCartDetails(List<CartDetails> cartDetails) {
		
		this.cartDetails = cartDetails;
	}
	
	
	
	
}
