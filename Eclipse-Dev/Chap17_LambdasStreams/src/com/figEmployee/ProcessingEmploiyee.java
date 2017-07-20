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
				new Employee("Jason", "Red", 5000D, "IT"),
				new Employee("Ashley", "Green", 7600D, "IT"),
				new Employee("Matthew", "Indigo", 3587.5D, "Sales"),
				new Employee("James", "Indigo", 4700.77D, "Marketing"),
				new Employee("Luke", "Indigo", 6200D, "IT"),
				new Employee("Jason", "Blue", 3200D, "Sales"),
				new Employee("Wendy", "Brown", 4236.4D, "Marketing")};
		
		
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
		
		
		// Function for getting first and last name from an employee
		// return the object as a String
		Function<Employee, String> byFirstName = Employee::getFirstName;
		Function<Employee, String> byLastName = Employee::getLastName;
		
		// Comparator for comparing employees by last then by first name
		Comparator<Employee> lastThenFirst = 
				Comparator.comparing(byLastName).thenComparing(byFirstName);
		
		// sort employees by last then by first name
		System.out.printf("%nEmployees in ascending order by last name then first:%n");
		list.stream()
			.sorted(lastThenFirst)
			.forEach(System.out::println);
		
		// sort employees in descending order by last name then by first
		System.out.printf("%nEmployees in descending order by last name then first:%n");
		list.stream()
			.sorted(lastThenFirst.reversed())
			.forEach(System.out::println);
		
		
		// display unique employee last name
		System.out.printf("%nUnique employee last names:%n");
		list.stream()
			.map(Employee::getLastName)
			.distinct()
			.sorted()
			.forEach(System.out::println);
		
		// display only first and last names
		System.out.printf("%nEmployee names in order of last name then first name%n", args);
		list.stream()
			.sorted(lastThenFirst)
			.map(Employee::getName)
			.forEach(System.out::println);
		
		
		// group employees by department
		System.out.printf("%nEmployees by department:%n");
		Map<String, List<Employee>> groupedByDepartment = 
				list.stream()
					.collect(Collectors.groupingBy(Employee::getDepartment));
		
		groupedByDepartment.forEach(
				(department, employeesInDepartment) -> 
				{
					System.out.println(department);
					employeesInDepartment.forEach(employee -> System.out.printf("%15s%n", employee));
				});
		
		
		// group employees by salary range
		Predicate<Employee> underFourThousand = emp -> emp.getSalary() <= 4000;
		Predicate<Employee> overFourThousand = emp -> emp.getSalary() > 4000;
		
		System.out.printf("%nEmployes grouped by salary under and over 4000:%n");
		Map<Double, List<Employee>> groupedBySalaryOver4K = 
				list.stream()
					.filter(overFourThousand)
					.collect(Collectors.groupingBy(Employee::getSalary));
		
		System.out.printf("%nEmployees with salary over 4K:%n");
		groupedBySalaryOver4K.forEach(
				(salary, employeeWithSalary) ->
				{
					employeeWithSalary.forEach(employee -> System.out.printf("%s %s%n", employee.getFirstName(), employee.getLastName()));
				}
			);
		
		System.out.printf("%nEmployees with salary under 4K:%n");
		Map<Double, List<Employee>> groupedBySalaryUnder4K = 
				list.stream()
					.filter(underFourThousand)
					.collect(Collectors.groupingBy(Employee::getSalary));
	
		groupedBySalaryUnder4K.forEach(
				(salary, employeeWithSalary) -> 
				{
					employeeWithSalary.forEach(employee -> System.out.printf("%s %s%n", employee.getFirstName(), employee.getLastName()));
				}
			);
		
		
		// count number of Employees in each department
		System.out.printf("%nCount number of employees by department:%n");
		Map<String, Long> employeeCountByDepartment = 
				list.stream()
					.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		
		employeeCountByDepartment.forEach(
				(department, count) -> System.out.printf("%s has %d %s%n", department, count, (count > 1 ? "employees" : "employee")));
		
		
		// count employees with salaries over and under 4000
		System.out.printf("%nEmployees with salaries over and under 4000:%n");
		Map<Double, Long> employeesCountWithSalaryOver4K = 
				list.stream()
					.filter(overFourThousand)
					.collect(Collectors.groupingBy(Employee::getSalary, Collectors.counting()));
		
		employeesCountWithSalaryOver4K.forEach(
			(salary, count) -> System.out.printf("%.2f salary received %d employee(s)%n", salary, count));
	
		
		// sum of Employee salaries with DoubleStram sum method
		System.out.printf("%nSum of Employee's salaries (via sum method): %.2f%n",
				list.stream()
					.mapToDouble(Employee::getSalary)
					.sum());

		// calculate sum of Employee salaries with Stream reduce method
		System.out.printf("%nSum of Employee's salaries (via reduce method): %.2f%n", 
				list.stream()
					.mapToDouble(Employee::getSalary)
					.reduce(0, (x,y) -> x + y));
	
		// average of Employee salaries with DoubleStram average method
		System.out.printf("%nAverage of Employee's salaries: %.2f%n", 
				list.stream()
					.mapToDouble(Employee::getSalary)
					.average()
					.getAsDouble());
	
	}
	

}



















