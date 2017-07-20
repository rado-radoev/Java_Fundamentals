package com.figEmployee;

public class Employee {

	private String firstName;
	private String lastName;
	private Double salary;
	private String department;
	
	public Employee(String firstName, String lastName,
			Double salary, String department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.department = department;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Double getSalary() {
		return salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getName() {
		return String.format("%s %s", getFirstName(), getLastName());
	}
	
	@Override
	public String toString() {
		return String.format("%-8s %-8s %8.2f   %s", getFirstName(), getLastName(), getSalary(), getDepartment());
	}
}








