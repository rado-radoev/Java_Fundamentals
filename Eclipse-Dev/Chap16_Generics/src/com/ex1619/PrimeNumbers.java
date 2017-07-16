package com.ex1619;

// prime numbers and prime factors

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

public class PrimeNumbers {
	
	private static HashMap<Integer, Boolean> primes =
			calculatePrimes();
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number:");
		int in = input.nextInt();
		
		if (primes.containsKey(in)) {
			if (primes.get(in)) {
				System.out.println("Number is prime");
			}
			else {
				System.out.println("Number is not prime");
				for (int i = 0; i < in;i++) {
					if (primes.get(i)) {
						System.out.println(i);
					}
				}
			}
		}
		
	}
	
	
	private static HashMap<Integer, Boolean> calculatePrimes() {
		HashMap<Integer, Boolean> primes = 
				new HashMap<Integer, Boolean>();
		
		// assume all integers are prime
		// 0 and 1 are not prime
		primes.put(0, false);
		primes.put(1, false);
		for (int i = 2; i <= 10000;i++) {
			primes.put(i, true);
		}
		
		for (int i = 2;i < primes.size();i++) {
			// if the number is primes, go through all its multiples
			// and make the value false
			if (primes.get(i)) {
				for (int j = 2; i*j < primes.size();j++) {
					primes.put(i*j, false);
				}
			}
		}
		
		return primes;
	}

}
