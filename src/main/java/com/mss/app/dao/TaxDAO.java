package com.mss.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.mss.app.entity.TaxCalcUtil;

public class TaxDAO implements ITaxDAO{

	@Override
	public double getTotalAmount() {
		System.out.println("in total amount");
		TaxCalcUtil totalAmount = responseTax();
		double amountWithTax = totalAmount.getTotalAmount();
		System.out.println("after total amount");
    	return amountWithTax;
	}
	
	@Override
	public double getTax(){
		TaxCalcUtil totalAmount = responseTax();
		double taxAmount = totalAmount.getTax();
    	return taxAmount;
	}

	@Override
	public TaxCalcUtil responseTax() {
		TaxCalcUtil tax = new TaxCalcUtil();
		System.out.println(tax.getAmount()+"in taxdao");
	 	tax.setState(tax.getState());
	 	tax.setAmount(tax.getAmount());
	 	
	 	RestTemplate restTemplate = new RestTemplate();
    	List<HttpMessageConverter<?>> list = new ArrayList<HttpMessageConverter<?>>();
    	list.add(new MappingJacksonHttpMessageConverter());
    	restTemplate.setMessageConverters(list);
    	
    	TaxCalcUtil taxResponse = restTemplate.postForObject("http://10.0.0.15:8080/TaxME/check/tax", tax, TaxCalcUtil.class);
    	System.out.println("after service call");

		return taxResponse;
	}

	@Override
	public double getProductPrice() {
		TaxCalcUtil totalAmount = responseTax();
		double productsAmount = totalAmount.getAmount();
    	return productsAmount;
		
	}
	

}
