package com.ex154;

import java.io.IOException;
import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.lang.Object;


public class AppendData {
	


	private static ArrayList<Account> accounts = new ArrayList<Account>();
	private static ObjectInputStream inputStream;
	
	private static void openFile() throws IOException {

		inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(
                        "/home/superlamer/GitHub/Java_Fundamentals/Eclipse-Dev/Chap15_Files/oldmast.txt")));

	}
	
	private static void appendFile() throws ClassNotFoundException, IOException {
		
		System.out.printf("%s%n%s%n?", "Enter account number, first name, last name and balance,",
				"Enter end of file indicator to end input.");
		
		// Ask the user to enter new accounts information
		// while user keeps entering info he will be prompted.
		// EOF key should be pressed to exit out of this loop
		// each account is added to the accounts array
//		while (in.hasNext()) {
//			Account acct = new Account(in.nextInt(), in.next(), in.next(), in.nextDouble());
//			accounts.add(acct);
//			
//			System.out.printf("%s%n%s%n?", "Enter account number, first name, last name and balance,",
//					"Enter end of file indicator to end input.");
//		}
		
		// reading the oldmast.txt file line by line and outputing
		// each account object to accounts array
		// when EOF exception is encounterd will exit the loop

		while (true) {
			Account record = (Account) inputStream.readObject();
			accounts.add(record);
		}
		
//		// zero out the file before rewriting all the records
//		try {
//			rndFile.setLength(0);
//		} catch (FileNotFoundException e) {
//			System.err.println("File does not exist");
//		} catch (IOException e) {
//			System.err.println("Cannot zero out file: " + file);
//		}
		
		
		// when all records have been entered and all objects have been
		// read from the file. we are ready to rewrite the file again.
//		for (Account a : accounts) {
//			try {
//				output.writeObject(a);
//			} catch (IOException e) {
//				System.err.println("Cannot write output to file: " + file);
//			}
//		}


	}
	
	
	
	private static void closeFile() {
		try {
			inputStream.close();
		} catch (IOException ioException) {
			System.err.println("Error closing file.\n" + ioException.getMessage());
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		openFile();
		appendFile();
		closeFile();
	}

}





















