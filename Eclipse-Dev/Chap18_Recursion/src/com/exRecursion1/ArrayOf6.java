package com.exRecursion1;

/*
 	http://codingbat.com/prob/p108997
	Given an array of ints,
	compute recursively if the array contains a 6. 
	We'll use the convention of considering only the part of the array 
	that begins at the given index. In this way, 
	a recursive call can pass index+1 to move down the array. 
	The initial call will pass in index as 0.
 */

public class ArrayOf6 {

	public static void main(String[] args) {
		int[] arr = {1,4};
		
		System.out.println(array6(arr, 0));
	}
	
	public static boolean array6(int[] array, int index) {
		if (index >= array.length) 
			return false;
		
		if (array[index] == 6) 
			return true;
		
		return array6(array, index + 1);
		
	}

}
