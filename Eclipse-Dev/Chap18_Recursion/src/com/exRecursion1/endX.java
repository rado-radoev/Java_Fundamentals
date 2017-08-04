package com.exRecursion1;

/*
Given a string, compute recursively a new string where all the lowercase 'x' 
chars have been moved to the end of the string. 
*/

public class endX {

	public static void main(String[] args) {
		System.out.println(endX("xxhixx"));
	}
	
	public static String endX(String str) {
		if (str.length() < 2)
			return str;
		
		if (str.startsWith("x"))
			return endX(str.substring(1)) + str.charAt(0);
		else
			return str.charAt(0) + endX(str.substring(1));
		
	}

}
