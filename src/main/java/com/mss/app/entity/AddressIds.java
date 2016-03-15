package com.mss.app.entity;

import javax.persistence.Entity;

import com.mss.app.entity.Address;

@Entity
public class AddressIds {

	private Address shippingID;
	private Address billingId;
	public Address getShippingID() {
		
		return shippingID;
	}
	public void setShippingID(Address shippingID) {
		this.shippingID = shippingID;
	}
	public Address getBillingId() {
		return billingId;
	}
	public void setBillingId(Address billingId) {
		this.billingId = billingId;
	}
	
}
