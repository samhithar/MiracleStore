package com.mss.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mss.app.entity.AddressIds;
import com.mss.app.dao.IAddressDAO;
import com.mss.app.dao.ICustomerDAO;
import com.mss.app.dao.IOrderDAO;
import com.mss.app.dao.IProductDAO;
import com.mss.app.entity.Address;
import com.mss.app.entity.Order;
import com.mss.app.entity.OrderConfirmation;
import com.mss.app.entity.Payment;
import com.mss.app.entity.TaxCalcUtil;


@Controller
@SessionAttributes("orderConfirmation")
public class PaymentController {
	
	@Autowired
	private IAddressDAO addressDAO;
	
	@Autowired
	private ICustomerDAO customerDAO;
	
	@Autowired
	private IProductDAO productDAO;
	
	@Autowired
	private IOrderDAO orderDAO;
	
	
	@RequestMapping(value="/paymentController",method = RequestMethod.GET)
	    public String setupForm(ModelMap modelMap, HttpSession session, Model model) {
	        
			List<Address> li = (List<Address>) session.getAttribute("shipAddress");
			String shipState = li.get(0).getState();
	
		
			TaxCalcUtil taxResponse=taxCalculation(shipState);
			
	    	Payment payment  = new Payment();
	    	payment.setProductPrice(taxResponse.getAmount());
	    	payment.setTax(taxResponse.getTax());
	    	payment.setAmount(taxResponse.getTotalAmount());
	    		        

	        modelMap.addAttribute("payment", payment);
	         
	        return "payment";

	    }
	    
	    @RequestMapping(value="/paymentController",method = RequestMethod.POST)
	    public String submitForm(@ModelAttribute("order")Order order,Payment payment, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
	    	
	    	Date date = new Date();
	    	OrderConfirmation orderConfirmation = new OrderConfirmation();
	    	
	    	RestTemplate restTemplate = new RestTemplate();
	    	List<HttpMessageConverter<?>> list = new ArrayList<HttpMessageConverter<?>>();
	    	list.add(new MappingJacksonHttpMessageConverter());
	    	list.add(new StringHttpMessageConverter());
	    	restTemplate.setMessageConverters(list);
	    	
	    	List<Address> ship = (List<Address>) session.getAttribute("shipAddress");
	    	String shipState = ship.get(0).getState();
	    	
	    	List<Address> bill = (List<Address>) session.getAttribute("billAddress");
	    	
	    	TaxCalcUtil taxResponse = taxCalculation(shipState);
	    	
	    	model.addAttribute("payment",payment);
	    	payment.setAmount(taxResponse.getTotalAmount());
	    	
	    	Payment res = restTemplate.postForObject("http://10.0.0.24:8080/PayME/charge/creditcard", payment, Payment.class);
	    	System.out.println(res.getResult());
	    	
	    	if(res.getResult().equalsIgnoreCase("invalid card")||res.getResult().equalsIgnoreCase("Invalid Card Number")){
	    		redirectAttributes.addAttribute("message","Invalid Card");
	    		return "redirect:/paymentController";
	    	}else if(res.getResult().equalsIgnoreCase("Card Expired")){
	    		redirectAttributes.addFlashAttribute("message", "You have entered a card with Expiry date");
	    		return "redirect:/paymentController";
	    	}
	    	else{
	    		
	    		orderConfirmation.setAddressLine1(ship.get(0).getAddressLine1());
	    		orderConfirmation.setAddressLine2(ship.get(0).getAddressLine2());
	    		orderConfirmation.setCity(ship.get(0).getCity());
	    		orderConfirmation.setState(ship.get(0).getState());
	    		orderConfirmation.setZipcode(ship.get(0).getZipcode());
	    		orderConfirmation.setShippingId(ship.get(0).getAddressId());
	    		model.addAttribute("orderConfirmation", orderConfirmation);
	    		
	    		orderConfirmation.setBillingId(bill.get(0).getAddressId());
	    	
	    	model.addAttribute("payment",res );
	    	
	    	order.setAmount(res.getAmount());
	    	order.setBillingAddressId(orderConfirmation.getBillingId());
	    	order.setCustomer(customerDAO.getCustomerById(SecurityContextHolder.getContext().getAuthentication().getName()));
	    	order.setDate(date.toString());
	    	order.setShippingAddressId(orderConfirmation.getShippingId());
	    	order.setStatus("confirmed");
	    	
	    	orderDAO.addOrderDetails(order);
	    	
	    	
	    	orderConfirmation.setEmail(customerDAO.getCustomerEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
	    	orderConfirmation.setOrderID(orderDAO.getCurrentOrderId(SecurityContextHolder.getContext().getAuthentication().getName())); ///////work on db query to get order id
	    	
	    	orderConfirmation.setCardHolderName(res.getCardHolderName());
	    	
	    	String card = res.getCardNumber();
	    	String subCard = card.substring(0, 12);
	    	String paymentcard = subCard.replaceAll(subCard, "************").concat(card.substring(12));
	    	orderConfirmation.setCardNumber(paymentcard);
	    	
//	    	int id=1, quantity=5;
//	    	productDAO.updateProductQuantity(id,quantity);
	    	
	    	orderConfirmation.setCartDetails(orderConfirmation.getCartDetails());
	    	orderConfirmation.setTotalAmount(res.getAmount());
	    	
	    	
	    	System.out.println("orderconfirmation : " + orderConfirmation.getTotalAmount());
	    	
//	    	String responseorder =  restTemplate.postForObject("http://10.0.0.25:8080/EmailME/main/email",orderConfirmation , String.class);
//	    	
//	    	System.out.println("email response : " + responseorder);
	    	
	    	
	    	String customerName = customerDAO.getCustomerName(SecurityContextHolder.getContext().getAuthentication().getName());
	    	System.out.println(orderConfirmation.getAddressLine1());
	    	model.addAttribute("customerName", customerName);
	    	
	    	
	    	return "confirmation";
	    	}
	    	
	    }
	    
	    public TaxCalcUtil taxCalculation(String state){
	    	
	    	TaxCalcUtil taxCalcUtil = new TaxCalcUtil();
			taxCalcUtil.setState(state);
			taxCalcUtil.setAmount(100);
			
			RestTemplate restTemplate = new RestTemplate();
	    	List<HttpMessageConverter<?>> list = new ArrayList<HttpMessageConverter<?>>();
	    	list.add(new MappingJacksonHttpMessageConverter());
	    	restTemplate.setMessageConverters(list);
	    	
	    	TaxCalcUtil taxResponse = restTemplate.postForObject("http://10.0.0.24:8080/TaxME/check/tax", taxCalcUtil, TaxCalcUtil.class);
	    	return taxResponse;
	    }
	    
	
}
