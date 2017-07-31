package com.ex1814;

public class Palindrome {

	public static void main(String[] args) {
		
		String[] words = {"amma", "baba", "abba", "", "RaDAr"};

		for (String word : words) {
			System.out.printf("%s is palindrome: %b%n", word.length() >= 1 ? word : "Empty space", testPalindrome(word));
		}
	}

	public static boolean testPalindrome(String str) {
		
		String s = str.toLowerCase().replaceAll("[\\s\\pP]", ""); // convert string to lower case and remove any punctuation
		
		if (s.length() <= 1) return true; // string is palindrome, because it only has one character
		
		if (s.charAt(0) == s.charAt(s.length() - 1)) // check first and last char
			return testPalindrome(s.substring(1, s.length() - 1)); // if they are the same check next set of characters
		else 
			return false; // return false if first and last char are not the same
		
	}
	
}
