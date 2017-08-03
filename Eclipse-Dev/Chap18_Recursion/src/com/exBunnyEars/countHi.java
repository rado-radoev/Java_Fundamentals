package com.exBunnyEars;

/*
 * Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.
 * */

public class countHi {

	public static void main(String[] args) {
		System.out.println(countHi("hihih"));
	}
	
	public static int countHi(String str) {
		if (str.length() <= 1) 
			return 0;
		
		if (str.length() > 2) {
			if (str.substring(str.length() - 2).equals("hi")) {
				return 1 + countHi(str.substring(0, str.length() - 1));
			}
		}
		else {
			if (str.equals("hi")) {
				return 1 + countHi(str.substring(0, str.length() - 1));
			}
		}
		
		return countHi(str.substring(0, str.length() - 1));
	}

	public int countH1(String str) {
		  if (str.length() <= 1) return 0;
		  int count = 0;
		  if (str.substring(0, 2).equals("hi")) count = 1;  // could use startsWith()
		  return count + countHi(str.substring(1));
		}
}
