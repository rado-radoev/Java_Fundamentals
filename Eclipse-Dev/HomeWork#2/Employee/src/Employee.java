/*
 * Employee.java
 */

/**
 *
 * @author Radoslav Radoev
 */
public class Employee {

	private String firstName;
	private String lastName;
	private double monthlySalary;
	
	/**
	 * Employee constructor
	 * @param firstName		Employee first name
	 * @param lastName		Employee last name
	 * @param monthlySalary		Employee monthly salary
	 */
	public Employee (String firstName, String lastName, double monthlySalary) {
		setFirstName(firstName);
		setLastName(lastName);
		setMonthlySalary(monthlySalary);	
	}
	
	/**
	 * Employee first name getter
	 * @return		Employee first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Employee first name setter
	 * @param firstName		Employee first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Employee last name getter
	 * @return		Employee last name 
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Employee last name setter
	 * @param lastName		Employee last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Employee monthly salary getter
	 * @return		Employee monthly salary
	 */
	public double getMonthlySalary() {
		return monthlySalary;
	}

	/**
	 * Employee monthly salary setter
	 * @param monthlySalary		Employee monthly salary
	 */
	public void setMonthlySalary(double monthlySalary) {
		// Verify if monthly salary is a positive number
		if (monthlySalary > 0.0)
			this.monthlySalary = monthlySalary;
	}
	
}
