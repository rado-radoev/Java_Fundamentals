// Ex. 11.16
package com.exceptions;

public class ExceptionsTest {
	
	public static void main(String[] args) {
		
		try {
			
			methodA();
			
		} catch (ExceptionA ea) {
			ea.printStackTrace();
			//ea.getMessage();
		}
	}
	
	
	public static void methodC() throws ExceptionC {
		throw new ExceptionC();
	}
	
	public static void methodB() throws ExceptionB { 
		throw new ExceptionB();
	}
	
	public static void methodA() throws ExceptionA {
		
		try {
			methodB();
			methodC();
		}
		catch (ExceptionA ea) {
			//ea.printStackTrace();
			throw new ExceptionA("Exception caught in methodA catch block", ea);
		}
	}

}
