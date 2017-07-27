package com.fig184;

import java.math.BigInteger;

public class Fibonacci {

	public static void main(String[] args) {
/*		for (int i = 0; i < 21; i++) {
			System.out.println("Factorial of " + i + "is: " + factorial(i));
		}*/

		
		for (int i = 0; i < 50; i++) {
			System.out.println(factorial(BigInteger.valueOf(i)));
		}
	}
	
	public static BigInteger factorial(BigInteger number) {
		if (number.compareTo(BigInteger.ONE) <= 0) {
			return BigInteger.ONE;
		}
		else {
			return number.multiply(factorial(number.subtract(BigInteger.ONE)));
		}
	}
	
	public static long factorial(long number) {
		if (number <= 1)
			return 1;
		else
			return number * factorial(number - 1);
	}

}
