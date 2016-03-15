package com.mss.app.entity;

public class CartDetails {
	
	private int productquant=2;
	private int prodspecificid=1;
    private String name = "Iphone";
	private double totalprice = 100;

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public CartDetails(){
		
	}
	public CartDetails(int productquant, int prodspecificid,String name,double totalprice) {
		super();
		this.productquant = productquant;
		this.prodspecificid = prodspecificid;
		this.name=name;
		this.totalprice=totalprice;
	}

	public int getProductquant() {
		return productquant;
	}


	public void setProductquant(int productquant) {
		this.productquant = productquant;
	}


	public int getProdspecificid() {
		return prodspecificid;
	}


	public void setProdspecificid(int prodspecificid) {
		this.prodspecificid = prodspecificid;
	}


}
