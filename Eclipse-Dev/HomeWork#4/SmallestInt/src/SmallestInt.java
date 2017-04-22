/*
 * SmallestInt.java
 */

/**
 *
 * @author Radoslav Radoev
 */

import java.util.Scanner;

public class SmallestInt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    	calculateSmallest();
    }
    
    public static void calculateSmallest() {
    	Scanner scanner = new Scanner(System.in); // Instantiate scanner object

		int input = 0; // Select user input to a dummy value
		
		// Ask the user on how many integers he/she would input, until a valid integer is entered
		do {
			System.out.print("How many integers shall we compare? (Enter a positive integer): ");
        	input = scanner.nextInt();
        	if (!inputVerification(input)) {	// Verify if input > 0
        		System.out.println("Invalid input!");
        	} 
		} while (!inputVerification(input));	// Continue prompting while an input > 0 is entered

    	int smallest = Integer.MAX_VALUE;	// Set the smallest variable to the largest possible Integer value.

        for(int i = 0; i < input ;i++ ) {
        	
        		// Prompt user for input
            	System.out.printf("Enter value %d: ", i + 1);
            	int guess = scanner.nextInt();	// Read user's input
            	
            	if (guess < smallest) {	// Check if user input is smaller then smallest value
            		smallest = guess;	// If input is smaller than the smallest value, reassign the smallest variable value to the user's guess (new smallest)
            	}
        }
        scanner.close();	// Close scanner object
        
        System.out.println("The smallest number entered was: " + smallest);		// Display the smallest value
    }
    
    // Input verification method. User input value should be larger than 0
    private static boolean inputVerification(int input) {
    	if (input > 0) {
    		return true;
		}
    	else return false;
    }
}
