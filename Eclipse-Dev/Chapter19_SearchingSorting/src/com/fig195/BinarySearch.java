package com.fig195;

import java.security.SecureRandom;
import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		SecureRandom generator = new SecureRandom();
		
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = generator.nextInt(20);
		}
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("Key found at position: " + binarySearch(arr, 5));
	}

	
	private static int binarySearch(int[] list, int key) {
		int low = 0;
		int high = list.length - 1;
		int middle = (low + high + 1) / 2;
		int location = -1;
		
		while ((low <= high) && (location == -1)) {
			if (key == list[middle]) 
				location = middle;
			else if (key < list[middle])
				high = middle - 1;
			else 
				low = middle + 1;
			
			middle = (low + high + 1) / 2;
		}
		
		return location;
	}
}
