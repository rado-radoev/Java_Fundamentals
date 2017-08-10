package com.ex198;

import java.security.SecureRandom;
import java.util.Arrays;

public class LinearSortRecursion {

	public static void main(String[] args) {
		SecureRandom generator = new SecureRandom();

	      int[] data = new int[10]; // create array

	      for (int i = 0; i < data.length; i++) // populate array
	         data[i] = 10 + generator.nextInt(10);
		
	      System.out.println(Arrays.toString(data));
	      System.out.println(recursiveLinearSearch(data, 10, 0));
	}
	
	public static int recursiveLinearSearch(int[] data, int searchKey, int startIndex) {
		if (startIndex >= data.length) 
			return -1;
		
		if (data[startIndex] == searchKey)
			return startIndex;
		
		return recursiveLinearSearch(data, searchKey, startIndex + 1);
	}
  

}
