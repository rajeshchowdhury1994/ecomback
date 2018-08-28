package com.niit.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Order;

@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean paymentProcess(Order order) {
		try 
		{
		sessionFactory.getCurrentSession().save(order);
		return true;
		}
		catch(Exception e) 
		{
		System.out.println("Exception Arised"+e);
		return false;
		}
	}

}
