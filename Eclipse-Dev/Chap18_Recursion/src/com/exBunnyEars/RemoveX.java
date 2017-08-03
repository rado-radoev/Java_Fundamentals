package com.exBunnyEars;

// Given a string, compute recursively a new string where all the 'x' chars have been removed.

public class RemoveX {

	public static void main(String[] args) {
		System.out.println(noX("xapp"));
	}
	
	public static String noX(String str) {
		if (str.length() == 0)
			return "";
		
		if (str.startsWith("x"))
			return "" + noX(str.substring(1));
		else 
			return str.charAt(0) + noX(str.substring(1));
	}

}
