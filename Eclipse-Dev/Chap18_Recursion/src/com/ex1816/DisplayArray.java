package com.ex1816;

public class DisplayArray {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,6,7,8};	// this is the array
		String results = printArray(arr, arr.length - 1); // we want to print all elements of the array, 
		// so we need the array (param 1) and the starting index the last (param 2)
		System.out.println(results);
	}
	
	public static String printArray(int[] array, int x) {
		if (x >= 0) // keep printing the numbers, until the beginning of the array is reached
			return String.format("%s%d ", printArray(array, x - 1), array[x]);
				// We print the array index, but before that we call the function, so it can return the 
				// integer at that array index
		else 
			return "";
	}

}
