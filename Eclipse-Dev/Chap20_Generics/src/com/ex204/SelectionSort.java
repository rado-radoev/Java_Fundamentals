package com.ex204;

import java.util.Arrays;
import java.security.SecureRandom;

public class SelectionSort {

	public static void main(String[] args) {
		SecureRandom generator = new SecureRandom();

	      Integer[] data = new Integer[10]; // create array

	      for (int i = 0; i < data.length; i++) // populate array
	         data[i] = generator.nextInt(90);

	      System.out.printf("Unsorted array:%n%s%n%n", 
	         Arrays.toString(data)); // display array
	      selectionSort(data); // sort array

	      System.out.printf("Sorted array:%n%s%n%n", 
	         Arrays.toString(data)); // display array

	}
	
	public static <T extends Comparable<T>> void selectionSort(T[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			int smallest = i;
			
			for (int index = i + 1; index < data.length; index++) {
				if (data[index].compareTo(data[smallest]) < 0) {
					smallest = index;
				}
			}
			
			swap(data, i, smallest);
		}
	}
	
	
	private static <T> void swap (T[] data, int first, int second) {
		T temp = data[first];
		data[first] = data[second];
		data[second] = temp;
	}
	
	private static <T> void printPass(T[] data, int pass, int index) {
		System.out.printf("after pass %2d: ", pass);  
		
		// output elements till selected item
	      for (int i = 0; i < index; i++)
	         System.out.printf("%d  ", data[i]);

	      System.out.printf("%d* ", data[index]); // indicate swap

	      // finish outputting array
	      for (int i = index + 1; i < data.length; i++)
	         System.out.printf("%d  ", data[i]);

	      System.out.printf("%n               "); // for alignment

	      // indicate amount of array that’s sorted
	      for (int j = 0; j < pass; j++)
	         System.out.print("--  ");
	      System.out.println(); 
	}

}
