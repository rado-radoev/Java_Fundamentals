package com.exRecursion1;

/*Given a string, compute recursively a new string where all the adjacent chars are now separated by a "*".*/

public class AllStarr {

	public static void main(String[] args) {
		String s = "hello";
		System.out.println(allStar(s));
	}
	
	public static String allStar(String str) {
		if (str.length() < 2)
			return str;
		
		return str.charAt(0) + "*" + allStar(str.substring(1));
		
	}

}
