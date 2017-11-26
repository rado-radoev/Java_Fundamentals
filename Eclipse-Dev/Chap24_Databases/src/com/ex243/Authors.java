package com.ex243;

import java.util.concurrent.atomic.AtomicLong;

public class Authors {
	
	public Authors() {
		this("", "", "", "", "", "", "");
	}
	
	public Authors(String authorID, String authorFirstName, String authorLastName, String ISBN, String booktTitle,
			String bookEditionNumber, String copyright) {
		super();
		this.authorID = authorID;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.ISBN = ISBN;
		this.booktTitle = booktTitle;
		this.bookEditionNumber = bookEditionNumber;
		this.copyright = copyright;
	}
	/**
	 * @return the authorID
	 */
	public String getAuthorID() {
		return authorID;
	}
	/**
	 * @param authorID the authorID to set
	 */
	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}
	/**
	 * @return the authorFirstName
	 */
	public String getAuthorFirstName() {
		return authorFirstName;
	}
	/**
	 * @param authorFirstName the authorFirstName to set
	 */
	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}
	/**
	 * @return the authorLastName
	 */
	public String getAuthorLastName() {
		return authorLastName;
	}
	/**
	 * @param authorLastName the authorLastName to set
	 */
	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}
	/**
	 * @return the iSBN
	 */
	public String getISBN() {
		return ISBN;
	}
	/**
	 * @param iSBN the iSBN to set
	 */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	/**
	 * @return the booktTitle
	 */
	public String getBooktTitle() {
		return booktTitle;
	}
	/**
	 * @param booktTitle the booktTitle to set
	 */
	public void setBooktTitle(String booktTitle) {
		this.booktTitle = booktTitle;
	}
	/**
	 * @return the bookEditionNumber
	 */
	public String getBookEditionNumber() {
		return bookEditionNumber;
	}
	/**
	 * @param bookEditionNumber the bookEditionNumber to set
	 */
	public void setBookEditionNumber(String bookEditionNumber) {
		this.bookEditionNumber = bookEditionNumber;
	}
	/**
	 * @return the copyright
	 */
	public String getCopyright() {
		return copyright;
	}
	/**
	 * @param copyright the copyright to set
	 */
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	private String authorID;
	private String authorFirstName;
	private String authorLastName;
	private String ISBN;
	private String booktTitle;
	private String bookEditionNumber;
	private String copyright;

}
