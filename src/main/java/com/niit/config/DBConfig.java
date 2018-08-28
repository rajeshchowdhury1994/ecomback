package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.CartDAO;
import com.niit.dao.CartDAOImpl;
import com.niit.dao.CategoryDAO;
import com.niit.dao.CategoryDAOImpl;
import com.niit.dao.OrderDAO;
import com.niit.dao.OrderDAOImpl;
import com.niit.dao.ProductDAO;
import com.niit.dao.ProductDAOImpl;
import com.niit.dao.SupplierDAO;
import com.niit.dao.SupplierDAOImpl;
import com.niit.dao.UserDAO;
import com.niit.dao.UserDAOImpl;
import com.niit.model.Cart;
import com.niit.model.Category;
import com.niit.model.Order;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;


@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.niit")
public class DBConfig 
{

	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/ecom");
		dataSource.setUsername("ecom");
		dataSource.setPassword("ecom");
		
		System.out.println("--------Data Source Object Created-------");
		
		return dataSource;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties properties=new Properties();
		properties.put("hibernate.hbm2ddl.auto","update");
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder sessionFactoryBuilder=new LocalSessionFactoryBuilder(getH2DataSource());
		sessionFactoryBuilder.addProperties(properties);
		
	    sessionFactoryBuilder.addAnnotatedClass(Cart.class);
		sessionFactoryBuilder.addAnnotatedClass(Category.class);
		sessionFactoryBuilder.addAnnotatedClass(Order.class);
		sessionFactoryBuilder.addAnnotatedClass(Product.class);
		sessionFactoryBuilder.addAnnotatedClass(Supplier.class);
		sessionFactoryBuilder.addAnnotatedClass(User.class);
		
		SessionFactory sessionFactory=sessionFactoryBuilder.buildSessionFactory();
		
		System.out.println("--------SessionFactory Object Created------");
		
		return sessionFactory;
	}
	
	
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("-----------Hibernate Transaction Object Created-------");
		return new HibernateTransactionManager(sessionFactory);
	}
	
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO() {
		System.out.println("The Category bean is created");
		return new CategoryDAOImpl();
	}
	
	@Bean(name="productDAO")
	public ProductDAO getProductDAO() {
		System.out.println("The Product bean is created");
		return new ProductDAOImpl();
	}
	
	@Bean(name="supplierDAO")
	public SupplierDAO getSupplierDAO() {
		System.out.println("The Supplier bean is created");
		return new SupplierDAOImpl();
	}
	@Bean(name="userDAO")
	public UserDAO getUserDAO() {
		System.out.println("The User bean is created");
		return new UserDAOImpl();
	}

	@Bean(name="cartDAO")
	public CartDAO getCartDAO() {
		System.out.println("The Cart bean is created");
		return new CartDAOImpl();
	}
	

	@Bean(name="orderDAO")
	public OrderDAO getOrderDAO() {
		System.out.println("The Order bean is created");
		return new OrderDAOImpl();
	}
	
	
	
}
