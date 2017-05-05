/*
 * RockNRollah.java
 */

import java.util.Random;

/**
 *
 * @author Radoslav Radoev
 */
public class RockNRollah {
	
	// Create a Random object
	private static Random rand = new Random();
       
    public static void main(String[] args) {
    	
    	// Initialize a couple of variables to hold the values of the two dice
		int dice1;
		int dice2;
		int rolls = 36000000;
		
    	// Initialize the array that will hold the results
		int[] frequencyArr = new int[13];
			
    	// Roll the dice (a lot) and sum and tally the results
		for (int i = 0; i < rolls; i++) {
			dice1 = rollDice();	// roll dice 1
			dice2 = rollDice();	// roll dice 2
			
			frequencyArr[dice1 + dice2]++;	// sum result from dice1 + dice2. The sum is the index in the frequencyArr. Increment that index by 1;
		}
		
        // Display the frequencies
        System.out.println("Results after " + rolls + " rolls");
        System.out.println("-------------------------");
        System.out.println("Value\tFrequency");
 
        
        // Loop, displaying the rows for the body of the table, each on its own line.
 		for (int i = 2; i < frequencyArr.length; i++) {
			System.out.printf("%d\t%d%n", i, frequencyArr[i]);
		}
	}
    
    /**
     * 
     * @return
     */
	public static int rollDice() {
		return 1 + rand.nextInt(6);
	}
}
