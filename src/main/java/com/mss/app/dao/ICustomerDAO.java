package com.mss.app.dao;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mss.app.entity.Customer;

public interface ICustomerDAO {
	
	
	public void addCustomer(Customer customer);
	
	public Customer getCustomerById(String id);
	
	public List<Customer> getCustomers();
	
	public void addCustomer(List<Customer> customers);
	
	public void updateCustomer(Customer customer);

	String getCustomerEmail(String customerId);

	String getCustomerName(String customerId);
}
