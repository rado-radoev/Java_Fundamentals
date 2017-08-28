package com.ex217;

public class EmptyListException extends RuntimeException {

	public EmptyListException() {
		this("List"); // call other empty list c-tor
	}
	
	public EmptyListException(String name) {
		super(name + " is empty");
	}
}
