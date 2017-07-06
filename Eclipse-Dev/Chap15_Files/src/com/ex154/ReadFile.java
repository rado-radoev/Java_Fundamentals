package com.ex154;

import java.io.IOException;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile {

	private static ObjectInputStream input;
	private static String file;
	
	public static void main(String[] args) {
		try {
			file = args[0];
		} 
		catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
			System.err.println("Argument (file name or path) must be passed to main method.");
		}
		openFile();
		readRecords();
		closeFile();
	}

	
	private static void openFile() {
		try {
			input = new ObjectInputStream(Files.newInputStream(Paths.get(file)));
		}
		catch (IOException ioException) {
			System.err.print("Error opening file");
		}
	}
	
	private static void readRecords() {
		System.out.printf("%-10s%-12s%-12s%10s%n", "Account", "First Name", "Last Name", "Blanace");
		try {
			while (true) {
				if (file.equalsIgnoreCase("oldmast.txt") || file.equalsIgnoreCase("newmast.txt")) {
					Account record = (Account) input.readObject();
					
					System.out.printf("%-10s%-12s%-12s%10s%n", record.getAccount(), record.getFirstName(), 
							record.getLastName(), record.getBalance());	
				}
				else if (file.equalsIgnoreCase("trans.txt")) {
					TransactionRecord record = (TransactionRecord) input.readObject();
					
					System.out.printf("%-10s%-12s%n", record.getAccountNumber(), record.getTransactionAmount());
				}

			}
		} catch (EOFException endOfFileException) {
			System.out.printf("%s%n", "No more records");
		}
		catch (ClassNotFoundException classNotFoundException) {
			System.out.printf("%s%n", "Invalid object type");
		} catch (IOException ioException) {
			System.out.printf("%s%n", "Error reading from file");
		}
	}
	
	
	private static void closeFile() {
		try {
			if (input != null) {
				input.close();
			}
		} catch (IOException ioException) {
			System.err.println("Error closing file");
		}
	}
}




