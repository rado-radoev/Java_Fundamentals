package com.inheritance;

public class TestSSN {

	public static void main(String[] args) {
		String ssn = "333-33-3333";
		
		System.out.println(ssn.matches("^([1-9])(?!\1{2}-\1{2}-\1{4})[1-9]{2}-[1-9]{2}-[1-9]{4}"));

	}

}
