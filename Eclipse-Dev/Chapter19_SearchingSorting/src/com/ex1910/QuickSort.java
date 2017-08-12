package com.ex1910;

import java.util.Arrays;

public class QuickSort {

	private static int[] data = {37, 2, 6, 4, 89, 8, 10, 12, 68, 45 };
	
	public static void main(String[] args) {
		System.out.println("Unsorted:");
		System.out.println(Arrays.toString(data));
		System.out.println("Sorted:");
		quickSort(0, data.length -1);
		System.out.println(Arrays.toString(data));
	}

	public static void quickSort(int low, int high) {
		int i = low;
		int j = high;
		
		int pivot = data[low + (high - low) / 2];
		
		while (i <= j) {
			while (data[i] < pivot)
				i++;
			while (data[j] > pivot)
				j--;
			
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}
		
		if (low < i)
			quickSort(low, j);
		if (i < high)
			quickSort(i, high);
	}

	private static void exchange(int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}
