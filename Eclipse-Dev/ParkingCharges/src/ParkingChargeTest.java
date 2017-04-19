import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ParkingChargeTest {


	@Test
	public void test1Hour() {
		ParkingCharges parkingCharges = new ParkingCharges(1);
		assertEquals(2.00, parkingCharges.calculateCharges(),0.0);
	}
	
	@Test
	public void test3Hours() {
		ParkingCharges parkingCharges = new ParkingCharges(3);
		assertEquals(2.00, parkingCharges.calculateCharges(),0.0);
	}
	
	
	@Test
	public void test35Hours() {
		ParkingCharges parkingCharges = new ParkingCharges(3.5);
		assertEquals(2.50, parkingCharges.calculateCharges(),0.0);
	}
	
	@Test
	public void test5Hours() {
		ParkingCharges parkingCharges = new ParkingCharges(5);
		assertEquals(3.00, parkingCharges.calculateCharges(),0.0);
	}
	
	@Test
	public void test10Hours() {
		ParkingCharges parkingCharges = new ParkingCharges(10);
		assertEquals(5.50, parkingCharges.calculateCharges(),0.0);
	}
	
	@Test
	public void test24Hours() {
		ParkingCharges parkingCharges = new ParkingCharges(24);
		assertEquals(10.00, parkingCharges.calculateCharges(),0.0);
	}
	
	@Test
	public void test18Hours() {
		ParkingCharges parkingCharges = new ParkingCharges(18);
		assertEquals(9.5, parkingCharges.calculateCharges(),0.0);
	}

}
