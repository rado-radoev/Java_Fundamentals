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
        // Initialize a Scanner to read input from the command line
    	Scanner scanner = new Scanner(System.in);
    	SalesPerson salesPerson = new SalesPerson(); 
        int itemsSoldTotal = 0;
    	int item = -1;
    	double commission;
        double totalEarnings = salesPerson.getSalary();
          	
    	while (item != 0) {
        	System.out.println("Item\tValue");
            System.out.println("1\t$239.99");
            System.out.println("2\t$129.75");
            System.out.println("3\t$99.95");
            System.out.println("4\t$350.89"); 
            
            System.out.printf("Current compensation: %.2f%n", totalEarnings);
        	System.out.println("Please select an item from the list above (or enter 0 to exit):");
        	item = scanner.nextInt();
    		
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
				System.out.println("ERROR: Invalid input!");
				break;
			}
    		
        	commission = itemsSoldTotal * salesPerson.getCommission();
        	totalEarnings = commission + salesPerson.getSalary();
    	}
    	
    	scanner.close();
    	System.out.printf("Total earnings: %.2f",totalEarnings);
    }
    
}
