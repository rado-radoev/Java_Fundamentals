package com.exceptions;

public class ExceptionC extends ExceptionB {

	public ExceptionC() {
		super("Exception of type C occured");
	}
	
	public ExceptionC(String customMessage) {
		super(customMessage);
	}
	
	public ExceptionC(String customMessage, Throwable throwable) {
		super(customMessage, throwable);
	}
	
	public ExceptionC(Throwable throwable) {
		super(throwable);
	}
}
