/*
 * CommissionCalculator.java
 */

/**
 *
 * @author Radoslav Radoev
 */

import java.util.Scanner;

public class CommissionCalculator {
    
    public static void main(String args[]) {
    	Scanner scanner = new Scanner(System.in);		// Initialize a Scanner to read input from the command line
    	SalesPerson salesPerson = new SalesPerson(); 	// Create new sales person object
        int itemsSoldTotal = 0;		// Variable to contain the total amount of sold items 
    	int item = -1;		// Initialize item variable that holds the user input
    	double commission;		// Total commission the sales person has earned
        double totalEarnings = salesPerson.getSalary();		// Total earning the sales person has made (salary + commission)
          	
        // Keep asking the user for input until 0 is entered
    	while (item != 0) {
        	System.out.println("Item\tValue");
            System.out.println("1\t$239.99");
            System.out.println("2\t$129.75");
            System.out.println("3\t$99.95");
            System.out.println("4\t$350.89"); 
            
            System.out.printf("Current compensation: %.2f%n", totalEarnings);
        	System.out.println("Please select an item from the list above (or enter 0 to exit):");
        	item = scanner.nextInt();
    		
        	// Add item's price to total items sold
    		switch (item) {
			case 1:
				itemsSoldTotal += 239.99;
				break;
			case 2:
				itemsSoldTotal += 129.75;
				break;
			case 3:
				itemsSoldTotal += 99.95;
				break;
			case 4:
				itemsSoldTotal += 350.89;
				break;				
			default:
				// Only 0-4 are valid choices
				System.out.println("ERROR: Invalid input!");
				break;
			}
    		
    		// Calculate commission and total earnings
        	commission = itemsSoldTotal * salesPerson.getCommission();
        	totalEarnings = commission + salesPerson.getSalary();
    	}
    	
    	// Close scanner object
    	scanner.close();
    	// Display sales person total earnings
    	System.out.printf("Total earnings: %.2f",totalEarnings);
    }
    
}
