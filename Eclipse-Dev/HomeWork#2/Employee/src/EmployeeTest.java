/*
 * EmployeeTest.java
 */

/**
 *
 * @author Radoslav Radoev
 */
public class EmployeeTest {
    
    public static void main(String args[]){
    	// Create two Employee objects
    	Employee emp1 = new Employee("Benjamin", "Bernanke", 1234.56);
    	Employee emp2 = new Employee("Paul", "Volcker", 2345.67);

    	// Display the employees' info (including yearly salary)
    	System.out.println(emp1.getFirstName() + " " + emp1.getLastName() + "'s yearly salary: " + emp1.getMonthlySalary() * 12);
    	System.out.println(emp2.getFirstName() + " " + emp2.getLastName() + "'s yearly salary: " + emp2.getMonthlySalary() * 12);

    	// Give each employee a 10% raises.
        System.out.println("Giving raises...");
        emp1.setMonthlySalary(emp1.getMonthlySalary() +  (emp1.getMonthlySalary() * 0.1));
        emp2.setMonthlySalary(emp2.getMonthlySalary() +  (emp2.getMonthlySalary() * 0.1));
        
        // Display the employees' info (including yearly salary)
    	System.out.println(emp1.getFirstName() + " " + emp1.getLastName() + "'s yearly salary: " + emp1.getMonthlySalary() * 12);
    	System.out.println(emp2.getFirstName() + " " + emp2.getLastName() + "'s yearly salary: " + emp2.getMonthlySalary() * 12);

    	// Display Bernanke's info (including yearly salary)
        System.out.println("Attempting to set a negative salary value...");
    	// Attempt to set Bernanke's salary to a negative value...
        emp1.setMonthlySalary(-1);
        System.out.println(emp1.getFirstName() + " " + emp1.getLastName() + "'s yearly salary: " + emp1.getMonthlySalary() * 12);
    }
    
}
