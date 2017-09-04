package com.ex2118;

public class MergeSort {

	// call recursive split method to begin merge sorting
	public static void mergeSort(int[] data) {
		sortArray(data, 0, data.length - 1);	// sort entire array
	}
	
	// split array, sort subarray and merge subarrays into sorted array
	private static void sortArray(int[] data, int low, int high) {
		// test base case 
		if ((high -low) >= 1) {
			int middle1 = (low + high) / 2; // calculate middle of array
			int middle2 = middle1 + 1; // calculate next element over
			
			// output split step
//			 System.out.printf("split:   %s%n", 
//	           subarrayString(data, low, high));
//	         System.out.printf("         %s%n", 
//	            subarrayString(data, low, middle1));
//	         System.out.printf("         %s%n%n",
//	            subarrayString(data, middle2, high));
			
			// split array in half: sort each half(recursive calls)
			sortArray(data, low, middle1); // sort first half of the array
			sortArray(data, middle2, high); // soft second half of the array
			
			// merge two sorted arrays after split calls return
			merge(data, low, middle1, middle2, high);
		}
	}
	
	// merge two sorted arrays into one sorted array
	private static void merge(int[] data, int left, int middle1, int middle2, int right) {
		int leftIndex = left;	// first index into left subarray
		int rightIndex = middle2; // first index into right subarray
		int combinedIndex = left; // index into temporary working array
		int[] combined = new int[data.length]; // working array
		
		// output two subarray before merging
//	      System.out.printf("merge:   %s%n", 
//	         subarrayString(data, left, middle1));
//	      System.out.printf("         %s%n", 
//	         subarrayString(data, middle2, right));
		
		// merge arrays until reaching end of either
		while (leftIndex <= middle1 && rightIndex <= right) {
			// place smaller of two current elements into result
			// and move to next space in the array
			if (data[leftIndex] <= data[rightIndex])
				combined[combinedIndex++] = data[leftIndex++];
			else
				combined[combinedIndex++] = data[rightIndex++];
		} // while end
		
		// if left array is empty
		if (leftIndex == middle2) {
			// copy rest of the right array
			while (rightIndex <= right)
				combined[combinedIndex++] = data[rightIndex++];
		}
		else {  // right array is empty
			// copy in rest of left array
			while (leftIndex <= middle1) 
				combined[combinedIndex++] = data[leftIndex++];
		}
		
		// copy values back into original array
		for (int i = left; i <= right; i++) 
			data[i] = combined[i];
		
      // output merged array
	//      System.out.printf("         %s%n%n", 
	//         subarrayString(data, left, right));
	}
	
	
	// method to output certain values in array
	private static String subarrayString(int[] data, int low, int high) {
		StringBuilder temporary = new StringBuilder();
		
		// output spaces for alignment 
		for (int i = 0; i < low; i++) 
			temporary.append("   ");
		
		// output elements left in array
		for (int i = low; i <= high; i++)
			temporary.append(" " + data[i]);
		
		return temporary.toString();
	}
}
