package com.mss.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tbl_cartdetail")
public class DatabaseCartdetail {

	@Id
	@Column(name="userid")
	private String userid;
	@Column(name="prodprice")
	private double prodprice;
	@Column(name="prodid")
	private int prodid;
	@Column(name="prodquant")
	private int prodquant;
	@Column(name="prodname")
	private String prodname;
	
	
	
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public double getProdprice() {
		return prodprice;
	}
	public void setProdprice(double prodprice) {
		this.prodprice = prodprice;
	}
	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}
	public int getProdquant() {
		return prodquant;
	}
	public void setProdquant(int prodquant) {
		this.prodquant = prodquant;
	}
	
	
}
