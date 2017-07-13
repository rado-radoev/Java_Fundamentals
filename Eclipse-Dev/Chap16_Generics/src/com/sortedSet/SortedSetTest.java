package com.sortedSet;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetTest {

	public static void main(String[] args) {
		String[] colors = { "yellow", "green", "black", "tan", "grey", "white", "orange", "red", "green" };
		SortedSet<String> sortedSet = new TreeSet<String>(Arrays.asList(colors));

		// get contents of the tree
		System.out.print("Sorted set:");
		printSet(sortedSet);
		
		// get tree head
		System.out.print("Every color less then orange - ");
		printSet(sortedSet.headSet("orange"));
		
		// get tree tail
		System.out.print("Every color higher or equal to orange - ");
		printSet(sortedSet.tailSet("orange"));
		
		// get first and last element
		System.out.println("First element: " + sortedSet.first());
		System.out.println("Last element: " + sortedSet.last());
		
		System.out.println("Return elements between tan(inclusive) and yellow(exclusive) " + sortedSet.subSet("tan", "yellow"));
		System.out.println("Does the green color exist " + sortedSet.contains("green"));
		System.out.println("Is the list empty " + sortedSet.isEmpty());
	}

	private static void printSet(SortedSet<String> set) {
		for (String s : set) {
			System.out.printf("%s ", s);
		}
		
		System.out.println();
	}
}
