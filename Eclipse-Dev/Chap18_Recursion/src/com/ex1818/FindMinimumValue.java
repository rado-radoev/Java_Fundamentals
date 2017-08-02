package com.ex1818;

public class FindMinimumValue {

	public static void main(String[] args) {
		int[] arr = {1,5,6,8,2,4,5,-10,35,7,8,-999,0,7,5,4,44,3,33,2,2,-100};
		System.out.println(recursiveMinimum(arr, 0, Integer.MAX_VALUE));
	}

	// find minimum number in array 
	public static int recursiveMinimum(int[] array, int index, int min) {
		if (array.length == 0) {
			return 0;
		}
		
		if (index >= array.length) {
			return min;
		}
		
		if (array[index] < min) {
			min = array[index];
		}
		return recursiveMinimum(array, index + 1, min);
	}
}
