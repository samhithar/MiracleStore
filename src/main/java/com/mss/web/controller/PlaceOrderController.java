package com.mss.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mss.app.dao.ICustomerDAO;
import com.mss.app.entity.Customer;

@Controller
public class PlaceOrderController {

 	@Autowired
	private ICustomerDAO customerDAO;

	@RequestMapping("/placeOrderController")
	public String validation(HttpServletRequest request, HttpSession session, HttpServletResponse response, Model model){
	
	
		/*String userName = request.getParameter("user");
		String passWord = request.getParameter("password");*/
		
			return "redirect:/shippingBillingController";
			
	}
	
	@RequestMapping(value="/checkout",method=RequestMethod.GET)
	public String showCheckout(ModelMap modelMap){
		
		return "checkout";
	}
}
