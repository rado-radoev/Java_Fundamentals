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
        int itemsSoldTotal = 0;
        SalesPerson salesPerson = new SalesPerson(); 	
    	
    	System.out.println("Item\tValue");
        System.out.println("1\t$239.99");
        System.out.println("2\t$129.75");
        System.out.println("3\t$99.95");
        System.out.println("4\t$350.89"); 
        
        System.out.println("Sales person total earnings: " + salesPerson.getSalary());
    	System.out.println("Choose a value from 1 to 4. Enter 0 to exit");
    	int item = scanner.nextInt();
    	    	
    	while (item != 0) {
    		//scanner.nextLine();
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
    		
    		System.out.println("Choose a value from 1 to 4. Enter 0 to exit");
    		item = scanner.nextInt();
    	}
    	
    	double commission = itemsSoldTotal * salesPerson.getCommission();
    	double totalEarnings = commission + salesPerson.getSalary();
    	
    	System.out.printf("%.2f",totalEarnings);

    	/* Display the user's current compensation
    	 * 
    	 * Prompt and take input from the user (you may assume that they will only enter int values)
    	 * They'll enter an item number (1 - 4) to record its sale or 0 to exit
    	 * 
    	 * NOTE: THE USER DOES NOT ENTER PRICES DIRECTLY... THEY ENTER ITEM NUMBERS TO INDICATE WHAT WAS SOLD
    	 * NOTE: THE USER MAY ENTER THE SAME ITEM NUMBRER MULTIPLE TIMES
    	 * 
    	 * If the user provides invalid input (a value other than 0 - 4) display "ERROR: Invalid input!" and prompt them again
    	 */
    	
    	/* After the user enters 0, display the salesperson's earnings in the format "Total earnings: $NNN.NN" and exit
    	 * For example, if the salesperson sold two item 3s this week the final output would be "Total earnings: $217.99"
    	 */
    }
    
}
