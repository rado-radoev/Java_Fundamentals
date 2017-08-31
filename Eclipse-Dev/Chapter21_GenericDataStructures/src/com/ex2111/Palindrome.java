package com.ex2111;

public class Palindrome {

	public static void main(String[] args) {
		String str = "hellothisispalindoremmerodnilapsisihtolleh";
		
		StackComposition<Character> stack = new StackComposition<Character>();
		for (Character c : str.toCharArray()) {
			if (isInRange((int)c, 48, 57) ||
				isInRange((int)c, 65, 90) ||
				isInRange((int)c, 97, 122))
			stack.push(c);
		}
		
		boolean isPalindrome = false;
		for (int i = 0; i < str.length(); i++) {
			if (!stack.isEmpty()) {
				if (isInRange((int)str.charAt(i), 48, 57) ||
					isInRange((int)str.charAt(i), 65, 90) ||
					isInRange((int)str.charAt(i), 97, 122)) {
					
					char current = stack.pop();
					if (str.charAt(i) == current) {
						isPalindrome = true;
					}
					else {
						isPalindrome = false;
					}
				}
			}
		}
		
		if (isPalindrome) 
			System.out.println("Is palindrome");
		else
			System.out.println("Is not palindrome");
	}
	
	private static boolean isInRange(int num, int lowerRange, int higherRange) {
		if (num >= lowerRange && num <= higherRange)
			return true;
		else
			return false;
	}

}
