package com.ex1613;
// program that reads a series of first and last names
// an eliminates dupliates by storin them in set
// Allowing the user to search for first name

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.Collection;


public class EliminateDuplicate {
	
	private static Set<String> storedNames = new HashSet<String>();

	public static void main(String[] args) {
		storeNames();
		checkNameExists();
	}
	
	private static void checkNameExists() {
		Scanner input = new Scanner(System.in);
		
		System.out.printf("%s: ", "Search for a name");
		String name = input.next();
		System.out.printf("%s: %s", name, (storedNames.contains(name) ? "Exists" : "Does not exist") );

	}
	
	
	private static void storeNames() {
		List<String> names = new LinkedList<>(Arrays.asList(userPrompt()));
		storedNames.addAll(names);
	}
	
	private static String[] userPrompt() {
		Scanner input = new Scanner(System.in);
		
		System.out.printf("%s: ", "Enter series of first names");
		String[] names = input.nextLine().split(" ");
		
		return names;
	}

}
