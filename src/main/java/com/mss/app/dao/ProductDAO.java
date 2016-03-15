package com.mss.app.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mss.app.entity.DatabaseCartdetail;
import com.mss.app.entity.Order;
import com.mss.app.entity.Product;

@Repository("productDao")
public class ProductDAO implements IProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	HttpSession session1;
	double totalprice;
	Long productcount;

	public List<Product> getProducts() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product");
		List<Product> products = query.list();
		session.close();
		return products;
	}

	public List getOrders() {

		Session session = sessionFactory.openSession();

		List<Order> orders = (List<Order>) session.createQuery("from Order").list();
		session.close();
		return orders;
	}

	@Override
	public List getProductPriceName(int id) {

		Session session = sessionFactory.openSession();
		List<Object> namePriceList = session.createQuery("select p.name,p.price from Product p where p.id=" + id).list();
		session.close();
		return namePriceList;
	}

	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public void updateProductQuantity(int id, int quantity) {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Product set quantity = '"+ quantity + "' where id = '" + id + "'");
		query.executeUpdate();

	}

	@Override
	public Product getProduct(int id) {
		Session session = sessionFactory.openSession();
		Product products = (Product) session.get(Product.class, id);
		session.close();
		return products;

	}


	public List<DatabaseCartdetail> getCartData(String username) {
		Session session = sessionFactory.openSession();
		System.out.println(username);
		List<DatabaseCartdetail> cartdetail = session.createQuery("from DatabaseCartdetail d where d.userid='" + username + "'").list();
		for (DatabaseCartdetail cd : cartdetail) {
			System.out.println(cd.getProdname());
		}

		return cartdetail;

	}

	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public List getOrderData() {

		Session session = sessionFactory.getCurrentSession();

		List<Order> order = (List<Order>) session.createQuery("from Order").list();
		
		System.out.println(order.get(0).getStatus());
		return order;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Product> getProductData() {
		Session session = sessionFactory.openSession();
		List<Product> productdata = (List<Product>) session.createQuery("from Product").list();
		session.close();
		return productdata;
	}

	@Override
		public void getProductquant(String username,List<DatabaseCartdetail> details) {	
		Session  session=sessionFactory.openSession();	
		int quantity;        
		String name;
		List<Object[]> quantities=session.createQuery("select p.prodname,p.prodquant from DatabaseCartdetail p where p.userid='"+username+"'").list();
		
		/*List l=session.createQuery("from Product u join u.categories r where r.categoryName='shoe'").list();*/
		for(DatabaseCartdetail user1 : details)
		{
		for(Object object:quantities)
		{	
		Object[] ar=(Object[])object;
		name=(String)ar[0];
		quantity=(Integer)ar[1]; 
		if(user1.getProdname().equals(name)) 
		{
		if(user1.getProdquant()!=quantity)
		{
		session=sessionFactory.openSession();	
		session.beginTransaction();
		session.createQuery("update DatabaseCartdetail d set d.prodquant="+user1.getProdquant() +"where d.prodname='"+user1.getProdname()+"'").executeUpdate();	    
		session.getTransaction().commit();	
		session.close();	
		}	   	
		}
		}
		}
	}

	public List getRecommendations(String description)
	{
		Session session =sessionFactory.openSession();
		List productnames=session.createQuery("select p.name from Product p where p.description='"+description+"'").list();		
		session.close();
		return productnames;
	}

	@Override
	 public String getProductDescription(String username)
		{
			Session session=sessionFactory.openSession();
			Query q=session.createQuery("select p.description from Product p where p.name='"+username+"'");
			String description=(String)q.uniqueResult();
			session.close();
			return description;
		}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insertCartValues(long id,String user,double prodprice,int prodid,int prodquant,String prodname)
	{

	Session session=sessionFactory.getCurrentSession();
	
	DatabaseCartdetail databasedetail=new DatabaseCartdetail();

	databasedetail.setUserid(user);
	databasedetail.setProdprice(prodprice);
	databasedetail.setProdid(prodid);
	databasedetail.setProdquant(prodquant);
	databasedetail.setProdname(prodname);
	session.save(databasedetail);	
	

	}

	@Override
	public boolean getDatabaseUpdate(int id)
	{
	Session session=sessionFactory.openSession();
	boolean result=true;
	Query q= session.createQuery("select p.prodid from DatabaseCartdetail p where p.prodid="+id);
	if((Integer)q.uniqueResult()==null)
	{
	try{
	result=false;
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
	}
	else    
	result=true;

	 return result;
	}

	@Override
	public void sameProductUpdate(int id, int quantity) {
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	Query q=session.createQuery("select p.prodquant from DatabaseCartdetail p where p.prodid="+id) ;
	quantity+=(Integer)q.uniqueResult();
	session.createQuery("update DatabaseCartdetail d set d.prodquant="+quantity+"where d.prodid="+id).executeUpdate();
	session.getTransaction().commit();
	session.close();

	}

	@Override
	public double getTotalPrice(String username) 
	{
	Session session=sessionFactory.openSession();
	session.beginTransaction(); 
	Query o=session.createQuery("select sum(d.prodprice*d.prodquant) from DatabaseCartdetail d where d.userid='"+username+"' and d.prodquant>0");	
	if((Double)o.uniqueResult()==null)
	{
	session.createQuery("delete from DatabaseCartdetail d where d.prodquant=0").executeUpdate();	
	session.getTransaction().commit();	
	session.close();
	totalprice=0;
	try {
	throw new NoItemsInCartException("No Items In Cart");

	} catch (NoItemsInCartException e) {

	e.printStackTrace();
	}
	}
	else
	{
	totalprice=(Double)o.uniqueResult();
	session.close();
	}
	return totalprice;
	}



	@Override
	public Long getTotalCount(String username) {
	Session session=sessionFactory.openSession();
	Query q=session.createQuery("select count(d.userid) from DatabaseCartdetail d where d.userid='"+username+"' and d.prodquant>0");
	if((Long)q.uniqueResult()==null)
	{
	try {
	throw new NoItemsInCartException("No Items In Cart");


	} catch (NoItemsInCartException e) {

	e.printStackTrace();
	}
	}
	else
	{
	productcount=(Long)q.uniqueResult();
	session.close();
	}
	return productcount;
	}
	
	@Override
	public void deleteProduct(int id) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.createQuery("delete from DatabaseCartdetail d where d.prodid="+id).executeUpdate();	
		session.getTransaction().commit();						
		session.close();
	}
}
