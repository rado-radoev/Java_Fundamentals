package com.exBunnyEars;

/*Count recursively the total number of "abc" and "aba" substrings that appear in the given string.*/

public class CountABC {

	public static void main(String[] args) {
		System.out.println(countAbc("abaxxaba"));
	}

	public static int countAbc(String str) {
		if (str.length() < 3)
			return 0;
		
		if (str.substring(0, 3).matches("abc|aba")) 
			return 1 + countAbc(str.substring(1));
		else
			return countAbc(str.substring(1));
	}
}
