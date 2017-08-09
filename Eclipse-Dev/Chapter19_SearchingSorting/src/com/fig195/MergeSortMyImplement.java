package com.fig195;

import java.security.SecureRandom;
import java.util.Arrays;

public class MergeSortMyImplement {

	public static void main(String[] args) {
		SecureRandom generator = new SecureRandom();
		
		int[] list = new int[7]; // create 4 items array;
		for (int i = 0; i < list.length; i++)
			list[i] = generator.nextInt(100);
		
		System.out.println("Unsorted array: " + Arrays.toString(list));
		
		mergeSort(list, 0, list.length - 1);
		System.out.println("Sorted array: " + Arrays.toString(list));
	}

	public static void mergeSort(int[] list, int low, int high) {
		if (low == high) // base case. meaning that the list has already been sorted
			return;
		
		// let's divide the list now
		int middle1 = (low + high) / 2;
		int middle2 = middle1 + 1;
		mergeSort(list, low, middle1); // break up the first half of the array "sort it"
		mergeSort(list, middle2, high); // break up or sort the second part of the array
		
		// helper method that does the actual sort and merge of the splitted arrays
		merge(list, low, middle1, high);
	}
	
	private static void merge(int[] list, int low, int middle, int high) {
		// reassign helper variables
		int leftIndex = low; // starting point of the left array
		int rightIndex = middle + 1; // this is the starting point of the right array
		int combinedIndex = low; // first index in the temp array
		int[] combined = new int[list.length];	// temp array to hold combined numbers
		
		// sort the subarrays
		while (leftIndex <= middle && rightIndex <= high) { // while there are still indexes in either of the two arrays
			if (list[leftIndex] <= list[rightIndex])
				combined[combinedIndex++] = list[leftIndex++];
			else
				combined[combinedIndex++] = list[rightIndex++];
		}
		
		// if there are no more items in either of the arrays, just copy the rest
		if (leftIndex == rightIndex) // there are no more elements in the left array
			while(rightIndex <= high)
				combined[combinedIndex++] = list[rightIndex++];
		else	// meaning that there are no more elements in the right array
			while(leftIndex <= middle) 
				combined[combinedIndex++] = list[leftIndex++];
		
		// now when the arrays are sorted we can copy to the original array
		for (int i = low; i <= high;i++)
			list[i] = combined[i];
						
	}
}
