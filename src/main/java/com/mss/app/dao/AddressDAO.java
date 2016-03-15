package com.mss.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mss.app.entity.Address;

@Repository
public class AddressDAO implements IAddressDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void addAddress(Address address) {
		System.out.println("in address DAO");
		Session session = sessionFactory.getCurrentSession();
		session.save(address);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateAddress(Address address) {		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Address set addressLine1 = '"+address.getAddressLine1()+"', addressLine2 = '"+address.getAddressLine2()+"', city = '"+address.getCity()+"' , state = '"+address.getState()+ "', country = '"+address.getCountry()+"', zipcode = '"+address.getZipcode()+"' where addressId = '"+address.getAddressId()+"'");
		query.executeUpdate();
	}
	
	@Override
	public ArrayList<Integer> getAddressIds(String customerId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select A.addressId from Address A where A.customer.customerId IN (:customerId)");
		query.setParameter("customerId", customerId);
		ArrayList<Integer> addressIds =(ArrayList<Integer>) query.list();
		session.close();
		return addressIds;
	}

	@Override
	public Address getAddressById(int id) {
		Session session = sessionFactory.openSession();
		Address address = (Address) session.get(Address.class, id);
		session.close();
		return address;
	}

	@Override
	public List<Address> getAddresses() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Address");
		List<Address> addresses = query.list();
		session.close();
		return addresses;
	}

	@Override
	public List<Address> getAddressByCustomerId(String customerId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Address A where A.customer.customerId IN (:CustomerId)");
		query.setParameter("CustomerId", customerId);
		List<Address> addresses =  query.list();		
		return  addresses;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteAddress(int id) {		
		Session session = sessionFactory.getCurrentSession();	
		Query query = session.createQuery("delete from Address A where A.addressId IN (:AddressId)");
		query.setParameter("AddressId", id);
		query.executeUpdate();
	}
	
	@Override
	public List<Address> getDatabyLine1(String line, String customerId) {
	Session session = sessionFactory.openSession();
	Query query = session.createQuery("from Address A where A.addressLine1 IN (:line) and A.customer.customerId IN (:customerId)");
	query.setParameter("line", line);
	query.setParameter("customerId", customerId);
	List<Address> addresses =  query.list();	
	 return  addresses;

	}

}
