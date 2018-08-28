package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.OrderDAO;
import com.niit.model.Order;

public class OrderDAOTest {

static OrderDAO orderDAO;
	
	@BeforeClass
	public static void preExecution() {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		orderDAO = (OrderDAO)context.getBean("orderDAO");
		
	}
	
	@Test
	public void processPayment() {
		Order order = new Order();
		
		order.setPmode("CC");
		order.setUserName("kiran");
		order.setTotalAmountPaid(52000);
		order.setOrderDate(new java.util.Date());
		
		assertTrue("problem in adding order",orderDAO.paymentProcess(order));
	}
	
}
