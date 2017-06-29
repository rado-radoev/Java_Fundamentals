package com.exercice143;

import java.util.Scanner;

public class CompareStrings {

	public static void main(String[] args) {
			System.out.println("Enter 2 stings to compare");
			System.out.println("String 1:");
			
			Scanner input = new Scanner(System.in);
			String str1 = input.nextLine();
			
			System.out.println("String 2:");
			String str2 = input.nextLine();
			
			int output = str1.compareTo(str2);
			if (output == 0) {
				System.out.println("Strings are equal");
			} 
			else if (output > 0) {
				System.out.println("Stirng 1 is larger than string 2");
			}
			else {
				System.out.println("String 1 is less than string 2");
			}
			
	}

}
