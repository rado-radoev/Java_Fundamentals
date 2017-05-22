package com.inheritance;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BasePlusCommissionEmployee_Test {

	BasePlusCommissionEmployee employee;
	
	@Before
	public void setUp() throws Exception {
		employee = new BasePlusCommissionEmployee("Bob",
				"Lewis", "333-33-3333", 5000, .04, 300);
	}

	@Test
	public void testFirstName()	 {
		assertEquals("Bob", employee.getFirstName());
	}
	
	@Test
	public void testLastName() {
		assertEquals("Lewis", employee.getLastName());
	}
	
	
	@Test
	public void testSocialSecurityNumber() {
		assertEquals("333-33-3333", employee.getSocialSecurityNumber());
	}
	
	@Test
	public void testGrossSales() {
		assertTrue(employee.getGrossSales() == 5000);
	}
	
	@Test
	public void testCommissionRate() {
		assertTrue(employee.getCommissionRate() == .04);
	}
	
	@Test
	public void testBaseSalary() {
		assertTrue(employee.getBaseSalary() == 300);
	}
	
	@Test
	public void testIncreaseBaseSalary() {
		employee.setBaseSalary(1000);
		assertTrue(employee.getBaseSalary() == 1000);
	}
}
