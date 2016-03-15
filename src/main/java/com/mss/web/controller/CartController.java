package com.mss.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mss.app.entity.DatabaseCartdetail;
import com.mss.app.entity.Product;
import com.mss.app.dao.IProductDAO;



@Controller
@SessionAttributes({"cartdetails","images"})
public class CartController {


	@Autowired
	private IProductDAO productDao;
	HttpSession session;
	Long productcount;
	int finalupdate;
	List result=new ArrayList();
	double totalprice;
	int oldprodquant=0;
	double prodsprice=0;
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/cart")
 
	public 	String getCartDetails(HttpSession session,Model map,HttpServletRequest request)
	{

		String username=(String)session.getAttribute("username");	
		List<String> images=new ArrayList();
		List<String> productdescription=new ArrayList();
		List<DatabaseCartdetail> cartdetails=productDao.getCartData(SecurityContextHolder.getContext().getAuthentication().getName());
		totalprice=productDao.getTotalPrice(SecurityContextHolder.getContext().getAuthentication().getName());		
		productcount=productDao.getTotalCount(SecurityContextHolder.getContext().getAuthentication().getName());
		List<Product> productsdata = productDao.getProducts();
		
		for(DatabaseCartdetail databasecartddetail:cartdetails)
		{
			for(Product products:productsdata)
			{
				if(databasecartddetail.getProdid()==products.getId())
				{
					images.add(products.getImage());	
					productdescription.add(products.getDescription());
					result.add(products.getQuantity());
				}
				
				
			}
			
		}
		if(totalprice==0 && productcount==0)
		{
			session.removeAttribute("totalprice");
			session.removeAttribute("productcount");
		}
		map.addAttribute("images",images);
		map.addAttribute("totalprice",totalprice);
		map.addAttribute("cartdetails",cartdetails);
		map.addAttribute("productcount",productcount);
		 map.addAttribute("result",result);
		map.addAttribute("productdescription",productdescription);
		return "checkout"; 
	}

	@RequestMapping(value="/Cartupdate")
	public String getProdUpdate(HttpSession session,HttpServletRequest request,ModelMap map)
	{
        if(request.getParameter("update")!=null)
        {
		
		int produpdate=Integer.parseInt(request.getParameter("quantity")); 
		int prodid=Integer.parseInt(request.getParameter("productid"));
		int oldprodquant=0;
		double prodsprice=0;		
		List<DatabaseCartdetail>cartdetails=(List<DatabaseCartdetail>)session.getAttribute("cartdetails");
		Iterator cartiterator=cartdetails.listIterator();
		System.out.println("hi");	
		if(produpdate==0)
			productcount--;		
		session.setAttribute("productcount",productcount);		
		while(cartiterator.hasNext())
		{
			DatabaseCartdetail crtdetails=(DatabaseCartdetail)cartiterator.next();
			if(crtdetails.getProdid()==prodid)
			{								
				oldprodquant=crtdetails.getProdquant();
				prodsprice=crtdetails.getProdprice();
				crtdetails.setProdquant(produpdate);
				productDao.getProductquant(crtdetails.getUserid(),cartdetails);
				
				System.out.println(oldprodquant);
				System.out.println(prodsprice);
			}
		}
		if(produpdate>oldprodquant)
		{
			System.out.println("inside >"+totalprice);
			finalupdate=produpdate-oldprodquant;
			totalprice+=(finalupdate*prodsprice);
			session.setAttribute("totalprice", totalprice);
			System.out.println("produpdate>oldprodquant"+totalprice);	
		}
		else
		{
			System.out.println("inside <"+totalprice);
			finalupdate=oldprodquant-produpdate;
			totalprice-=(finalupdate*prodsprice);
			session.setAttribute("totalprice", totalprice);
			System.out.println("produpdate<oldprodquant"+totalprice);	
		}		
        session.setAttribute("cartdetails",cartdetails);
		System.out.println(totalprice);
        }
        else
        {
        	
        	int id=(Integer.parseInt(request.getParameter("productid")));
        	productDao.deleteProduct(id);
        	session.setAttribute("productcount",productcount);		
        	List<DatabaseCartdetail>cartdetails=(List<DatabaseCartdetail>)session.getAttribute("cartdetails");
    		Iterator cartiterator=cartdetails.listIterator();    		    		
    		session.setAttribute("productcount",productcount);		
    		while(cartiterator.hasNext())
    		{
    			DatabaseCartdetail crtdetails=(DatabaseCartdetail)cartiterator.next();
    			if(crtdetails.getProdid()==id)
    			{								
    				oldprodquant=crtdetails.getProdquant();
    				prodsprice=crtdetails.getProdprice();
    				crtdetails.setProdquant(0);
    				productcount--;
    				productDao.getProductquant(crtdetails.getUserid(),cartdetails);
    				session.setAttribute("productcount",productcount);
    			}
    		}
    		
			
			totalprice-=(oldprodquant*prodsprice);
			session.setAttribute("totalprice", totalprice);
        	
        }
       
		return "checkout";
	}



}
