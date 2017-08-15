package com.ex205;

public class InvalidSubscriptException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// no argument constructor
	public InvalidSubscriptException(){
		this("Subscription out of range");
	}
	
	// one argument constructor
	public InvalidSubscriptException(String message) {
		super(message);
	}
}
