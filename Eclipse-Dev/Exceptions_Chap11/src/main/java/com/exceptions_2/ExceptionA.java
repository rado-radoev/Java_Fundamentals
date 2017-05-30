package com.exceptions_2;

public class ExceptionA extends Exception {

	public ExceptionA() {
		super("Exception of type A occured");
	}
	
	public ExceptionA(String customMessage) {
		super(customMessage);
	}
	
	public ExceptionA(String customMessage, Throwable throwable) {
		super(customMessage, throwable);
	}
	
	public ExceptionA(Throwable throwable) {
		super(throwable);
	}
}
