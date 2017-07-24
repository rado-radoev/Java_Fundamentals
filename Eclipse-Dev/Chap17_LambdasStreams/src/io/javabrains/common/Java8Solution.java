package io.javabrains.common;

import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class Java8Solution {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);

		// Step 1: Sort list by last name
		Collections.sort(people, (p1, p2) -> 
				p1.getLastName().compareTo(p2.getLastName()));
		
		
		// Step 2: Create a method that prints all elements in the list
		System.out.println("Printing all people");
		performConditionally(people, p -> true, 
				p -> System.out.println(p));
		
		System.out.printf("%n%n%n");
		// Step 3: Create a method that prints all people that have last name beginning with C
		//printLastNameWithC(people);
		System.out.println("Printing a list of people whose last name begins with C");
		performConditionally(people, p -> p.getLastName().startsWith("C"), 
				p -> System.out.println(p));

		System.out.printf("%n%n%n");
		System.out.println("Printing a list of people whose first name begins with C");
		performConditionally(people, p -> p.getFirstName().startsWith("C"), 
				p -> System.out.println(p.getFirstName()));
	
	}
	
	private static void performConditionally(List<Person> people, Predicate<Person> condition,
			Consumer<Person> consumer) {
		for (Person p : people) {
			if (condition.test(p)) {
				consumer.accept(p);
			}
		}
	}
}
