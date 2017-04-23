import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSort {

	public static void main(String[] args) {
		int[] numbers = {1, 4, 6, 9, 2, 10, 1, 3, 5, 12, 8, 20, 13, 15, 7, 11};
		int[] array = {4, 3, 2, 5, 7, 6, 9, 8, 1};
		
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(4, 3, 2, 5, 7, 6, 9, 8, 1));
		

		printArray(sort5(array));
	}

	private static int[] sort(int[] list) {
		int i, j, key;
		
		for (i = 1; i < list.length; i++) {
			key = list[i];
			j = i - 1;
			
			while (j >= 0 && list[j] > key) {
				list[j + 1] = list[j];
				j--;
			}
			list[j + 1] = key;
		}
		
		return list;
	}
	
	
	private static int[] sort1(int[] list) {
		int i, j, temp, key;
		
		for (i = 1; i < list.length; i++) {
			key = list[i];
			j = i - 1;
			
			while (j >= 0 && key < list[j]) {
				temp = list[j];
				list[j] = list[j + 1];
				list[j + 1] = temp;
				j--;
			}
		}
		return list;
	}
	
	private static int[] sort2(int[] list) {
		for (int i = 1; i < list.length; i++) {
			int key = list[i];
			int j = i - 1;
			
			while (j >= 0 && list[j] > key) {
				int temp = list[j];
				list[j] = list[j + 1];
				list[j + 1] = temp;
				j--;
			}
		}
		
		return list;
	}

	private static int[] sort3(int[] list) {
		for (int i = 1; i < list.length; i++) {
			int key = list[i];
			int j = i - 1;
			
			while (j >= 0 && list[j] > key) {
				int temp = list[j];
				list[j] = list[j+1];
				list[j+1] = temp;
				j--;
			}
		}
		return list; 
	}
	
	private static ArrayList<Integer> sort4(ArrayList<Integer> list) {
		for (int i = 1; i < list.size();i++) {
			int key = list.get(i);
			int j = i - 1;
			
			while (j >= 0 && list.get(j) > key) {
				list.set(list.get(j), list.get(j + 1));
				j--;
			}
			list.set(list.get(j + 1), list.get(j));
		}
		
		return list;
	}
	
	private static int[] sort5(int[] list) {
		for (int i = 1; i < list.length; i++) {
			int key = list[i];
			int j = i - 1;
			
			while (j >= 0 && list[j] > key) {
				list[j + 1] = list[j];
				j--;
			}
			list[j + 1] = key;
		}
		return list;
	}
	
	private static void printArray(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.printf("%s ", A[i]);
		}
	}
}
