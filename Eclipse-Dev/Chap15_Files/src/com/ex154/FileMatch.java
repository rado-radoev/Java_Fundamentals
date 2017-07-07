package com.ex154;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.HashSet;

public class FileMatch {
	
	private static ObjectInputStream oldmastInput;
	private static ObjectInputStream transInput;
	private static ObjectOutputStream newmastOutput;
	
	private static Formatter log;
	
	private static ArrayList<Account> accounts = new ArrayList<Account>();
	private static ArrayList<TransactionRecord> transactionRecords = new ArrayList<TransactionRecord>();
	
	public static void main(String[] args) {
		openFile();
		
		checkDupliateTransactions();
//		addTransactionRecords();
//		addAccountRecords();
//		
//		matchTransactionsToAccounts();
//		checkMissingAccountRecords();
//		
//		checkWrongTransactionRecord();
		
		closeFile();
	}
	
	private static void checkDupliateTransactions() {
		// Create temporary array to hold duplicate transactions
		ArrayList<TransactionRecord> allTransactionRecords = new ArrayList<TransactionRecord>();
		ArrayList<TransactionRecord> duplicateTransactionRecords = new ArrayList<TransactionRecord>();
		ArrayList<TransactionRecord> uniqueTransactionRecords = new ArrayList<TransactionRecord>();
		HashSet<Integer> found = new HashSet<Integer>();
		
		// read all transactions from the transaction file
		try {
			while (true) {
				TransactionRecord transactionRecrod = (TransactionRecord) transInput.readObject();
				allTransactionRecords.add(transactionRecrod);
			}
		} catch (EOFException eof) {
			System.err.printf("%nNo more records%n");
		}
		catch (ClassNotFoundException cnf) {
			System.err.printf("%nInvalid object type%n");
		}
		catch (IOException ioe) {
			System.err.printf("%nError opening file.%n");
		}
		

		
		for (int i = 0; i < allTransactionRecords.size();i++) {	// loop through all records
			//boolean duplicate = false;	// set sentinel variable if match is found or not
			double balance = allTransactionRecords.get(i).getTransactionAmount();	// get the initial transaction amount
			
			for (int j = i + 1; j < allTransactionRecords.size();j++) {	// try to match the each record to the rest
				if (allTransactionRecords.get(i).getAccountNumber() == allTransactionRecords.get(j).getAccountNumber()) {	// if a duplicate record is found
					balance += allTransactionRecords.get(j).getTransactionAmount();	// add the additional amount to the base
					//duplicate = true;	// set the control variable to true(match found)
					found.add(allTransactionRecords.get(i).getAccountNumber());
				}
			}
			
			//if (duplicate) { //if a match is found. add record to duplicate transactions array
				//allTransactionRecords.get(i).setTransactionAmount(balance); // update the transaction amount first
				//duplicateTransactionRecords.add(allTransactionRecords.get(i));	// add the record to the duplicate transactions array
			//} else {
				// check if the transaction doesn't already exist. that is more for the last item in the list.
				
				allTransactionRecords.get(i).setTransactionAmount(balance); // update the transaction amount first
				uniqueTransactionRecords.add(allTransactionRecords.get(i));		// if no duplicate record is found add to unique records
			//}
		}
		
		allTransactionRecords.clear(); // we don't need that array anymore. preping it to be garbage collected
		
		// now when we have two arays - one with duplicate records and one with unique records let's rewrite the file
		try {
			ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("trans.txt")));
			
			
			try {
				// read through all unique records and add them to the trans.txt file
				for (TransactionRecord tr : uniqueTransactionRecords) {
					oos.writeObject(tr);
				}
				
				// read through all duplicate records and add them to the trans.txt file
				for (TransactionRecord tr : duplicateTransactionRecords) {
					oos.writeObject(tr);
				}
			} catch (IOException ioException) {
				System.out.println("Cannot write to file");				
			}
			
		} catch (IOException e) {
			System.out.print("File trans.txt does not exist.");
		}
		
	}
	
	private static void openFile() {
		try {
			oldmastInput = new ObjectInputStream(Files.newInputStream(Paths.get("oldmast.txt")));
			transInput = new ObjectInputStream(Files.newInputStream(Paths.get("trans.txt")));
			newmastOutput = new ObjectOutputStream(Files.newOutputStream(Paths.get("newmast.txt")));
		}
		catch (IOException ioException) {
			System.err.println("Error accessing file.\n " + ioException.getCause());
		}
		
		try {
			log = new Formatter("log.txt");
		} 
		catch (SecurityException se) {
			System.err.println("No write permissions.");
		} 
		catch (FileNotFoundException fnfe) {
			System.err.println("Error opening file.");
		}
	}
	
	private static void matchTransactionsToAccounts() {
		for (int i = 0; i < transactionRecords.size(); i++) {
			for (int j = 0; j < accounts.size(); j++) {
				if (transactionRecords.get(i).getAccountNumber() ==		// Check if the account in transaction record exists in account records
						accounts.get(j).getAccount()) {					
					
					accounts.get(j).setBalance(transactionRecords.get(i).getTransactionAmount() +	// if the account exists add the transaction amount to the account balance
							accounts.get(j).getBalance());
					try {
						newmastOutput.writeObject(accounts.get(j));	// add the updated record to newmast.txt
					} catch (NoSuchElementException nsee) {
						System.err.printf("Invalid input.");
					}
					catch (IOException e) {
						System.err.printf("Error writing to file");
					}
				}
			}
		}
	}
	
	private static void checkWrongTransactionRecord() {
		boolean match;
		for (int i = 0; i < transactionRecords.size();i++) {
			match = false;
			for (int j = 0; j < accounts.size(); j++) {
				if (transactionRecords.get(i).getAccountNumber() == accounts.get(j).getAccount()) {
					match = true;
				}
			}
			
			try {
				if (!match) {
					log.format("%s %d%n", "Unmatched transaction record for account", transactionRecords.get(i).getAccountNumber());
				}	
			}
			catch (FormatterClosedException fce) {
				System.err.println("Error writing to file.");
			}

		}
	}
	
	private static void checkMissingAccountRecords() {
		boolean match;
		for (int i = 0; i < accounts.size();i++) {
			match = false;
			for (int j = 0; j < transactionRecords.size();j++) {
				if (accounts.get(i).getAccount() == transactionRecords.get(j).getAccountNumber()) {	// Check if account from master file exists in transaction records
					match = true;
				}
			}
			
			try {
				if (!match) {
					newmastOutput.writeObject(accounts.get(i));
				}
			} catch (IOException ioException) {
				System.err.println("Error adding record to file.");
			}
		}
	}
	
	private static void addTransactionRecords() {
		try {
			while (true) {
				TransactionRecord transactionRecrod = (TransactionRecord) transInput.readObject();
				transactionRecords.add(transactionRecrod);
			}
		} catch (EOFException eof) {
			System.err.printf("%nNo more records%n");
		}
		catch (ClassNotFoundException cnf) {
			System.err.printf("%nInvalid object type%n");
		}
		catch (IOException ioe) {
			System.err.printf("%nError opening file.%n");
		}
	}
	
	private static void addAccountRecords() {
		try {
			
			while (true) {
				Account account = (Account) oldmastInput.readObject();
				accounts.add(account);
			}
		} catch (EOFException eof) {
			System.err.printf("%nNo more records%n");
		}
		catch (ClassNotFoundException cnf) {
			System.err.printf("%nInvalid object type%n");
		}
		catch (IOException ioe) {
			System.err.printf("%nError opening file.%n");
		}
	}
	
	private static void closeFile()	{
		try {
			if (oldmastInput != null) {
				oldmastInput.close();
			}
			
			if (transInput != null) {
				transInput.close();
			}
			
			if (newmastOutput != null) {
				newmastOutput.close();
			}
			
			if (log != null) {
				log.close();
			}
		} catch (IOException ioException) {
			System.err.println("Error closing file.");
		}
	}

}










