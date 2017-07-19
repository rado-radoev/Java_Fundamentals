package com.figEmployee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessingEmploiyee {

	public static void main(String[] args) {
		// initialize array of employees
		Employee[] employees = {
				new Employee("Jason", "Red", 5000, "IT"),
				new Employee("Ashley", "Green", 7600, "IT"),
				new Employee("Matthew", "Indigo", 3587.5, "Sales"),
				new Employee("James", "Indigo", 4700.77, "Marketing"),
				new Employee("Luke", "Indigo", 6200, "IT"),
				new Employee("Jason", "Blue", 3200, "Sales"),
				new Employee("Wendy", "Brown", 4236.4, "Marketing")};
		
		
		// get list view of the employees
		List<Employee> list = Arrays.asList(employees);
		
		// display all employees
		// instance method System.out::println - implements the Consumer interface
		// and calls the accept method, which accepts one argument and returns void
		// in this case the overriden toStirng method of employee is called.
		System.out.println("Complete employee list:");
		list.stream().forEach(System.out::println);
		
		// predicate that returns true if salary is in range 4000-6000
		Predicate<Employee> fourToSixThousand = 
				e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);
				
		// Display employees with salaries in the range 4000-6000, sorted into
		// ascending order by salary
		System.out.printf("%nEmployees earning $4000-$6000 per month, sorted by salary:%n"); 
				list.stream()
					.filter(fourToSixThousand)
					.sorted(Comparator.comparing(Employee::getSalary))
					.forEach(System.out::println);
				
		// Display first employee in the range of salaries 4000-6000
		System.out.printf("%nFirst employee who earns $4000 - $6000:%n%s%n", 
				list.stream()
				.filter(fourToSixThousand)
				.findFirst()
				.get());
	}

}



















