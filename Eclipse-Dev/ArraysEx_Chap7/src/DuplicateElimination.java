import java.security.SecureRandom;
import java.util.Arrays;

public class DuplicateElimination {

	private static SecureRandom randomNumber = new SecureRandom();
	
	public static void main(String[] args) {
		
		int[] uniqueNumbers = new int[5];
		int counter = 0;
		
		while (counter < 5) {
			int num = 10 + randomNumber.nextInt(91);
			
			if (!searchArray2(uniqueNumbers, num)) {
				uniqueNumbers[counter] = num;
				counter++;
			}
		}

	}
	
	private static boolean searchArray2(int[] array, int number) {
		for (int i : array) {
			if (i == number) {
				return true;
			}
		}
		return false;
	}
	
	
	private static boolean searchArray(int[] arr, int number) {
		// implement binary search
		int i = 1;
		int j = arr.length - 1;
		
		while (i < j) {
			int m = (i + j) / 2;
			
			if (number > arr[m])
				i = m + 1;
			else
				j = m;
		}
		
		if (number == arr[i])
			return true;
		else
			return false;
	}
	
	
	
	private static int[] sortArray (int[] arr) {
		// implement insertion sort
		int i, j, temp, key;
		for (i = 1; i < arr.length; i++) {
			key = arr[i];
			j = i - 1;
			while (j >= 0 && key < arr[j]) {
				temp = arr[j];
				arr[j]  = arr[j + 1];
				arr[j + 1] = temp;
				j--;
			}
		}
		
		return arr;
	}

}
