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
                
    	Scanner scanner = new Scanner(System.in);

    		int input = 0;
    		do {
    			System.out.print("How many integers shall we compare? (Enter a positive integer): ");
            	input = scanner.nextInt();
            	if (!inputVerification(input)) {
            		System.out.println("Invalid input!");
            	} 
			} while (!inputVerification(input));

    	int smallest = Integer.MAX_VALUE;

        for(int i = 0; i < input ;i++ ) {
        	
        		// Prompt as follows
            	System.out.printf("Enter value %d: ", i + 1);
            	int guess = scanner.nextInt();
            	
            	if (guess < smallest) {
            		smallest = guess;
            	}
        }
        
        System.out.println("The smallest number entered was: " + smallest);
    }
    
    private static boolean inputVerification(int input) {
    	if (input > 0) {
    		return true;
		}
    	else return false;
    }
}
