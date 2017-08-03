package com.exBunnyEars;

/*
 * Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.
 */
public class CountX {

	public static void main(String[] args) {
		System.out.println(countX("xxhix"));
	}
	
	public static int countX(String str) {
		if (str.length() == 0) {
			return 0;
		}
		
		if (str.charAt(str.length() - 1) == 'x') {
			return  1 + countX(str.substring(0, str.length() - 1));
		}
		
		return countX(str.substring(0, str.length() - 1));
		
	}

}
