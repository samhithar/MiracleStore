package com.mss.app.dao;

import com.mss.app.entity.Order;

public interface IOrderDAO {

	public void addOrderDetails(Order order);

	int getCurrentOrderId(String customerId);
	
}
