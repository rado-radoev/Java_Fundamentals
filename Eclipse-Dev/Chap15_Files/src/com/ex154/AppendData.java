package com.ex154;

import java.io.IOException;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.RandomAccessFile;
import java.io.FileNotFoundException;


public class AppendData {
	
	private static Scanner in;

	private static ObjectOutputStream output;
	private static ArrayList<Account> accounts = new ArrayList<Account>();
	private static ArrayList<TransactionRecord> transactionRecords = new ArrayList<TransactionRecord>();
	private static ObjectInputStream inputStream;
	private static RandomAccessFile rndFile;
	
	private static String file;
	
	private static void openFile() {
		
		try {
			inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(file)));
		} catch (IOException e) {
			System.out.println("Cannot open " + file + " for reading.");
		}

	}
	
	private static void appendFile() {
		if (file.equalsIgnoreCase("oldmast.txt")) {
			appendAccounts();
		}
		else if (file.equalsIgnoreCase("trans.txt")) {
			appendTransactions();
		}
	}
	
	private static void appendTransactions() {
		System.out.printf("%s%n%s%n?", "Enter account number and transaction amount.",
				"Enter end of file indicator to end input.");
		
		in = new Scanner(System.in);
		
		// Ask the user to enter new transaction information
		// while user keeps entering info he will be prompted.
		// EOF key should be pressed to exit out of this loop
		// each account is added to the accounts array
		while (in.hasNext()) {
			TransactionRecord transRec = new TransactionRecord(in.nextInt(), in.nextDouble());
			transactionRecords.add(transRec);
			
			System.out.printf("%s%n%s%n?", "Enter account number and transaction amount.",
					"Enter end of file indicator to end input.");
		}
		
		// reading the trans.txt file line by line and outputing
		// each transaction object to transactionRecords array
		// when EOF exception is encounterd will exit the loop

		try {
			while (true) {
				TransactionRecord record = (TransactionRecord) inputStream.readObject();
				transactionRecords.add(record);
			}
		} catch (EOFException eof) {
			System.out.println("End of file reached");
		} catch (IOException ioException) {
			System.out.println("Error reading input stream from file");
		} catch (ClassNotFoundException e) {
			System.out.println("Wrong object inside the file");
		}

		
		// zero out the file before rewriting all the records
		try {
			rndFile = new RandomAccessFile(file, "rw");
			rndFile.setLength(0);
		} catch (FileNotFoundException e) {
			System.err.println("File does not exist");
		} catch (IOException e) {
			System.err.println("Cannot zero out file: " + file);
		}
		
		
		// when all records have been entered and all objects have been
		// read from the file. we are ready to rewrite the file again.
		try {
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get(file)));
		} catch (IOException e1) {
			System.out.println("Cannot open " + file + " output stream");
		}
		
		for (TransactionRecord tr : transactionRecords) {
			try {
				output.writeObject(tr);
			} catch (IOException e) {
				System.err.println("Cannot write output to file: " + file);
			}
		}
	}
	
	private static void appendAccounts() {
		System.out.printf("%s%n%s%n?", "Enter account number, first name, last name and balance,",
				"Enter end of file indicator to end input.");
		
		in = new Scanner(System.in);
		
		// Ask the user to enter new accounts information
		// while user keeps entering info he will be prompted.
		// EOF key should be pressed to exit out of this loop
		// each account is added to the accounts array
		while (in.hasNext()) {
			Account acct = new Account(in.nextInt(), in.next(), in.next(), in.nextDouble());
			accounts.add(acct);
			
			System.out.printf("%s%n%s%n?", "Enter account number, first name, last name and balance,",
					"Enter end of file indicator to end input.");
		}
		
		// reading the oldmast.txt file line by line and outputing
		// each account object to accounts array
		// when EOF exception is encounterd will exit the loop

		try {
			while (true) {
				Account record = (Account) inputStream.readObject();
				accounts.add(record);
			}
		} catch (EOFException eof) {
			System.out.println("End of file reached");
		} catch (IOException ioException) {
			System.out.println("Error reading input stream from file");
		} catch (ClassNotFoundException e) {
			System.out.println("Wrong object inside the file");
		}

		
		// zero out the file before rewriting all the records
		try {
			rndFile = new RandomAccessFile(file, "rw");
			rndFile.setLength(0);
		} catch (FileNotFoundException e) {
			System.err.println("File does not exist");
		} catch (IOException e) {
			System.err.println("Cannot zero out file: " + file);
		}
		
		
		// when all records have been entered and all objects have been
		// read from the file. we are ready to rewrite the file again.
		try {
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get(file)));
		} catch (IOException e1) {
			System.out.println("Cannot open " + file + " output stream");
		}
		
		for (Account a : accounts) {
			try {
				output.writeObject(a);
			} catch (IOException e) {
				System.err.println("Cannot write output to file: " + file);
			}
		}
	}
	
	private static void closeFile() {
		try {
			inputStream.close();
			output.close();
			rndFile.close();
			in.close();
		} catch (IOException ioException) {
			System.err.println("Error closing file.\n" + ioException.getMessage());
		}
	}

	public static void main(String[] args) {
		file = args[0];
		openFile();
		appendFile();
		closeFile();
	}

}





















