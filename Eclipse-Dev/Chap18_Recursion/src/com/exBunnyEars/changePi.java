package com.exBunnyEars;

/*
 *Given a string, compute recursively (no loops) 
 *a new string where all appearances of "pi" have been replaced by "3.14". 
 */

public class changePi {

	public static void main(String[] args) {
		System.out.println(changePi("hip"));
	}
	
	public static String changePi(String str) {
		if (str.length() == 0) 
			return "";
		else if (str.length() == 1) 
			return str;
		
		String temp = "";
		if (str.substring(0, 2).toLowerCase().equals("pi")) {
			temp += "3.14";
			return temp + changePi(str.substring(2));
		}
		else {
			temp += str.substring(0, 1).toLowerCase();
		}
		
		return temp + changePi(str.substring(1));
	}

}
