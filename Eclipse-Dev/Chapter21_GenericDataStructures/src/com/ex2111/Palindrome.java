package com.ex2111;

public class Palindrome {

	public static void main(String[] args) {
		String str = "Lay a wallaby baby ball away, Al";
		
		StackComposition<Character> stack = new StackComposition<Character>();
		for (Character c : str.toCharArray()) {
			stack.push(c);
		}
	
	}
	
	private static boolean isInRange(int num, int lowerRange, int higherRange) {
		if (lowerRange > higherRange)
			return false;
		else if (higherRange < lowerRange)
			return false;
		else 
			return true;
	}

}
