package com.ex1910;

import java.security.SecureRandom;
import java.util.Arrays;

public class QuickSort2 {
	
	private static int[] data = {49, 25, 99, 94, 77, 43, 43, 69, 41, 13};
	private static SecureRandom rand = new SecureRandom();
	
	public static void main(String[] args) {

		System.out.println("Unsorted:");
		System.out.println(Arrays.toString(data));
		System.out.println("Sorted:");
		
		long start = System.currentTimeMillis();
		quickSortHelper(0, data.length -1);
		long end = System.currentTimeMillis();
		long totalTime = end - start;
		
		System.out.println(Arrays.toString(data));
		System.out.println("Took: " + totalTime + "ms to run");
	}

	public static void quickSortHelper(int low, int high) {
		int pivot = data[low + (high - low) /2 ];
		
		int i = low;
		int j = high;

		while (i <= j) {
			while(data[i] < pivot) {
				i++;
			}
			while(data[j] > pivot) {
				j--;
			}
			
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}
		
		if (low < i)
			quickSortHelper(low, j);
		if (i < high)
			quickSortHelper(i, high);
	}
	
	private static void exchange(int i, int j) {
		int temp = data[j];
		data[j] = data[i];
		data[i] = temp;
	}
}
