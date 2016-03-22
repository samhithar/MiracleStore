package com.mss.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mss.app.dao.IAddressDAO;
import com.mss.app.dao.ICustomerDAO;
import com.mss.app.entity.Address;
import com.mss.web.validator.RegisterValidator;

@Controller
public class AddressController {
	
	@Autowired
	private RegisterValidator registerValidator;
	
	@Autowired
	private IAddressDAO addressDAO;
	
	@Autowired
	private ICustomerDAO customerDAO;
	
	Boolean addressFound=false;
	
	
	@ModelAttribute("customerAddressList")
	public List<Address> getAddresses(){
		
		//SecurityContextHolder.getContext().getAuthentication().getName()
		
		List<Address> customerAddressList = addressDAO.getAddressByCustomerId(SecurityContextHolder.getContext().getAuthentication().getName());
		
		
		return customerAddressList;
		
	}
	
	
	@RequestMapping(value="/addressProcess",method=RequestMethod.GET)
	public String showRegisterView(ModelMap modelMap, HttpServletRequest request){
		
		Address address = new Address();
		
		if(request.getParameter("edit")!=null){
			address = addressDAO.getAddressById(Integer.parseInt(request.getParameter("editAddress")));		
		}
		if(request.getParameter("delete")!=null){
			address = addressDAO.getAddressById(Integer.parseInt(request.getParameter("delAddress")));
			addressDAO.deleteAddress(address.getAddressId());			
			return "redirect:/addressProcess";
		}
				
			
		modelMap.addAttribute("address", address);
		
		return "addressbook";
	}
	
	@RequestMapping(value="/addressProcess",method=RequestMethod.POST)
	public String processRegister(@ModelAttribute("address") @Valid Address address,BindingResult bindingResult,Model model, HttpServletRequest request, RedirectAttributes redirectAttributes){
				
	
		if(bindingResult.hasErrors()){			
			return "addressbook";
		}
		
		address.setCustomer(customerDAO.getCustomerById(SecurityContextHolder.getContext().getAuthentication().getName()));
		
		for(int id : addressDAO.getAddressIds(address.getCustomer().getCustomerId())){			
			if(id==address.getAddressId()){				
				addressFound=true;
				break;
			}
		}
		
		if(addressFound){
			addressDAO.updateAddress(address);
		}	
		else{	    		
    		if(addressDAO.getAddressByCustomerId(SecurityContextHolder.getContext().getAuthentication().getName()).size()<5){    			
    			addressDAO.addAddress(address);
    			model.addAttribute("address", address);
    		return "redirect:/addressProcess";
    		}
    		else{
    			redirectAttributes.addFlashAttribute("message", "Cannot add more than 5 addresses");
    			return "redirect:/addressProcess";
    		}
				
		}	
		return "redirect:/addressProcess";
	}

}
