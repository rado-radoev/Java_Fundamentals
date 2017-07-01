package com.ex149_1412;

public class Test {

	public static void main(String[] args) {
		int[] chars = new int[128];
		boolean[] found = new boolean[128];
		
		String text = "this is a test";
		
		for (int i = 0; i < text.length(); i++) {	// loop through each letter
			if (!found[text.charAt(i)]) {	// if letter is already added found, skip it
				int start = text.indexOf(text.charAt(i), 0);	// get the index of the first occurance of the letter
				while (start > -1) {	// loop until there are no more occurances of the letter
					chars[text.charAt(i)]++;	// when the letter is encountered, increment the array index, corresponding to that letter		
					start = text.indexOf(text.charAt(i), start + 1);	// search for the next occurance or exit loop
				}
			}
			found[text.charAt(i)] = true;	// set the array that the letter has already been found, so next time it can be skipped, otherwise
			//	multiple occurances of the same letter will appear in the output
		}
		
		// loop thorught the array by skypping everything but letters
		// output the letter and how many times it was found
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] > 0 && // check if the current index is not 0
					((i >= 65 && i <= 90) ||	// and check if the index is in the ASCII letter range
					(i >=97 && i <= 122))) {	// 65-90 for uppercase 97-122 for lower case
								
				System.out.println(String.format("Chacacter %s, found: %d times.", (char)i, chars[i]));
			}
		}
		

 		
		//System.out.println(String.format("Character %s, found: %d times", Character.valueOf(c), chars[c]));

	}

}
