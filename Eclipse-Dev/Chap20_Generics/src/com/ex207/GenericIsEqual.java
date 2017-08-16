package com.ex207;

public class GenericIsEqual {

	public static void main(String[] args) {

		String arg1 = "hello";
		String arg2 = "Hello";
		System.out.println(isEqualTo(arg1, arg2));
	}

	public static <T extends Comparable<T>> boolean isEqualTo (T arg1, T arg2) {
		if (arg1.compareTo(arg2) == 0)
			return true;
		else 
			return false;
		
		
	}
}
