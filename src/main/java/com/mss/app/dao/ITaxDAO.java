package com.mss.app.dao;

import com.mss.app.entity.TaxCalcUtil;

public interface ITaxDAO {

	public TaxCalcUtil responseTax();
	public double getTotalAmount();
	public double getTax();
	public double getProductPrice();
	
	
}
