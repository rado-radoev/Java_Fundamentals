import java.util.Random;

public class DiceRolling {

	private static Random rand = new Random();
	
	public static void main(String[] args) {
		int dice1;
		int dice2;
		int sum;
		
		int[] frequency = new int[13];

		
		for (int i = 0; i <= 36000000;i++) {
			dice1 = 1 + rand.nextInt(6);
			dice2 = 1 + rand.nextInt(6);
			
			++frequency[dice1 + dice2];
		}
		
		System.out.printf("%s%8s%n", "Sum", "Rolled");
		for (int i = 2; i < frequency.length; i++) {
			System.out.printf("%d%10d%n", i, frequency[i]);
		}
		
		System.out.println();
		System.out.println();
		
		System.out.print("Sorted");
		sortArray(frequency);
		displayArray(frequency);
		
	}
	
	private static void displayArray(int[] arr) {
		System.out.printf("%s%8s%n", "Sum", "Rolled");
		for (int i = 2; i < arr.length; i++) {
			System.out.printf("%d%10d%n", i, arr[i]);
		}
	}
	
	private static int[] sortArray(int[] arr) {
		int i, j, key;
		for (i = 1; i < arr.length; i++) {
			key = arr[i];
			j = i - 1;
			while (j >= 0 && key < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		
		return arr;
	}

}
