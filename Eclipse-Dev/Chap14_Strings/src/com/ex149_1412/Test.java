package com.ex149_1412;

public class Test {

	public static void main(String[] args) {
		int[] chars = new int[128];
		String text = "this is a test";
		char c = 't';
		
		int start = text.indexOf(c, 0);
		while (start > -1) {
			chars[c]++;
			start = text.indexOf(c, start + 1);
		}
 		
		System.out.println(String.format("Character %s, found: %d times", Character.valueOf(c), chars[c]));

	}

}
