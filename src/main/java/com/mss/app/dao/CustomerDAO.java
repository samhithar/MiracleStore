package com.mss.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mss.app.entity.Customer;
import com.mss.app.entity.Roles;

@Repository
public class CustomerDAO implements ICustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.REQUIRED)
	public void addCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.save(customer);

	}
	
	public void addRole(Roles role) {
			try{
			
			Class.forName("org.gjt.mm.mysql.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/miraclestore_dev","root", "mani@1492");
			
			Statement statement = connection.createStatement();
			
			String insertQuery = "Insert into miraclestore_dev.tbl_roles(customer_id,authority) values (?,?)";
			
			System.out.println(insertQuery);
			
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			
			preparedStatement.setString(1,role.getCustomerId());
			preparedStatement.setString(2,role.getAuthority());
			
			int i= preparedStatement.executeUpdate();
			
			System.out.println(i+"added");
			connection.close();
			return;
		
		}
		catch (ClassNotFoundException | SQLException e) {			
			e.printStackTrace();
		}
	
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
	 
	 @Transactional(propagation = Propagation.REQUIRED)
		public void deleteCustomer(String customerId) {
			
			Session session = sessionFactory.getCurrentSession();
			
			Query query = session.createQuery("update Customer set enabled = '0' where customerId = '"+customerId+"'");
			 query.executeUpdate();

		}
}
