package com.ex1817;

public class PrintArrayBackwards {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		String result = printArrayBackwards(arr, 0);
		
		System.out.println(result);
	}
	
	public static String printArrayBackwards(int[] array, int index) {
		if (index >= array.length) 
			return "";
		
		return String.format("%s%d", printArrayBackwards(array, index + 1), array[index]);
	}

}
