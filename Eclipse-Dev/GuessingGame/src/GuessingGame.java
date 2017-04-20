import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

	private static int number;
	
	public static void guessNumber() {
		Random random = new Random();
		number = random.nextInt(1000) + 1;
		int guess = 0;
		Scanner scanner = new Scanner(System.in);
		
		while (guess == number) {
			System.out.println("Take a guess:");
			guess = scanner.nextInt();
			
			if (guess == number) {
				System.out.println("You guessed it!. The number is " + guess);
				return;
			}
			else {
				
			}
		}
	}
	
	public static void main(String[] args) {
		int min = 1;
		int max = 1000;

		int random = 42;
		
		
		while (true) {
			int mid = min + (max - min) / 2;
			if (random == mid) {
				System.out.printf("Number found %d%n", mid);
			}
			else if (mid < random) {
				System.out.printf("Number is in the range %d %d%n", min, max);
				min = mid + 1;
			}
			else {
				System.out.printf("Number is in the range %d %d%n", min, max);
				max = min - 1;
			}
		}
	}
}
