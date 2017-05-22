package com.inheritance;

public class Employee {

	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	
	public Employee(String firstName, String lastName, String socialSecurityNumber) {
		super(); // call to object 
		
		setFirstName(firstName);
		setLastName(lastName);
		setSocialSecurityNumber(socialSecurityNumber);
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public String getSocialSecurityNumber()	{
		return socialSecurityNumber;
	}
	
	public final void setFirstName(String firstName) throws IllegalArgumentException {
		if (firstName.length() <= 0) {
			throw new IllegalArgumentException("First name not set.");
		}
		this.firstName = firstName;
	}
	
	public final void setLastName(String lastName) throws IllegalArgumentException {
		if (lastName.length() <= 0) {
			throw new IllegalArgumentException("Last name not set");
		}
		this.lastName = lastName;
	}
	
	public final void setSocialSecurityNumber(String socialSecurityNumber) throws IllegalArgumentException {
		if (!socialSecurityNumber.matches("^([1-9])(?!\1{2}-\1{2}-\1{4})[1-9]{2}-[1-9]{2}-[1-9]{4}")) {
			throw new IllegalArgumentException("Social Security Number should be in the format xxx-xx-xxx");
		}
		
		this.socialSecurityNumber = socialSecurityNumber;
	}
	
	public String toString() {
		return String.format("%s: %s %s%n%s: %s%n", 
				"employee",
				getFirstName(),
				getLastName(),
				"social security number",
				getSocialSecurityNumber());
	}
}
