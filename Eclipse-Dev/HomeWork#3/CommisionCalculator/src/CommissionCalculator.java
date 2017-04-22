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
    	   	
    	SalesPerson salesPerson = new SalesPerson.SalesPersonBuilder(200, 0.09).build(); 	// Create new sales person object
    	
    	// Display sales person total earnings
    	System.out.printf("Total earnings: %.2f",totalEarningsCalculate(salesPerson));
    }
    
    
    private static double totalEarningsCalculate (SalesPerson salesPerson) {
    	Scanner scanner = new Scanner(System.in);
    	int itemsSoldTotal = 0;		// Variable to contain the total amount of sold items 
    	int item = -1;		// Initialize item variable that holds the user input
    	double commission;		// Total commission the sales person has earned
    	double totalEarnings = salesPerson.getSalary();		// Total earning the sales person has made (salary + commission)
    	
        // Create 4 item objects with prices
        Item item1 = new Item(239.99);
        Item item2 = new Item(129.75);
        Item item3 = new Item(99.95);
        Item item4 = new Item(350.89);
    	
    	// Keep asking the user for input until 0 is entered
    	while (item != 0) {
        	System.out.println("Item\tValue");
            System.out.printf("1\t$%.2f%n",item1.getPrice());
            System.out.printf("2\t$%.2f%n",item2.getPrice());
            System.out.printf("3\t$%.2f%n",item3.getPrice());
            System.out.printf("4\t$%.2f%n",item4.getPrice());
            
            System.out.printf("Current compensation: %.2f%n", totalEarnings);
        	System.out.println("Please select an item from the list above (or enter 0 to exit):");
        	item = scanner.nextInt();
    		
        	// Add item's price to total items sold
    		switch (item) {
    		case 0:
    			break;
			case 1:
				itemsSoldTotal += item1.getPrice();
				break;
			case 2:
				itemsSoldTotal += item2.getPrice();
				break;
			case 3:
				itemsSoldTotal += item3.getPrice();
				break;
			case 4:
				itemsSoldTotal += item4.getPrice();
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
    	
    	scanner.close();
    	return totalEarnings;
    }
}
