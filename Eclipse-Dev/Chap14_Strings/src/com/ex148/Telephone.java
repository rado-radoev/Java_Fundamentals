package com.ex148;

import java.util.StringTokenizer;
import java.util.Scanner;

public class Telephone {

	public static void main(String[] args) {
		System.out.println("Enter phone number in format (xxx) xxx-xxxx"); 
		Scanner input = new Scanner(System.in);
		
		//String input = "(555) 555-5555";
		String phone = input.nextLine();
		
		String[] brokenPhone = new String[3];
		
		brokenPhone = phone.split("\\s|-");
		brokenPhone[0] = brokenPhone[0].substring(1, brokenPhone[0].length() - 1);
		String fullPhone = brokenPhone[0].concat(brokenPhone[1].concat(brokenPhone[2]));
		
		System.out.println("The area code is: " + brokenPhone[0] + "\n" +
				"Concatenated number is: " + fullPhone);
	}

}
