package com.mss.app.dao;

import java.util.List;

import com.mss.app.entity.DatabaseCartdetail;
import com.mss.app.entity.Order;
import com.mss.app.entity.Product;

public interface IProductDAO {

public List<Order> getOrders();
	
public List<Object[]> getProductPriceName(int id);

public List<Product> getProducts();

public Product getProduct(int id);

public void updateProductQuantity(int id, int quantity);


public List<DatabaseCartdetail> getCartData(String username);
public List<Order> getOrderData();

public List<Product> getProductData();

public List getRecommendations(String description);

public String getProductDescription(String name);




public void insertCartValues(long id,String user,double prodprice,int prodid,int prodquant,String prodname);

public boolean getDatabaseUpdate(int id);

public void sameProductUpdate(int id,int quantity);
public double getTotalPrice(String username) ;
public Long getTotalCount(String username);

public void getProductquant(String username,List<DatabaseCartdetail> i);

void deleteProduct(int id);


}
