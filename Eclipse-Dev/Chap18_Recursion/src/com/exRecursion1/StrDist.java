package com.exRecursion1;

/*
 * Given a string and a non-empty substring sub, 
 * compute recursively the largest substring 
 * which starts and ends with sub and return its length.
 */

public class StrDist {

	public static void main(String[] args) {
		System.out.println(strDist("hiHellohihihi", "hih"));
	}
	
	public static int strDist(String str, String sub) {
		if (str.length() < sub.length())
			return 0;
	
		if (!str.substring(0, sub.length()).equals(sub))
			return strDist(str.substring(1), sub);
		else if (!str.substring(str.length() - sub.length()).equals(sub))
			return strDist(str.substring(0, str.length() - 1), sub);
		
		return str.length();
	}

}
