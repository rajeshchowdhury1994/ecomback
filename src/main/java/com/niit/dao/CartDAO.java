package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;

public interface CartDAO {

	public boolean addToCart(Cart cart);
	public boolean deleteFromCart(Cart cart);
	public boolean updateFromCart(Cart cart);
	public Cart getCartItem(int cartItemId);
	public List<Cart> listCartItems(String userName);
}
