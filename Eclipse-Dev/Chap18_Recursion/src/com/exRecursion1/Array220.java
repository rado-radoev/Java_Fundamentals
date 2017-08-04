package com.exRecursion1;

/*
 * http://codingbat.com/prob/p173469
 * Given an array of ints, compute recursively if the array contains 
 * somewhere a value followed in the array by that value times 10. 
 * We'll use the convention of considering only the part of the array 
 * that begins at the given index. In this way, a recursive call can pass 
 * index+1 to move down the array. The initial call will pass in index as 0.
 * */

public class Array220 {

	public static void main(String[] args) {
		int[] arr = {20, 2, 21, 210};
		System.out.println(array220(arr, 0));
	}

	public static boolean array220(int[] nums, int index) {
		if (index >= nums.length - 1) return false;
		
		if (nums[index] * 10 == nums[index + 1]) return true;
		
		return array220(nums, index + 1);
	}
}
