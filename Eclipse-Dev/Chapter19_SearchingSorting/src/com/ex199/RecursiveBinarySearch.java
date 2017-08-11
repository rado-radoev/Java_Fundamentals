package com.ex199;

import java.security.SecureRandom;
import java.util.Arrays;


public class RecursiveBinarySearch {
	
	public static int binarySearchRecursive(int[] data, int start, int end, int searchKey) {
		if (start > end) 
			return -1;
		
		int middle = (start + end + 1) / 2;
		
		if (searchKey == data[middle])
			return middle;
		else if (searchKey < data[middle])
			end = middle - 1;
		else
			start = middle + 1;
		
		return binarySearchRecursive(data, start, end, searchKey);
		
		
	}
	
	 // perform a binary search on the data      
	   public static int binarySearch(int[] data, int key)
	   {
	      int low = 0; // low end of the search area                
	      int high = data.length - 1; // high end of the search area
	      int middle = (low + high + 1) / 2; // middle element      
	      int location = -1; // return value; -1 if not found 
	
	      do // loop to search for element
	      {
	         // print remaining elements of array
	         System.out.print(remainingElements(data, low, high));
	
	         // output spaces for alignment
	         for (int i = 0; i < middle; i++)
	            System.out.print("   ");
	         System.out.println(" * "); // indicate current middle
	
	         // if the element is found at the middle                  
	         if (key == data[middle])                                  
	            location = middle; // location is the current middle   
	         else if (key < data[middle]) // middle element is too high
	            high = middle - 1; // eliminate the higher half        
	         else  // middle element is too low                        
	            low = middle + 1; // eliminate the lower half          
	
	         middle = (low + high + 1) / 2; // recalculate the middle
	      } while ((low <= high) && (location == -1));               
	
	      return location; // return location of search key
	   } // end method binarySearch                        
	
	   // method to output certain values in array
	   private static String remainingElements(int[] data, int low, int high)
	   {
	      StringBuilder temporary = new StringBuilder();
	
	      // append spaces for alignment
	      for (int i = 0; i < low; i++)
	         temporary.append("   ");
	
	      // append elements left in array 
	      for (int i = low; i <= high; i++)
	         temporary.append(data[i] + " ");
	
	      return String.format("%s%n", temporary);
	   } // end method remainingElements
	
	   public static void main(String[] args)
	   {
	      SecureRandom generator = new SecureRandom();
	
	      int[] data = new int[15]; // create array
	
	      for (int i = 0; i < data.length; i++) // populate array
	         data[i] = 10 + generator.nextInt(10);
	
	      Arrays.sort(data); // binarySearch requires sorted array
	      System.out.printf("%s%n%n", Arrays.toString(data)); // display array
	      System.err.println("Number is found at index: " + binarySearchRecursive(data, 0, data.length - 1, 10));
	
      } 
} 






