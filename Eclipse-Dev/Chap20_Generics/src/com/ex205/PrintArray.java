package com.ex205;

public class PrintArray {

	public static void main(String[] args) throws InvalidSubscriptException {
		Integer[] integerArray = {1, 2, 3, 4, 5, 6};
	    Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
	    Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};
	    
	    System.err.println(printArray(integerArray, 5, 5));
	    System.err.println(printArray(doubleArray, 3, 5));
	    printArray(characterArray, 0, 3);
	}
	
	public static <T> void printArray(T[] inputArray, int lowSubscript, int highSubscript) throws InvalidSubscriptException {
		if ((lowSubscript < 0 || lowSubscript >= inputArray.length) ||
			(highSubscript < 0 || highSubscript >= inputArray.length)) {
			throw new InvalidSubscriptException();
		}
		
		for (int i = lowSubscript ; i <= highSubscript; i++) {
			System.out.printf("%s ", inputArray[i]);
		}
		
		System.out.println();
	}


	public static <T extends Number>int printArray(T[] inputArray, int lowSubscript, int highSubscript) throws InvalidSubscriptException {
		if ((lowSubscript < 0 || lowSubscript >= inputArray.length) ||
				(highSubscript < 0 || highSubscript >= inputArray.length)) {
				throw new InvalidSubscriptException();
		}
		
		return (highSubscript - lowSubscript) == 0 ? 1 : (highSubscript - lowSubscript);
	}
}
