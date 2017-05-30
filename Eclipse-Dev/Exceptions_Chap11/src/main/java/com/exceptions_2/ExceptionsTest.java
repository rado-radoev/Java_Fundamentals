// ex 11.17
package com.exceptions_2;

import java.io.IOException;
import java.util.Scanner;

public class ExceptionsTest {

	public static void main(String[] args) {
		
		try {
			
			System.out.printf("Choose 1 for: %s%nChoose 2 for: %s%nChoose 3 for: %s%nChoose 4 for: %s%n", 
					"ExceptionA",
					"ExceptionB",
					"Null Pointer Exception",
					"IO Exception");
			
			Scanner in = new Scanner(System.in);
			int choise = in.nextInt();
			in.nextLine();
			
			switch (choise) {
			case 1:
				throw new ExceptionA();
			case 2:
				throw new ExceptionB();
			case 3:
				throw new NullPointerException();
			case 4: 
				throw new IOException();
			default:
				break;
			}
			
		} catch (Exception e) {
			
			System.err.println(e);
		}
		
		
	}
}
