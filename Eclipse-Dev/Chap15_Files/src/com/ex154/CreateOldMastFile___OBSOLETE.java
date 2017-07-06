package com.ex154;

/*
 * 
 * 
 * 
 * THIS CLASS IS NOT BEING USED
 * FILES ARE BEING CREATED FROM THE 
 * CREATEFILE CLASS
 * 
 * 
 * 
 * 
 * 
 * */







import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateOldMastFile___OBSOLETE {

	private static ObjectOutputStream output;
	
	public static void main(String[] args) {
		openFile();
		addRecords();
		closeFile();
	}
	
	
	private static void openFile() {
		try {
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get("oldmast.txt")));
		}
		catch (IOException ioException) {
			System.out.println("Error opening file.");
		}
	}
	
	private static void addRecords() {
		Scanner input = new Scanner(System.in);
		
		System.out.printf("%s%n%s%n?", "Enter account number, first name, last name and balance,",
				"Enter end of file indicator to end input.");
		
		while (input.hasNext()) {
			try {
				System.out.printf("%s%n%s%n?", "Enter account number, first name, last name and balance,",
						"Enter end of file indicator to end input.");
				// Create account object. Assuming correct input.
				Account record = new Account(input.nextInt(), input.next(), input.next(), input.nextDouble());
				
				// serialize account object into a file
				output.writeObject(record);
			}
			catch (NoSuchElementException noSuchElement) {
				System.out.println("Invalid input. Try again.");
			}
			catch (IOException ioException) {
				System.out.println("Error writing to file.");
			}
		}

	}
	
	private static void closeFile() {
		try {
			if (output != null) {
				output.close();
			}
		} 
		catch (IOException ioException) {
			System.out.println("Error closing file.");
		}
	}
}
