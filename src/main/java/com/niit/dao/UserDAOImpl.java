package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.User;

public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	@Override
	public boolean registerUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e) 
		{
			System.out.println("Exception arised" +e);
			return false;
		}
	}

	@Transactional
	@Override
	public boolean updateUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e) 
		{
			System.out.println("Exception arised" +e);
			return false;
		}
	}

	@Transactional
	@Override
	public User getUser(String userName) {
		Session session = sessionFactory.openSession();
		User user = (User)session.get(User.class, userName);
		session.close();
		return user;
	}

	@Override
	public boolean approveUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
