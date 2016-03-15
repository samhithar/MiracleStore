package com.mss.web.controller;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mss.app.dao.ICustomerDAO;
import com.mss.app.dao.PasswordEncoder;
import com.mss.app.entity.Customer;

@Controller
public class UpdateProfileController {

	@Autowired
	private ICustomerDAO customerDAO;
	
	public Customer customerDetails;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
		
		
	@RequestMapping(value="/updateProfileProcess",method=RequestMethod.GET)
	public String showUpdateProfileView(ModelMap modelMap){
		
		customerDetails = customerDAO.getCustomerById(SecurityContextHolder.getContext().getAuthentication().getName());
		
		Customer customer = new Customer();
		//register the object as a command object
		modelMap.addAttribute("customer", customer);
		modelMap.addAttribute("customerDetails", customerDetails);
		
		      //input jsp 
		return "myaccount";
	}
	
	@RequestMapping(value="/updateProfileProcess",method=RequestMethod.POST)
	public String processUpdateProfile(@ModelAttribute("customer") @Valid Customer customer,BindingResult bindingResult, Model model){
		
		if(bindingResult.hasErrors()){
			System.out.println("errors");
			return "myaccount";
			
		}
		
		customer.setPassword(passwordEncoder.passwordEncoder().encode(customer.getPassword()));
		customerDAO.updateCustomer(customer);
		model.addAttribute("customer", customer);
		
		return "redirect:/updateProfileProcess";
	}

}
