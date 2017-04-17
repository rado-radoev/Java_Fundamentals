import java.security.SecureRandom;

import javax.net.ssl.SSLEngineResult.Status;

public class Craps {
	
	// Create secure random number generator for use in method rolldice
	private static final SecureRandom randomNumbers = new SecureRandom();
	
	// Enum type with constants that represent the game status
	private enum Status{ CONTINUE, WON, LOST};
	
	// Constants that represent common rolls of the dice
	private static final int SNAKE_EYE = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;
    
    // Play the game of craps
	public static void main(String[] args) {
		int myPoint = 0; // point if no win or loss on first roll
		Status gameStatus; // Can contain CONTINUE, WON, LOST
		
		int sumOfDice = rollDice(); // first roll of the dice
		
		// Determine game status and oint based on first roll
		switch (sumOfDice) {
		case SEVEN: // win with 7 on the first roll
		case YO_LEVEN:	// win with 11 on the first roll
			gameStatus = Status.WON;
			break;
		case SNAKE_EYE:	// lose with 2 on the first roll
		case TREY:	// lose with 3 on the first roll
		case BOX_CARS:	 // lose with 12 on the first roll
			gameStatus = Status.LOST;
		default:	// did not win or lose, so remember point
			gameStatus = Status.CONTINUE;	// game is not over
			myPoint =  sumOfDice;	// remember the point
			System.out.printf("Point is %d%n", myPoint);
			break;
		}
		
		// while game is not complete
		while (gameStatus == Status.CONTINUE) {
			sumOfDice = rollDice();	// roll dice again
			
			// determine game status
			if (sumOfDice == myPoint) // win by making point
				gameStatus = Status.WON;
			else
				if (sumOfDice == SEVEN)	// loose by rolling 7 before point
					gameStatus = Status.LOST;
			
			// display won or lost message
			if (gameStatus == Status.WON)
				System.err.println("Player wins");
			else
				System.out.println("Player loses");
		}
		
	}
	
	// roll dice, calculate sum and display result
	public static int rollDice() {
		// pick random die value
		int die1 = 1 + randomNumbers.nextInt(6);	// first die roll
		int die2 = 1 + randomNumbers.nextInt(6);	// second die roll
		
		int sum = die1 + die2;	// sum of die values
		
		// display results of this roll
		System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);
		
		return sum;
	}

}
