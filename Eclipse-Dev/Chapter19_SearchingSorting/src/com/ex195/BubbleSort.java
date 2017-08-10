package com.ex195;

import java.security.SecureRandom;
import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		SecureRandom sr = new SecureRandom();
		
		int[] array = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = sr.nextInt(10);
		}
		
		System.out.println(Arrays.toString(bubbleSort(array)));
	}
	
	
	/**
	 * sort primitive type int using bubble sort
	 * @param list Array of type int
	 * @return Array of type int
	 */
	public static int[] bubbleSort(int[] list) {
		boolean pass = false; // control variable. That eliminates additional passes to the array if already sorted
		for (int i = 0; i < list.length - 1;i++) {  // loop through each element starting from 0
			pass = false;	// set/reset the value to the control variable
			for (int j = 0; j < list.length - 1 - i;j++) { // inner loop. For each index in the array check the index pair - index & index + 1
				if (list[j] > list[j + 1]) { // if index is greater than index + 1 swap them
					int temp = list[j];
					list[j] = list[j+1];
					list[j + 1] = temp;
					pass = true; // we have made a modification, so at least one more iteration of the outer loop is nescessary
				}
			}
			
			if (!pass) return list; // if no modification to the array, in the inner loop has been made. There is nothing to sort
									// it is safe to return the list
		}
		return list;
	}

}
