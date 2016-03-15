package com.mss.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mss.app.entity.Customer;

@Repository
public class CustomerDAO implements ICustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.REQUIRED)
	public void addCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.save(customer);

	}
	
	
	public Customer getCustomerById(String id) {

		Session session = sessionFactory.openSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		session.close();
		return customer;
	}

	public List<Customer> getCustomers() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Customer");
		List<Customer> customers = query.list();
		session.close();
		return customers;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void addCustomer(List<Customer> customers) {
		
		for (Customer customer : customers) {
			Session session = sessionFactory.getCurrentSession();
			session.save(customer);
		
		}

	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String getCustomerEmail(String customerId) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("in customer dao");
		Query query = session.createQuery("select C.email from Customer C where C.customerId IN (:customerId)");
		query.setParameter("customerId", customerId);
		String email=(String) query.uniqueResult();
		return email;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateCustomer(Customer customer) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("update Customer set firstname = '"+customer.getFirstname()+"', lastname = '"+customer.getLastname()+"', email = '"+customer.getEmail()+"' , password = '"+customer.getPassword()+"' where customerId = '"+customer.getCustomerId()+"'");
		 query.executeUpdate();

	}
	
	 @Override
		@Transactional(propagation = Propagation.REQUIRED)
		public String getCustomerName(String customerId){
			String first = null, last = null, name = null;
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("select C.firstname,C.lastname from Customer C where C.customerId IN (:customerId)");
			query.setParameter("customerId", customerId);
			List<Object[]> users = query.list();
			for(Object[] user:users){
				first =(String)user[0];
				last = (String) user[1];
				name = first+ " " + last;
			}
			
			return name;
		}
}
