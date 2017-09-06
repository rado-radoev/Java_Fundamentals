package com.ex2121;

public class EmptyListException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4566320641525420853L;

	public EmptyListException() {
		super("List is empty");
	}
}
