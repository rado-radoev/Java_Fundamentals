package com.ex1616;

// Count and display duplicate words

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Scanner;

public class CountDuplicateWords {

	private static Map<String, Integer> wordCount;
	
	public static void main(String[] args) {
		createMap();
		displayMap();
	}
	
	private static void displayMap() {
		TreeSet<String> sortedWords = new TreeSet<String>();
		Set<String> words = wordCount.keySet();
		
		for (String word : words) {
			if (!sortedWords.contains(word)) {
				sortedWords.add(word);
			}
		}
		
		System.out.printf("Duplicate words:");
		for (String e : sortedWords) {
			System.out.println(e);
		}
	}
	
	private static void createMap() {
		wordCount = new TreeMap<String, Integer>();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter text here:");
		
		String text = input.nextLine();
		String[] splitted = text.split(" ");
		
	
		for (String s: splitted) {
			if (wordCount.containsKey(s)) {
				int count = wordCount.get(s);
				wordCount.put(s, count++);
			}
			else{
				wordCount.put(s, 1);
			}
		}
	}

}
