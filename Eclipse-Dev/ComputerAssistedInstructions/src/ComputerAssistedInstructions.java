import java.security.SecureRandom;
import java.util.Scanner;

public class ComputerAssistedInstructions {

	private static SecureRandom randomNumber = new SecureRandom();
	private static int correctResponseCount;
	private static int wrongResponseCount;
	private static final int maxQuestions = 3;
	private static int counter;
	
	public static void main (String[] args) {
		
		int difficulty = difficultyLevel();
		int problems = problemType();
		while(true)
			calculate(difficulty, problems);
		
	}
	
	public static int calculate(int difficulty, int problems) {
		Scanner scanner = new Scanner(System.in);
		int num1 = randomNumber.nextInt(difficulty) + 1;
		int num2 = randomNumber.nextInt(difficulty) + 1;
		int result = 0;
		int input = -1;
		
		if (problems == 5) 
			problems = randomNumber.nextInt(4) + 1;
		
		switch (problems) {
		case 1:
			result = num1 + num2;
			System.out.printf("How much is %d added to %d%n", num1, num2);
			break;
		case 2:
			result = num1 - num2;
			System.out.printf("How much is %d substracted from %d%n", num1, num2);
			break;
		case 3:
			result = num1 * num2;
			System.out.printf("How much is %d multiplied to %d%n", num1, num2);
			break;
		case 4:
			result = num1 / num2;
			System.out.printf("How much is %d divided to %d%n", num1, num2);
			break;
		}
		

		while (result != input) {
			int answer = randomNumber.nextInt(4) + 1;
			input = scanner.nextInt();
			counter++;
			
			if (counter > maxQuestions) {
				calculatePercentage(correctResponseCount, wrongResponseCount, maxQuestions);
				break;
			}
			
			if (result == input) {
				System.out.println(correctAnswer(answer));
				correctResponseCount++;
			}
			else {
				System.out.println(wrongAnswer(answer));
				wrongResponseCount++;
			}	
		}
		return result;
	}
	
	private static int problemType() {
		System.out.println("Select type of problem\n" + 
				"1. Additon problems only\n" +
				"2. Subtraction problems only\n" + 
				"3. Multiplication problems only\n" + 
				"4. Division problems only\n" +
				"5. Random mixture of all types");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		return input;
	}
	
	private static int difficultyLevel() {
		System.out.println("Please choose diffuculty level. Each level adds 10 more numbers to the random number");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		switch (input) {
		case 1:
			return 10;
		case 2:
			return 90;
		case 3:
			return 999;
		case 4: 
			return 9999;
		default:
			return 99999;
		}
	}
	
	private static void calculatePercentage(int correctResponseCount, int wrongResponseCount, int numberOfQuestions) {
		float result = ((correctResponseCount - wrongResponseCount) / numberOfQuestions) * 100;
		if (result > 75) {
			System.out.println("Congratulations, you are ready to go to the next level!");
		}
		else {
			System.out.println("Please ask your teacher for extra help.");
		}
	}
	
	private static String correctAnswer(int choice) {
		 switch (choice) {
		case 1:
			return "Very Good!";
		case 2:
			return "Excellent!";
		case 3:
			return "Nice Work!";
		default:
			return "Keep up the good work!";
		}
	}
	
	private static String wrongAnswer(int choice) {
		 switch (choice) {
		case 1:
			return "No. Please try again.";
		case 2:
			return "Wrong. Try once more.";
		case 3:
			return "Don't give up.";
		default:
			return "No. Keep trying.";
		}
	}
}
