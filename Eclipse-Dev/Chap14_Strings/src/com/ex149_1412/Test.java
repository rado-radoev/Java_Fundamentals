package com.ex149_1412;

public class Test {

	public static void main(String[] args) {
		int[] chars = new int[128];
		boolean[] found = new boolean[128];
		
		String text = "this is a test";
		
		for (int i = 0; i < text.length(); i++) {
			int start = text.indexOf(text.charAt(i), 0);
			while (start > -1) {
				if (found[text.charAt(i)] != true) {
					chars[text.charAt(i)]++;	
				}
				
				start = text.indexOf(text.charAt(i), start + 1);
			}
			found[text.charAt(i)] = true;
		}
		
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] > 0) {
				System.out.println("character " + (char)i + " is found: " + chars[i] + " times");
			}
		}
		

 		
		//System.out.println(String.format("Character %s, found: %d times", Character.valueOf(c), chars[c]));

	}

}
