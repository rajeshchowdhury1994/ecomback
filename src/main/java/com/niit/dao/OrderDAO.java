package com.niit.dao;

import com.niit.model.Order;

public interface OrderDAO {
	
	public boolean paymentProcess(Order order);

}
