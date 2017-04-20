import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

	private static int number;
	private static Random random = new Random();
	 private static int min = 1;
	 private static int max = 1000;
	 
	public static void guessNumber() {
		
		number = random.nextInt(1000) + 1;
		int guess = 0;
		Scanner scanner = new Scanner(System.in);
		
		while (guess != number) {
			System.out.println("Take a guess:");
			guess = scanner.nextInt();
			
			if (guess == number) {
				System.out.println("You guessed it!. The number is " + guess);
				return;
			}
			else if (guess > number) {
				System.out.printf("Guess lower.%n");
				
			}
			else {
				System.out.printf("Guess higher.%n" );
			}
			displayGuessRange();
			System.out.printf("Number is in range %d - %d%n", min, max);
		}
	}
	
	public static void main(String[] args) {
		guessNumber();
	}
	
	public static void displayGuessRange() {
		
		while (min <= max) {
			int mid = min + (max - min) / 2;
			if (number < mid)
				max = mid - 1;
			else
				min = mid + 1;

			return;
		}
	}
}
