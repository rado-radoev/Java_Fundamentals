package com.ex154;

import java.io.Serializable;

public class TransactionRecord implements Serializable {
	
	private int accountNumber;
	private double transactionAmount;
	
	// initalize transaction record with default values
	public TransactionRecord() {
		this(0,0);
	}
	
	// initialize transaction record with provided values
	public TransactionRecord(int accountNumber, double transactionAmount) {
		setAccountNumber(accountNumber);
		setTransactionAmount(transactionAmount);
		
	}
	
	// get account number
	public int getAccountNumber() {
		return accountNumber;
	}
	
	// set account number 
	public final void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	// get transaction amount
	public double getTransactionAmount() {
		return transactionAmount;
	}
	
	// set transaction amount
	public final void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

}
