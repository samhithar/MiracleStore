package com.mss.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mss.app.entity.Product;
import com.mss.app.dao.IProductDAO;



@Controller
@SessionAttributes("products")
public class ProductsController {
	
	
	double totalprice;
	Long productcount;
	
	@Autowired
	private IProductDAO productDAO;

	@RequestMapping(value = "/Products", method = RequestMethod.GET)
	public String ProductsView(Model model) {
		List<Product> products = productDAO.getProducts();
		totalprice=productDAO.getTotalPrice(SecurityContextHolder.getContext().getAuthentication().getName());		
		productcount=productDAO.getTotalCount(SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("products", products);
		return "products";

	}

	@RequestMapping(value = "/Products/{id}", method = RequestMethod.GET)
	public String ProductsDetail(Model model, @PathVariable("id") int id,HttpSession session) {
		id = id + 1;
		String image=null,description=null;
		Product products = productDAO.getProduct(id);
	    List<Product> productdata=productDAO.getProducts();
	    for(Product product:productdata)	    	
	    {
	    	
	    	if(product.getId()==id)
	    	{
	    		image=product.getImage();
	    		description=product.getDescription();
	    	}
	    	
	    }
	    model.addAttribute("description",description);
	    model.addAttribute("image",image);
		model.addAttribute("products", products);
		model.addAttribute("id", id);
		System.out.println(id);
		return "selected_product";
	}

}