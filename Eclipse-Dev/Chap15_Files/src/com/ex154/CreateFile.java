package com.ex154;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateFile {

	private static ObjectOutputStream output;
	private static String file;
	
	public static void main(String[] args) {
		file = args[0];
		openFile();
		addRecords();
		closeFile();
	}
	
	private static void openFile() {
		try {
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get(file)));
		}
		catch (IOException ioException) {
			System.out.printf("%s", ioException.getMessage());
		}
	} // END openFile
	
	private static void addRecords() {
		if (file.equalsIgnoreCase("oldmast.txt")) {
			addAccountRecords();
		}
		else if (file.equalsIgnoreCase("trans.txt")) {
			addTransactionRecords();
		}
	}
	
	private static void addAccountRecords() {
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
	
	private static void addTransactionRecords() {
		
		Scanner input = new Scanner(System.in);
		System.out.printf("%s %s%n", "Enter account number", "Enter transaction amount");
		
		while (input.hasNext()) {
			try {
				
				TransactionRecord tr = new TransactionRecord(input.nextInt(), input.nextDouble());
					
				// serialize transaction record into a file
				output.writeObject(tr);
			}
			catch (IOException ioException) {
				System.out.printf("%s", "Error writing to a file");
			}
			catch (NoSuchElementException noSuchElement) {
				System.out.printf("%s", "Invalid input.");
			}
		}
	}
	
	private static void closeFile()	{
		try {
			if(output != null) {
				output.close();
			}
		}
		catch (IOException ioException) {
			System.out.printf("%s", "Cannot close file");
		}
	}
}
