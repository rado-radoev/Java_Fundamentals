package com.sets;

import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collection;

public class Sets {

	public static void main(String[] args) {
		String[] colors = {"red", "white", "blue", "green", "gray", "orange", "tan", "white", "cyan", "peach", "gray", "orange"};
		List<String> colorsList = Arrays.asList(colors);
		System.out.printf("List %s%n", colorsList);

		// quickly eliminate duplicates from the list
		printNonDuplicates(colorsList);
		
	}

	private static void printNonDuplicates(Collection <String> values) {
		Set<String> set = new HashSet<String>(values);
		
		System.out.printf("%s%n", "Non duplicate values are: ");
		for (String s : set) {
			System.out.printf("%s ", s);
		}
	}
}
