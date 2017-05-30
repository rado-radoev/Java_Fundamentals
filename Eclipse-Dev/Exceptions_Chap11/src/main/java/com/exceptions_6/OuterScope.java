// ex. 11.21
package com.exceptions_6;


import java.io.IOException;

public class OuterScope {

	public static void main(String[] args) {
		try {
			method();
		} catch (IOException io) {
			System.out.println("IO Excetion caught");
		}

	}
	
	public static void method() throws IOException {
		try {
			method1();
		} catch (Exception e){
			System.out.println("Method handles all exceptions");
			e = new IOException();
			throw new IOException("Rethrowing exception", e);
		}
	}
	
	public static void method1() {
		try {
			method2();
		} catch (IndexOutOfBoundsException iob) {
			System.out.println("Method 1 handles Index out of bound exceptions");
		}
	}
	
	public static void method2() throws IllegalArgumentException {
		try {
			throw new IllegalArgumentException();
		} catch (IllegalAccessError iae) {
			System.out.println("Method 2 handles Illegal Access Error");
		}
		
	}

}
