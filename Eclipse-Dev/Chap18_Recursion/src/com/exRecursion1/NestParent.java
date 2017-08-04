package com.exRecursion1;

/*
Given a string, return true if it is a nesting of zero or more pairs of parenthesis,
like "(())" or "((()))". Suggestion: check the first and last chars, 
and then recur on what's inside them. 
 **/

public class NestParent {

	public static void main(String[] args) {
		System.out.println(nestParen("((()()"));
	}

	public static boolean nestParen(String str) {
  		if (str.length() < 1) return true;
		
		if (str.startsWith("(") && str.endsWith(")"))
			return nestParen(str.substring(1, str.length() - 1));
		
		if (str.charAt(0 ) != '(' || str.charAt(str.length() -1) != ')' )
			return false;
		
		return true;
	}
}
