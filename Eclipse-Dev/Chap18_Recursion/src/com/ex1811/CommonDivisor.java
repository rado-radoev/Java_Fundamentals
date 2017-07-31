package com.ex1811;

public class CommonDivisor {

	public static void main(String[] args) {
		System.out.print(gcd(30,50));

	}

	public static long gcd(long a, long b) {
		if (b == 0)
			return a;
		
		return gcd(b, a % b);
	}
}
