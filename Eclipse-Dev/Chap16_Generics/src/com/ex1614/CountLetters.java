package com.ex1614;

// Counting number of letters in a string

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class CountLetters {
	
	private static Map<Character, Integer> charCount;

	public static void main(String[] args) {
		createMap();
		displayMap();

	}
	
	private static void displayMap() {
		Set<Character> keys = charCount.keySet();
		
		TreeSet<Character> sortedKeys = new TreeSet<Character>(keys);
		
		System.out.printf("Character count:%n%-10s%10s%n", "Characters", "Occurances");
	
		
		for (Character key : sortedKeys) {
			System.out.printf("%-10s%10s%n", key, charCount.get(key));
		}
		
		
	}
	
	private static void createMap() {
		charCount =  new HashMap<Character, Integer>();
		Scanner input = new Scanner(System.in);
		
		System.out.printf("Enter your text here. Press Enter to stop:%n");
		String text = input.nextLine();
		
		// tokenize string
		for (Character c : text.toCharArray()) {
			if (charCount.containsKey(c)) {
				int count = charCount.get(c);
				charCount.put(c, count + 1);
			}
			else {
				charCount.put(c, 1);
			}
		}
		
		
	}

}
