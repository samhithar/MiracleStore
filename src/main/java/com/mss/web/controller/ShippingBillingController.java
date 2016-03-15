package com.mss.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mss.app.entity.AddressIds;
import com.mss.app.dao.IAddressDAO;
import com.mss.app.dao.ICustomerDAO;
import com.mss.app.entity.Address;
import com.mss.app.entity.Customer;

@Controller
@SessionAttributes({"billAddress", "shipAddress"})
public class ShippingBillingController {
	@Autowired
	private IAddressDAO addressDAO;
	
	@Autowired 
	private ICustomerDAO customerDAO;
	
	int editShip=0;
	int editBill=0;
	

	    public List<String> populateAddressLine1() 
	    {
	    	List<Address> populateShippingAddress =addressDAO.getAddressByCustomerId(SecurityContextHolder.getContext().getAuthentication().getName());
	        List<String> shippingAddressLine1List = new ArrayList<String>();

	        for(Address address1:populateShippingAddress){
				shippingAddressLine1List.add(address1.getAddressLine1());
			}
	        return shippingAddressLine1List;
	    }
	 
	    @RequestMapping(value="/addressController",method = RequestMethod.GET)
	    public String setupFormBilling(ModelMap modelMap, HttpServletRequest request, HttpSession session, Model model) {
	    	
	    	AddressIds ids = new AddressIds();
	    	
	    	Address address = new Address();
	    	
	    	
	    	List<String> addressLine1List= populateAddressLine1();
	    	
	    	modelMap.addAttribute("addressLine1List", addressLine1List);
	    	
	    	if(request.getParameter("editShip")!=null){
	    		editShip = Integer.parseInt(request.getParameter("editShipAddress"));
	    		address = addressDAO.getAddressById(editShip);

	    	}
	    	
	    	if(request.getParameter("editBill")!=null){
	    		editBill = Integer.parseInt(request.getParameter("editBillAddress"));
	    		System.out.println(request.getParameter("editBillAddress") + "from edit");
	    		address = addressDAO.getAddressById(editBill);

	    	}
	    	
	    	System.out.println("address COntroller get");
	    	modelMap.addAttribute("address", address);
	    	modelMap.addAttribute("ids",ids);
	    	
	    	return "shipping_address";
	    	
	    }
	    
	    @RequestMapping(value="/addressController",method = RequestMethod.POST)
	    public String submitForm(AddressIds ids, Model model,Map map, HttpServletRequest request, @RequestParam("billing1") String billing1) {
	    	
	    	if(request.getParameter("shipping1")!=null && request.getParameter("billing1")!=null){
	    		System.out.println(request.getParameter("shipping1") +  "shipping address jsp");
	    		String addressShip1 = request.getParameter("shipping1");
	    		System.out.println(request.getParameter("billing1") + "billing address jsp");
	    		String adddressBill1 = request.getParameter("billing1");
	    		
	    		List<Address> shipAddress = addressDAO.getDatabyLine1(addressShip1, SecurityContextHolder.getContext().getAuthentication().getName());
	    		model.addAttribute("shipAddress", shipAddress);
	    		
	    		List<Address> billAddress = addressDAO.getDatabyLine1(adddressBill1, SecurityContextHolder.getContext().getAuthentication().getName());
	    		model.addAttribute("billAddress", billAddress);
	    		
	    		String shipState = shipAddress.get(0).getState();
		    	model.addAttribute("shipState", shipState);
		    	System.out.println(shipAddress.get(0).getState());
		    	return "redirect:/paymentController";
	    	}
	    	else return null;
	   }
	    
	    @RequestMapping(value="/modifyAddressController", method=RequestMethod.POST)
	    public String modifyAddress( @Validated Address address, BindingResult bindingResult, HttpServletRequest request, RedirectAttributes redirectAttributes){
	    	
	    	
	    	if(bindingResult.hasErrors()){
	    		return "shipping_address";
	    	}
	    	
	    	int id = address.getAddressId();
	    	if(id>0){
	    		addressDAO.updateAddress(address);
		    	return "redirect:/addressController";
	    	}else{	    		
	    		if(addressDAO.getAddressByCustomerId(SecurityContextHolder.getContext().getAuthentication().getName()).size()<5){
	    			address.setCustomer(customerDAO.getCustomerById(SecurityContextHolder.getContext().getAuthentication().getName()));
	    			addressDAO.addAddress(address);
	    		return "redirect:/addressController";
	    		}
	    		else{
	    			redirectAttributes.addFlashAttribute("message", "Cannot add more than 5 addresses");
	    			return "redirect:/addressController";
	    		}
	    	}
	    	
	    }
	    
	   
	    

}
