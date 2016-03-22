package com.mss.web.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mss.app.dao.ICustomerDAO;
import com.mss.app.dao.PasswordEncoder;
import com.mss.app.entity.Customer;
import com.mss.app.entity.Roles;
import com.mss.web.validator.RegisterValidator;


@Controller
@SessionAttributes("username")
public class RegisterController {	
	
	@Autowired
	private RegisterValidator registerValidator;
	
	@Autowired
	private ICustomerDAO customerDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping(value="/registerProcess",method=RequestMethod.GET)
	public String showRegisterView(ModelMap modelMap){
		
		Customer customer = new Customer();

		//System.out.println(BCrypt.checkpw("mani", hashedPassword));			
		
		modelMap.addAttribute("customer", customer);
		
		return "register";
	}
	
	@RequestMapping(value="/registerProcess",method=RequestMethod.POST)
	public String processRegister(@ModelAttribute("customer") @Valid Customer customer,BindingResult bindingResult,Model model){
		
		registerValidator.validate(customer, bindingResult);
	
		if(bindingResult.hasErrors()){
			return "register";
		}
		
		customer.setPassword(passwordEncoder.passwordEncoder().encode(customer.getPassword()));
		customerDAO.addCustomer(customer);
		Roles role=new Roles(customer.getCustomerId(),"ROLE_USER");
		customerDAO.addRole(role);
		model.addAttribute("customer", customer);
		
		return "login";
		
		
	}

}
