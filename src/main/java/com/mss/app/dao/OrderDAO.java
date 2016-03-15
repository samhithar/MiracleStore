package com.mss.app.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mss.app.entity.Address;
import com.mss.app.entity.Customer;
import com.mss.app.entity.Order;

@Repository
public class OrderDAO implements IOrderDAO{

	@Autowired
	private SessionFactory sessionFactory;

	public ICustomerDAO customerDAO;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public void addOrderDetails(Order order){
		/*Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Order DAO before insert");*/
		
		Session session = sessionFactory.getCurrentSession();
		session.save(order);
		/*System.out.println("Order DAO after insert");
		session.getTransaction().commit();*/
		
	}
	
	@Override
	public int getCurrentOrderId(String customerId){
		Session session = sessionFactory.openSession();
		 Query query = session.createQuery("select max(O.orderId) from Order O where O.customer.customerId IN (:customerId)");
		 query.setParameter("customerId", customerId);
		 int orderId =(Integer) query.uniqueResult();
		 System.out.println("current order Id in orderDAO :" + orderId);
		 session.close();
		  return  orderId;
	}
}
