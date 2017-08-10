package com.fig195;

import java.security.SecureRandom;
import java.util.Arrays;

public class MergeSortMyImplement {

	public static void mergeSort(int[] list) {
		sortArray(list, 0, list.length - 1);
	}
	

	private static void sortArray(int[] list, int low, int high) {
		if ((high - low ) >= 1) {
			int middle1 = (low + high) / 2; // calculate first middle
			int middle2 = middle1 + 1; // calc second middle
		
		
			sortArray(list, low, middle1); // sort through first array
			sortArray(list, middle2, high); // sort through second array
			
			merge(list, low, middle1, middle2, high); // merge subarrays
		}
	}
	
	private static void merge(int[] list, int low, int middle1, int middle2, int high) {
		int leftIndex = low;
		int rightIndex = middle2;
		int combinedIndex = low;
		int[] combined = new int[list.length];
		
		
		while (leftIndex <= middle1 && rightIndex <= high) {
			if (list[leftIndex] <= list[rightIndex])
				combined[combinedIndex++] = list[leftIndex++];
			else
				combined[combinedIndex++] = list[rightIndex++];
		}
		
		if (leftIndex == middle2)
			while (rightIndex <= high) 
				combined[combinedIndex++] = list[rightIndex++];
		else
			while (leftIndex <= middle1)
				combined[combinedIndex++] = list[leftIndex++];
		
		
		for (int i = low; i <= high;i++) {
			list[i] = combined[i];
		}
	}
		
	public static void main(String[] args) {
		SecureRandom generator = new SecureRandom();
		
		int[] list = new int[10]; // create 4 items array;
		for (int i = 0; i < list.length; i++)
			list[i] = generator.nextInt(100);
		
		System.out.println("Unsorted array: " + Arrays.toString(list));
		
		mergeSort(list);
		System.out.println("Sorted array: " + Arrays.toString(list));
	}
}

