package com.ex154;

import java.io.Serializable;

public class Account implements Serializable {

	private int account;
	private String firstName;
	private String lastName;
	private double balance;
	private TransactionRecord transactionRecord;
	
	// initiazlize account with default values
	public Account() {
		this(0, "", "", 0);
	}
	
	// initialize account with provided values
	public Account(int account, String firstName, String lastName, double balance) {
		setAccount(account);
		setFirstName(firstName);
		setLastName(lastName);
		setBalance(balance);
	}

	// get account
	public int getAccount() {
		return account;
	}

	// set account
	public final void setAccount(int account) {
		this.account = account;
	}

	// get firstname
	public String getFirstName() {
		return firstName;
	}

	// set first name
	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// get last name
	public String getLastName() {
		return lastName;
	}

	// set last name
	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// get balance
	public double getBalance() {
		return balance;
	}

	// set balance
	public final void setBalance(double balance) {
		this.balance = balance;
	}
	
	// method to combine transaction record amount and account balance
	private double combine(TransactionRecord tr, Account account) {
		return tr.getTransactionAmount() + account.getBalance();
	}

}
















