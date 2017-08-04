package com.exBunnyEars;

/*
Given a string, compute recursively the number of times lowercase "hi"
appears in the string, however do not count "hi" that have an 'x' immedately before them.
*/

public class CountHi2 {

	public static void main(String[] args) {
		System.out.println(countHi2("xxxx"));
	}

	public static int countHi2(String str) {
		if (str.length() < 2) return 0;
		
		if (!str.startsWith("x") && str.substring(0, 2).equals("hi"))
			return 1 + countHi2(str.substring(1));
		else if (str.length() > 2 && (str.startsWith("x") && str.substring(1, 3).equals("hi")))
			return countHi2(str.substring(3));
			
		
		return countHi2(str.substring(1));
	}
}
