package com.exceptions_2;

public class ExceptionB extends ExceptionA {
	
	public ExceptionB() {
		super("Exception of type B occured");
	}
	
	public ExceptionB(String customMessage) {
		super(customMessage);
	}
	
	public ExceptionB(String customMessage, Throwable throwable) {
		super(customMessage, throwable);
	}
	
	public ExceptionB(Throwable throwable) {
		super(throwable);
	}

}
