package com.fig185;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Fibonacci {

	private static BigInteger TWO = BigInteger.valueOf(2);
	
	public static void main(String[] args) {
		IntStream intStream = IntStream.rangeClosed(0, 20);
		intStream.parallel().forEach(i -> System.out.println(fibonacci(BigInteger.valueOf(i))));

	}

	private static BigInteger fibonacci(BigInteger number) {
		if (number.equals(BigInteger.ZERO) ||
			number.equals(BigInteger.ONE)) {
			return number;	// base cases
		}
		else {
			return fibonacci(number.subtract(BigInteger.ONE)).add(fibonacci(number.subtract(TWO)));
		}
  	}
}
