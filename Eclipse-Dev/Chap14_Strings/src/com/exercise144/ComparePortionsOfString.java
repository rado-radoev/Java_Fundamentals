package com.exercise144;

import java.util.Scanner;

public class ComparePortionsOfString {

	public static void main(String[] args) {
		System.out.println("Enter 2 stings to compare");
		System.out.println("String 1:");
		
		Scanner input = new Scanner(System.in);
		String str1 = input.nextLine();
		
		System.out.println("String 2:");
		String str2 = input.nextLine();
		
		System.out.println("Enter number of characters to be compared:");
		int charsToMatch= input.nextInt();

		System.out.println("Starting index to match:");
		int startIndex = input.nextInt();
		
		
		System.out.print(str1.regionMatches(true ,startIndex, str2, startIndex, charsToMatch) ? "Match found" : "No match found");
		
	}

}
