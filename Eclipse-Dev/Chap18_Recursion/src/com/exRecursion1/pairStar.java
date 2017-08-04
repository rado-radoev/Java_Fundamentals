package com.exRecursion1;

/*
	Given a string, compute recursively a new
	string where identical chars that are adjacent in the original 
	string are separated from each other by a "*".
*/

public class pairStar {

	public static void main(String[] args) {
		System.out.println(pairStar("xxyy"));
	}
	
	public static String pairStar(String str) {
		if (str.length() < 2)
			return str;
		
		if (str.substring(0, 1).equals(str.substring(1, 2)))
			return str.charAt(0) + "*" + pairStar(str.substring(1));
		else
			return str.charAt(0) + pairStar(str.substring(1));
	}

}
