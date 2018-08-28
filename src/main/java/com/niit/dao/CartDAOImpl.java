package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Cart;


@Repository("cartDAO")
public class CartDAOImpl implements CartDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean addToCart(Cart cart) {
		try 
		{
		sessionFactory.getCurrentSession().save(cart);
		return true;
		}
		catch(Exception e) 
		{
		System.out.println("Exception Arised"+e);
		return false;
		}
	}

	@Transactional
	@Override
	public boolean deleteFromCart(Cart cart) {
		try 
		{
		sessionFactory.getCurrentSession().delete(cart);
		return true;
		}
		catch(Exception e) 
		{
		System.out.println("Exception Arised"+e);
		return false;
		}
	
	}

	@Transactional
	@Override
	public boolean updateFromCart(Cart cart) {
		try 
		{
		sessionFactory.getCurrentSession().update(cart);
		return true;
		}
		catch(Exception e) 
		{
		System.out.println("Exception Arised"+e);
		return false;
		}			
	}


	@Override
	public List<Cart> listCartItems(String userName) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart where status=:paidstatus and userName=:username");
		query.setParameter("paidstatus", "NP");
		query.setParameter("username", userName);
		List<Cart> listCartItems = query.list();
		return listCartItems;
		}

	@Transactional
	@Override
	public Cart getCartItem(int cartItemId) {
		Session session = sessionFactory.openSession();
		Cart cart = (Cart)session.get(Cart.class,cartItemId);
		session.close();
		return cart;
	}

}
