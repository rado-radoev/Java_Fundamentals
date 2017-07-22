package io.javabrains.common;

import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class Java7Solution {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);

		// Step 1: Sort list by last name
		Collections.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getLastName().compareTo(p2.getLastName());
			}
		});
		
		
		// Step 2: Create a method that prints all elements in the list
		printAll(people);
		
		System.out.printf("%n%n%n");
		// Step 3: Create a method that prints all people that have last name beginning with C
		//printLastNameWithC(people);
		printConditionally(people, new Condition() {
			
			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("C");
			}
		});
	}
	
	private static void printConditionally(List<Person> people, Condition condition) {
		for (Person p : people) {
			if (condition.test(p)) {
				System.out.println(p);
			}
		}
	}
	
	
	
	private static void printAll(List<Person> listOfPeople) {
		for (Person p : listOfPeople) {
			System.out.println(p);
		}
	}
	
	private static void printLastNameWithC(List<Person> peeps) {
		for (int i = 0; i < peeps.size(); i++) {
			if (peeps.get(i).getLastName().toLowerCase().charAt(0) == 'c') {
				System.out.println(peeps.get(i));
			}
		}
	}
}
