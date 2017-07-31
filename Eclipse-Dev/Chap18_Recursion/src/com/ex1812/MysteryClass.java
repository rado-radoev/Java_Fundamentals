package com.ex1812;

public class MysteryClass {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		int result = mystery(array, array.length);
		
		System.out.println(array[array.length - 1]);
		//System.out.printf("Result is: %d%n", result);
	}
	
	public static int mystery(int[] array2, int size) {
		if (size == 1) 
			return array2[0];
		else
			return array2[size -1] + mystery(array2, size -1);
	}

}
