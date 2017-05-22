package com.inheritance;

public class HourlyEmployee extends Employee {

	private double hours = 0;	// hours worked
	private double wage = 0;	// wage per hour
	
	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
		super (firstName, lastName, socialSecurityNumber);
		
		setWage(wage);
		setHours(hours);
	}
	
	public double getWage() {
		return wage;
	}
	
	public double getHours() {
		return hours;
	}
	
	public void setWage(double wage) throws IllegalArgumentException {
		if (wage <= 0) {
			throw new IllegalArgumentException("Wage can not be zero or negative");		// noone works for no payment
		}
		
		this.wage = wage;
	}
	
	public void setHours(double hours) {
		if (hours < 0 || hours > 168) {	// cannot work negative hours and cannot work more than 168 total hours in a week, unless superhuman.
			throw new IllegalArgumentException("Hours worked must be between 0 and 168 hours");
		}
		this.hours = hours;
	}
	
	public double earnings() {
		return getHours() * getWage();
	}
	
	
	@Override
	public String toString() {
		return String.format("%s%s: %.2f%n%s: %.2f%n%s: %.2f", 
				super.toString(),
				"hours worked",
				getHours(),
				"hourly wage",
				getWage(),
				"gross wage",
				earnings());
	}
}
