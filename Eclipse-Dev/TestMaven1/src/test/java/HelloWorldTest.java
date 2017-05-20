import static org.junit.Assert.*;

import org.junit.Test;

public class HelloWorldTest {
	
	HelloWorld helloWorld = new HelloWorld();

	@Test
	public void test() {
		assertEquals("Expected is hellow rold", "Hello World!!!!!", helloWorld.displayHello());
	}

}
