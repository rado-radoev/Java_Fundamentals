// Ex. 11.16
package com.exceptions;

import java.beans.MethodDescriptor;

public class ExceptionsTest {
	
	public static void main(String[] args) {
		
		try {
			
			methodA();
			
		} catch (ExceptionA ea) {
			System.err.println(ea.getMessage());
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
			throw ea;
		}
	}

}
