package com.ex1910;

import java.util.Arrays;
import java.security.SecureRandom;

public class QuickSort3 {

	private static int[] data = new int[10];
	
	public static void main(String[] args) {

		SecureRandom rand = new SecureRandom();
		for (int i = 0; i < data.length; i++) {
			data[i] = 10 + rand.nextInt(90);
		}
		
		System.out.println(Arrays.toString(data));
		quickSortHelper(0, data.length - 1);
		System.out.println(Arrays.toString(data));
	}

	public static void quickSortHelper(int low, int high) {
		int pivot = data[low + (high - low) / 2];
		
		int left = low;
		int right = high;
		
		while (left <= right) {
			while (data[left] < pivot)
				left++;
			while(data[right] > pivot)
				right--;
			
			if (left <= right){
				exchange(left, right);
				left++;
				right--;
			}
		}
		
		if (low < left)
			quickSortHelper(low, right);
		if (left < high)
			quickSortHelper(left, high);
	}
	
	
	private static void exchange(int i, int j) {
		int temp = data[i];
		data[j] = data[i];
		data[i] = temp;
	}
}
