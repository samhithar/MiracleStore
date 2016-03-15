package com.mss.web.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mss.app.entity.CartDetails;
import com.mss.app.entity.Product;
import com.mss.app.dao.IProductDAO;



//adds items to shoppingcart  and get the total price of the cart

@Controller
@SessionAttributes({"productdatas","productids","productprice","id","matchedproducts"})
public class ShoppingCartController {

	HttpSession httpsession;
	HttpServletRequest request;
	HttpServletResponse response;
	SessionFactory sessionfactory;
	double totalprice=0,price;
	long productcount=0;
	String name;
	List<CartDetails> listofcartitems=new ArrayList<CartDetails>();
	@Autowired
	private IProductDAO productDao;
	
	@Autowired
	private IProductDAO productDAO;
     


	@RequestMapping(value="/addtocart",method=RequestMethod.POST)
	public String  addShoppingCartItems(HttpServletRequest request,HttpSession session,Model modelMap,Map map)
	{
		String user=SecurityContextHolder.getContext().getAuthentication().getName();
		int prodquant=Integer.parseInt(request.getParameter("quantity"));
		int productspecificid=Integer.parseInt(request.getParameter("productid"));
		List<Object[]>list=productDao.getProductPriceName(productspecificid);
		
		for(Object object:list)
		{
			Object[] ar=(Object[])object;
			name=(String)ar[0];
			price=(Double)ar[1];        	
		}
		
	   
		CartDetails cartdetails=new CartDetails(prodquant,productspecificid,name,price);
		String description=productDao.getProductDescription(name);
		List matchedproducts=productDao.getRecommendations(description);
		totalprice=productDao.getTotalPrice(SecurityContextHolder.getContext().getAuthentication().getName());	
		System.out.println("totalprice "+totalprice);
		productcount=productDao.getTotalCount(SecurityContextHolder.getContext().getAuthentication().getName());
		System.out.println("productcount "+productcount);
		boolean result=productDao.getDatabaseUpdate(productspecificid);
		if(result==false)
		productDao.insertCartValues(productcount,user,price,productspecificid, prodquant, name) ;
		else
		{
			productDao.	sameProductUpdate(productspecificid, prodquant);
			productcount--;
		}
		totalprice+=price*prodquant;
		System.out.println("after calculating "+totalprice);
		List<Product> products = productDAO.getProducts();
		productcount+=1;
		System.out.println("productcount "+productcount);
		modelMap.addAttribute("id",productspecificid);
		
		modelMap.addAttribute("totalprice",totalprice);
		modelMap.addAttribute("products",products);		
		modelMap.addAttribute("productcount",productcount);
		modelMap.addAttribute("matchedproducts",matchedproducts);
		return "products";
	}




}

