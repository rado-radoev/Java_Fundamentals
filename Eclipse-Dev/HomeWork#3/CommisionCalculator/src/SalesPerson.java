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
	private final double salary;	// required
	private final double commission;	// required
	private final String name;		// optional
		

	private SalesPerson(SalesPersonBuilder builder) {
		this.salary = builder.salary;
		this.commission = builder.commission;
		this.name = builder.name;
	}

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
	
	/**
	 * Sales person name getter
	 * @return		Sales person name 
	 */
	public String getName() {
		return name;
	}
	
	
	// Helper builder class
	public static class SalesPersonBuilder {
		private final double salary;
		private final double commission;
		private String name;
		
		// Initialize the two mandatory fields
		public SalesPersonBuilder(double salary, double commission) {
			this.salary = salary;
			this.commission = commission;
		}
	
		// The salesPerson name is optional
		public SalesPersonBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		// Construct the final object
		public SalesPerson build() {
			SalesPerson salesPerson = new SalesPerson(this);
			return salesPerson;
		}
		
	}
}
