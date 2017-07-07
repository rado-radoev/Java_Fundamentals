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
		addTransactionRecords();
		addAccountRecords();
		
		matchTransactionsToAccounts();
		checkMissingAccountRecords();
		
		checkWrongTransactionRecord();
		
		closeFile();
	}
	
	private static void checkDupliateTransactions() {
		ArrayList<TransactionRecord> tempTS = new ArrayList<TransactionRecord>();
		TransactionRecord tempRecord;
		
		try {
			while (true) {
				TransactionRecord transactionRecrod = (TransactionRecord) transInput.readObject();
				tempTS.add(transactionRecrod);
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
		
		for (int i = 0; i < tempTS.size();i++) {
			tempRecord = new TransactionRecord();
			tempRecord.setAccountNumber(tempTS.get(i).getAccountNumber());
			tempRecord.setTransactionAmount(tempTS.get(i).getTransactionAmount());
			
			for (int j = i + 1; j < tempTS.size() - 1; j++) {
				if (tempTS.get(i).getAccountNumber() == tempTS.get(j).getAccountNumber()) {
					tempRecord.setTransactionAmount(tempRecord.getTransactionAmount() + tempTS.get(j).getTransactionAmount());
				}
			}
			
			if (tempRecord.getAccountNumber() != tempTS.get(i).getAccountNumber())
				transactionRecords.add(tempRecord);
			tempRecord = null;
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










