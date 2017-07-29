package com.ex187;

public class RecursionTest {

	public static void main(String[] args) {
		System.out.println(mystery(1, 3));

	}
	
	public static int sum(int n) {
		if (n == 0)
			return 0;
		else
			return n + sum(n);
	}
	
	public static int mystery(int a, int b) {
		if (b == 1) 
			return a;
		else
			return a + mystery(a, b - 1);
	}

}
