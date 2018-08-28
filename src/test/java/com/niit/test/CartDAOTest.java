package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.model.Cart;

public class CartDAOTest {

static CartDAO cartDAO;
	
	@BeforeClass
	public static void preExecution() {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		cartDAO = (CartDAO)context.getBean("cartDAO");
		
	}
	
	@Ignore
	@Test
	public void addcartTest() {
		
		Cart cart = new Cart();
		cart.setPrice(18900);
		cart.setProductId(5);
		cart.setProductName("VIVO V7 PLUS");
		cart.setQuantity(1);
		cart.setStatus("NP");
		cart.setUserName("kiran");
		
		assertTrue("problem in adding cart",cartDAO.addToCart(cart));
		
	}
	@Ignore
	@Test
	public void updateCategoryTest() {
		
		Cart cart = cartDAO.getCartItem(168);
		cart.setQuantity(4);
		
		assertTrue("problem in adding cart",cartDAO.updateFromCart(cart));	
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest() {
		Cart cart = cartDAO.getCartItem(174);
		assertTrue("problem in adding category",cartDAO.deleteFromCart(cart));
		}
	

}