import java.security.SecureRandom;
import java.util.Scanner;

public class CoinTossing {

	private static int headsCount = 0;
	private static int tailsCount = 0;
	
	public static void coinToss() {
		Scanner scanner = new Scanner(System.in);
		int input = -1;
		
		while (input != 0) {
			System.out.println("Press 1 to toss a coin. Press 0 to quit");
			input = scanner.nextInt();
			
			if (input == 1) {
				System.out.printf("Coin landed on %s%n",flip());
			}
		}
		System.out.printf("Number of times coin landed on heads - %d%n", headsCount);
		System.out.printf("Number of times coin landed on tails - %d%n", tailsCount);
		scanner.close();
	}
	
	public static Coin flip() {
		SecureRandom randomNumber = new SecureRandom();
		Coin coin = null;
		
		int toss = randomNumber.nextInt(2); // get random number between 0 and 1
		switch (toss) {
		case 0:
			coin = coin.HEADS;
			headsCount++;
			break;
		case 1:
			coin = coin.TAILS;
			tailsCount++;
			break;
		}
		
		return coin;
	}
}
