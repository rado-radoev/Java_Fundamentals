/*
 * SalesPerson.java
 */

/**
 * 
 * @author Radoslav Radoev
 *
 */
public class SalesPerson {

	/**
	 * Sales person object fields
	 * @param salary 	Sales person base salary
	 * @param commission		Sales person commission in percent
	 */
	private final double salary = 200;
	private final double commission  = 0.09; 

	/**
	 * Sales person salary getter
	 * @return		Sales person salary in double
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * Sales person commission getter
	 * @return		Sales person commission in double
	 */
	public double getCommission() {
		return commission;
	}
	
	
}
