package com.ex1823;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class EnhancedFib {

	private static BigInteger TWO = BigInteger.valueOf(2);
	private static long calls = 0;
	
	public static void main(String[] args) {
		IntStream intStream = IntStream.rangeClosed(0, 20);
		intStream.parallel().forEach(i -> {
			long start = System.currentTimeMillis();
			System.out.println("Fibonacci of: " + i + " is: " +  fibonacci(BigInteger.valueOf(i)));
			long end = System.currentTimeMillis();
			System.out.println("Milliseconds that it took to call fibonacci: " + (end - start));
			System.out.println("Total number of calls: " + calls);
		});

	}

	private static BigInteger fibonacci(BigInteger number) {
		calls++;
		if (number.equals(BigInteger.ZERO) ||
			number.equals(BigInteger.ONE)) {
			return number;	// base cases
		}
		else {
			return fibonacci(number.subtract(BigInteger.ONE)).add(fibonacci(number.subtract(TWO)));
		}
  	}
}
