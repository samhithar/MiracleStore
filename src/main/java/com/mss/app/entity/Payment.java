package com.mss.app.entity;

import javax.persistence.Entity;

import com.mss.app.dao.ITaxDAO;
import com.mss.app.dao.TaxDAO;

@Entity
public class Payment {

	private String cardNumber;	
   	private String expDate;
   	private int cvv;
   	private String cardHolderName;  
	private String merchid;
   	private double amount;
   	private String result;
   	private double tax;
   	private double productPrice;
   	
   	public double getProductPrice() {
   		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public Payment(double amount, String merchid, String result) {
		super();
		this.amount = amount;
		this.merchid = merchid;
		this.result = result;
	}

	public Payment(){
		
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getMerchid() {
		return merchid;
	}

	public void setMerchid(String merchid) {
		this.merchid = merchid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Payment(String cardNumber, String expDate, int cvv, String cardHolderName, String merchid, double amount) {
		super();
		this.cardNumber = cardNumber;
		this.expDate = expDate;
		this.cvv = cvv;
		this.cardHolderName = cardHolderName;
		this.merchid = merchid;
		this.amount = amount;
	}
	}
