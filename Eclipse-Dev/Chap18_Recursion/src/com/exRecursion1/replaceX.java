package com.exRecursion1;

/*
 * Given a string, compute recursively (no loops) a new string 
 * where all the lowercase 'x' chars have been changed to 'y' chars.
 */

public class replaceX {

	public static void main(String[] args) {
		System.out.println(replaceX("codex"));
	}
	
	public static String replaceX(String s) {
		if (s.length() == 0) return "";
		
		String temp = "";
		if (s.startsWith("x")) {
			temp += "y";
		}
		else {
			temp += s.substring(0, 1);
		}
		
		return temp + replaceX(s.substring(1));
	}

}
