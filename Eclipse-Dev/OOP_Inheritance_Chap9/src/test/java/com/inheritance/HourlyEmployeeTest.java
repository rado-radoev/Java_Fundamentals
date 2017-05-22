package com.inheritance;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HourlyEmployeeTest {
	
	HourlyEmployee employee;

	@Before
	public void setUp() throws Exception {
		employee = new HourlyEmployee("Bob", "Baker", "555-55-5555",
				5.50, 8);
	}

	@Test
	public void testFirstName()	 {
		assertEquals("Bob", employee.getFirstName());
	}
	
	@Test
	public void testLastName() {
		assertEquals("Baker", employee.getLastName());
	}
	
	
	@Test
	public void testSocialSecurityNumber() {
		assertEquals("555-55-5555", employee.getSocialSecurityNumber());
	}
	
	@Test
	public void testGrossSales() {
		assertTrue(employee.getWage() == 5.50);
	}
	
	@Test
	public void testCommissionRate() {
		assertTrue(employee.getHours() == 8);
	}
	
	@Test
	public void testBaseSalary() {
		double earnings = employee.getHours() * employee.getWage();
		assertTrue(employee.earnings() == earnings);
	}
}
