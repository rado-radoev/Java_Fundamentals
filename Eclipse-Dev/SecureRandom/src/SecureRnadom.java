import java.security.SecureRandom;

public class SecureRnadom {

	public static void main(String[] args) {
		SecureRandom randomNumber = new SecureRandom();

		// Simulate coin tossing
		int randomValue = randomNumber.nextInt(2);
		
		// Simulate dice rolling 1-6
		int face = 1 + randomNumber.nextInt(6);
	}

}
