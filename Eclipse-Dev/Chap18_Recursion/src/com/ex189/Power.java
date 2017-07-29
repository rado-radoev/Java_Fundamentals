package com.ex189;

public class Power {

	public static void main(String[] args) {
		System.out.println(power(3, 4));

	}

	public static int power(int base, int exponent) {
		
		if (exponent == 1) 
			return base;
		
		return base * power(base, exponent - 1);
	}
}
