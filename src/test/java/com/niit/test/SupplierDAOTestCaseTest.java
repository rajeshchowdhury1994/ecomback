package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

public class SupplierDAOTestCaseTest {

		static SupplierDAO supplierDAO;
		
		@BeforeClass
		public static void preExecution() {
			
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("com");
			context.refresh();
			
			supplierDAO = (SupplierDAO)context.getBean("supplierDao");
			
		}
		
		@Ignore
		@Test
		public void addSupplier() {
			
			Supplier supplier = new Supplier();
			supplier.setSupplierName("Electronic sales");
			supplier.setSupplierAddr("Gajuwaka, visakhapatnam");
			
			assertTrue("problem in adding a supplier",supplierDAO.addSupplier(supplier));
		}
		
		@Ignore
		@Test
		public void updateSupplier() {
			
			Supplier supplier = supplierDAO.getSupplier(8);
			supplier.setSupplierAddr("New Gajuwaka,visakhapatnam");
			
			assertTrue("problem in updating the supplier info",supplierDAO.updateSupplier(supplier));
		}
		
		@Ignore
		@Test
		public void deleteSupplier() {
			
			Supplier supplier = supplierDAO.getSupplier(8);
			
			assertTrue("Problem is deleting the supplier",supplierDAO.deleteSupplier(supplier));
		}
		
		@Ignore
		@Test
		public void listSuppliers() {
			
			List<Supplier> listSupplier = supplierDAO.listSuppliers();
			
			assertNotNull("Problem to show all suppliers",listSupplier);
		}
	}