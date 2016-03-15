package com.mss.web.validator;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mss.app.dao.ICustomerDAO;
import com.mss.app.entity.Customer;

@Component("registerValidator")
public class RegisterValidator implements Validator{
	
	@Autowired
	private ICustomerDAO customerDAO;
	
	List<Customer> customers = new ArrayList<Customer>();
	List<String> usernamesList = new ArrayList<String>();
	
	@PostConstruct
	public void initRegisterValidator(){
		
		customers = customerDAO.getCustomers();
		for(Customer customer : customers){
			usernamesList.add(customer.getCustomerId());
		}
	}
	
	@Override
	public boolean supports(Class<?> class1) {

		if(class1.equals(Customer.class)){
			return true;
		}		
		return false;
	}
	
	@Override
	public void validate(Object commandObject, Errors errors) {
		
		Customer customer = (Customer) commandObject;
		
		if(usernamesList.contains(customer.getCustomerId())){
			
			errors.rejectValue("customerId","error.uname.taken","username taken");
		}
		
		if(!customer.getPassword().equals(customer.getConfirmPassword())){
			errors.rejectValue("confirmPassword","error.pwd.mismatch","Password does not match");
		}
	}

}
