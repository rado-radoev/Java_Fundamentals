/*
 * BasePlusCommissionEmployeeComposition.java
 */

public class BasePlusCommissionEmployeeComposition {
    
	// BasePlusCommissionEmployee attributes
    private double baseSalary; // base salary per week
    
    // Demonstrate composition of (as opposed to inheritance from) a CommissionEmployee object
    private CommissionEmployee commissionEmployee;
   
    
    // six-argument constructor
    public BasePlusCommissionEmployeeComposition( String first, String last, 
            String ssn, double sales, double rate, double salary) {
    	
    	commissionEmployee = new CommissionEmployee(first, last, ssn, sales, rate);

    	setBaseSalary(salary);
    }
    
    // Implement accessors and mutators for all six attributes (stubs appear below)
    // As per the text (demonstrated in its BasePlusCommissionEmployee implementation), throw an IllegalArgumentException if the salary argument is negative
    public void setBaseSalary( double salary ) throws IllegalArgumentException {
    	if (salary < 0.0) {
    		throw new IllegalArgumentException();
    	}
    	
    	this.baseSalary = salary;
    }    

    public double getBaseSalary() {
    	return baseSalary;
    }

    public String getFirstName() {
    	return commissionEmployee.getFirstName();
    }

    public String getLastName() {
    	return commissionEmployee.getLastName();
    }

    public String getSocialSecurityNumber() {
    	return commissionEmployee.getSocialSecurityNumber();
    }

    public double getGrossSales() {
    	return commissionEmployee.getGrossSales();
    }

    public void setGrossSales(double sales) throws IllegalArgumentException {
    	if (sales < 0.0) {
    		throw new IllegalArgumentException();
    	}
    	commissionEmployee.setGrossSales(sales);
    }

    public double getCommissionRate() {
    	return commissionEmployee.getCommissionRate();
    }

    public void setCommissionRate(double rate) {
    	if (rate < 0.0) {
    		throw new IllegalArgumentException();
    	}
    	commissionEmployee.setCommissionRate(rate);
    }    
    
    public double earnings() {
    	return commissionEmployee.earnings() + getBaseSalary();
    }
    
    @Override
    public String toString() {        
    	return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f", 
    			"base-salaried commission employee",
    			getFirstName(),
    			getLastName(),
    			"social security number",
    			getSocialSecurityNumber(),
    			"gross sales",
    			getGrossSales(),
    			"commission rate",
    			getCommissionRate(),
    			"base salary",
    			getBaseSalary());
    }
    
}
