package com.mss.app.dao;

import java.util.ArrayList;
import java.util.List;

import com.mss.app.entity.Address;

public interface IAddressDAO {
	
	public void addAddress(Address address);
	
	public void updateAddress(Address address);
	
	public ArrayList<Integer> getAddressIds(String customerId);

	public Address getAddressById(int id);
	
	public List<Address> getAddressByCustomerId(String customerId);
	
	public List<Address> getDatabyLine1(String line, String customerId);

	public List<Address> getAddresses();
	
	public void deleteAddress(int id);
}
