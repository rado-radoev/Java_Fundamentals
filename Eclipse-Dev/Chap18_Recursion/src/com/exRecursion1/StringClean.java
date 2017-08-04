package com.exRecursion1;

/*
 * Given a string, return recursively a "cleaned" string where adjacent chars 
 * that are the same have been reduced to a single char. 
 * So "yyzzza" yields "yza".
 */

public class StringClean {

	public static void main(String[] args) {
		System.out.println(stringClean("abbbcdd"));
	}

	public static String stringClean(String str) {
		if (str.length() <= 1) return str;
		
		if (str.substring(0, 1).matches(str.substring(1,2)))
			return "" + stringClean(str.substring(1));
			
		return str.charAt(0) + stringClean(str.substring(1));
	}
}
