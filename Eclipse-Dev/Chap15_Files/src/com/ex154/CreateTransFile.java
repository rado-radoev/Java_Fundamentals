package com.ex154;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTransFile {

	private static ObjectOutputStream output;
	
	private static void openFile() {
		try {
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get("trans.txt")));
		}
		catch (IOException ioException) {
			System.out.printf("%s", ioException.getMessage());
		}
	} // END openFile
	
	
	private static void addRecords() {
		TransactionRecord tr = new TransactionRecord();
		Scanner input = new Scanner(System.in);
			
		System.out.printf("%s%n", "Enter account number: ");
		tr.setAccountNumber(input.nextInt());
		
		System.out.printf("%s%n", "Enter transaction amount: ");
		tr.setTransactionAmount(input.nextDouble());
		
		try {
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
