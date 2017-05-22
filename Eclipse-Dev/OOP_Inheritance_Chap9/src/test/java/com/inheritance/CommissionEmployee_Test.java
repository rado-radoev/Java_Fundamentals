package com.inheritance;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CommissionEmployee_Test {
	
	CommissionEmployee commissionEmployee;
	
	@Before
	public void setUp() {
		commissionEmployee = new CommissionEmployee(
		         "Sue", "Jones", "222-22-2222", 10000, .06); 
	}

	@Test
	public void testFirstName() {
		assertEquals("Sue", commissionEmployee.getFirstName());
	}
	
	@Test
	public void testLastName() {
		assertEquals("Jones", commissionEmployee.getLastName());
	}
	
	@Test
	public void testSSN() {
		assertEquals("222-22-2222", commissionEmployee.getSocialSecurityNumber());
	}
	
	@Test
	public void testGrossSales() {
		assertTrue(commissionEmployee.getGrossSales() == 10000);
	}
	

	@Test
	public void testCommissionRate() {
		assertTrue(commissionEmployee.getCommissionRate() == .06);
	}
	
	
	@Test
	public void testChangeCommissionRate() {
		commissionEmployee.setCommissionRate(.1);
		assertTrue(commissionEmployee.getCommissionRate() == .1);
	}
	
	@Test
	public void testChangeGrossSales() {
		commissionEmployee.setGrossSales(5000);
		assertTrue(commissionEmployee.getGrossSales() == 5000);
	}

}
