import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RectangleTest {
	
	Rectangle rectangle  = new Rectangle();

	@Test
	public void TestAreaSetToFive() {
		rectangle.setLength(5);
		rectangle.setWidth(5);
		assertEquals(5.0, rectangle.calculateArea(), 1.0);
		assertEquals("Wrong Output", 12.0, rectangle.calculatePerimeter(), 1.0);
	}
	
	@Test
	public void TestPerimeterSetToFive() {
		rectangle.setLength(5);
		rectangle.setWidth(5);
		assertEquals("Wrong Output", 12.0, rectangle.calculatePerimeter(), 1.0);
	}
	
	@Test 
	public void TestPerimeterSetToInvalidValueTwentyOne(){
		rectangle.setWidth(21);
		assertEquals("Expected output 1", 1.0, rectangle.getWidth(), 0.1);
	}
	
	@Test 
	public void TestAreaSetToInvalidValueTwentyOne(){
		rectangle.setLength(21);
		assertEquals("Expected output 1", 1.0, rectangle.getLenght(), 0.1);
	}

	@Test 
	public void TestPerimeterSetToInvalidValueZer(){
		rectangle.setWidth(0);
		assertEquals("Expected output 1", 1.0, rectangle.getWidth(), 0.1);
	}
	
	@Test 
	public void TestAreaSetToInvalidValueNegativeOne(){
		rectangle.setLength(-1);
		assertEquals("Expected output 1", 1.0, rectangle.getLenght(), 0.1);
	}
}
