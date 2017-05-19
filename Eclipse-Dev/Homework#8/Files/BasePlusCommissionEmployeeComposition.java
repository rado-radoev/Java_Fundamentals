/*
 * BasePlusCommissionEmployeeComposition.java
 */

public class BasePlusCommissionEmployeeComposition {
    
    private double baseSalary; // base salary per week
    // Demonstrate composition of (as opposed to inheritance from) a CommissionEmployee object
    
    // six-argument constructor
    public BasePlusCommissionEmployeeComposition( String first, String last, 
            String ssn, double sales, double rate, double salary) {
    	// TODO: implement this constructor
    }
    
    // Implement accessors and mutators for all six attributes (stubs appear below)
    // As per the text (demonstrated in its BasePlusCommissionEmployee implementation), throw an IllegalArgumentException if the salary argument is negative
    public void setBaseSalary( double salary ) {
    	// TODO: implement this method
    }    

    public double getBaseSalary() {
    	// TODO: implement this method
    }

    public String getFirstName() {
    	// TODO: implement this method
    }

    public String getLastName() {
    	// TODO: implement this method
    }

    public String getSocialSecurityNumber() {
    	// TODO: implement this method
    }

    public double getGrossSales() {
    	// TODO: implement this method
    }

    public void setGrossSales(double sales) {
    	// TODO: implement this method
    }

    public double getCommissionRate() {
    	// TODO: implement this method
    }

    public void setCommissionRate(double rate) {
    	// TODO: implement this method
    }    
    
    public double earnings() {
    	// TODO: implement this method
    }
    
    @Override
    public String toString() {        
    	// TODO: implement this method
    }
}
