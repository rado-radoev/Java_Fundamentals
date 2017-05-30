// ex. 11.20
package com.exceptions_5;

public class RethrowExceptionsTest {
	
	public static void main(String[] args) {
		someMethod();
		assert (someMethod() == 1) : "Error!";
	}
	
	public static int someMethod() throws IllegalArgumentException {
		try {
			someMethod2();
			return 1;
		} catch (Exception e) {
			System.err.println("Exception thrown from method 2 caught in method 1");
			System.out.println("Rethrowing exception as IllegalArgumentException");
			throw new IllegalArgumentException("Rethrowing...", e);
		}
		
	}
	
	public static void someMethod2() throws Exception {
		throw new Exception("Method 2 exception");
	}

}
