package com.ex206;

public class GenericMethodOverload {

	public static void main(String[] args) {
		String[] strArr = {"one", "two", "three", "four", "five", "six", "seven", "eight"};
		Integer[] integerArray = {1, 2, 3, 4, 5, 6};
		
		printArray(strArr);
		System.out.println();
		printArray(integerArray);
	}
	
	public static void printArray(String[] stringArray) {
		System.out.println("Array stringArray contains:");
		for (int i = 0; i < stringArray.length; i++) {
			System.out.printf("%s   ", stringArray[i]);
			if (i == (stringArray.length / 2)- 1)
				System.out.println();
		}
	}
	
	public static <T> void printArray(T[] inputArray) {
		for (T element : inputArray) 
			System.out.printf("%s ", element);
		
		System.out.println();
	}
}
