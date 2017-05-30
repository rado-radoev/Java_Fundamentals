// 11.19
package com.exceptions_3;

public class OrderOfCatchBlocksTest {

	public static void main(String[] args) {
		
		try {
			method1();
		} catch (Exception e) {
			System.err.println("More general error caught!");
		//} catch (ExceptionA ea) {
			//	System.err.println("Subclass exception caught before super class!");
		} catch (IllegalAccessError ie) {
			System.err.println("Specific error caught!");
		}
	}
	
	public static void method1 () throws ExceptionA {
		throw new ExceptionA();
	}
}
