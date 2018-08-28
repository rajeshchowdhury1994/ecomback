package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.User;

public class UserDaoTest {

	static UserDAO userDAO;
	
	@BeforeClass
	public static void preExecution() {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	
@Ignore
	@Test
	public void registerUser() {
		
		User user = new User();
		user.setUserName("Rajesh");
		user.setPassword("123456");
		user.setCustomerName("Rajesh");
		user.setRole("admin");
		user.setEmailId("rajesh@gmail.com");
		user.setAddress("ramatalkies,vizag");
		
		assertTrue("Problem in registering a new user",userDAO.registerUser(user));
		
	}
	
	@Ignore
	@Test
	public void updateUser() {
		
		User user = userDAO.getUser("10");
		user.setCustomerName("Ashish");
		
		assertTrue("Problem in updating the user",userDAO.updateUser(user));
	}

}
