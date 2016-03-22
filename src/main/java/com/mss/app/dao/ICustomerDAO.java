package com.mss.app.dao;

import java.util.List;

import com.mss.app.entity.Customer;
import com.mss.app.entity.Roles;

public interface ICustomerDAO {
	
	
	public void addCustomer(Customer customer);
	
	public void addRole(Roles role);
	
	public Customer getCustomerById(String id);
	
	public List<Customer> getCustomers();
	
	public void addCustomer(List<Customer> customers);
	
	public void updateCustomer(Customer customer);

	String getCustomerEmail(String customerId);

	String getCustomerName(String customerId);
	
	public void deleteCustomer(String customerId);
}
