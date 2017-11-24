package com.ex243;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class CashedRowSetQuery {
	private final String DATABASE_URL = "jdbc:derby:books";
	private final String AUTHORS_QUERY = "SELECT * FROM Authors";
	private final String TITLES_QUERY = "SELECT * FROM Titles";
	private final String ISBN_QUERY = "SELECT * FROM AuthorISBN";
//	private final String DEFAULT_QUERY = 
//			 "SELECT FirstName, LastName, Title, Copyright, Titles.ISBN " + 
//			 "FROM Authors " +
//			 "INNER JOIN AuthorISBN " +  
//			 "ON Authors.AuthorID = AuthorISBN.AuthorID " + 
//			 "INNER JOIN Titles " +
//			 "ON AuthorISBN.ISBN = Titles.ISBN";
	private final String USERNAME = "";
	private final String PASSWORD = "";
	private CachedRowSet rowSet;
	private ResultSetMetaData metaData;
	private int numberOfColumns;
	
	// default construtor
	CashedRowSetQuery() throws SQLException {
		this("");
		
	} // end of default constructor

	CashedRowSetQuery(String query) throws SQLException {
		// create cachedRowSet
		rowSet = RowSetProvider.newFactory().createCachedRowSet();
		// connect to db
		connectToDB();
		
		if (query.contains("Authors"))
			queryDB(AUTHORS_QUERY);
		else if (query.contains("ISBN"))
			queryDB(ISBN_QUERY);
		else if (query.contains("Titles"))
			queryDB(TITLES_QUERY);
		else
			queryDB(AUTHORS_QUERY);
			
		// get table properties
		metaData = rowSet.getMetaData();
		setNumberOfColumns(metaData);
		
	}
	
	// connect to specific db
	private final void queryDB(String query) throws SQLException {
		rowSet.setCommand(query);
		rowSet.execute();
	}
	
	
	// connect to db
	private final void connectToDB() {
		try {
			rowSet.setUrl(DATABASE_URL);
			rowSet.setUsername(USERNAME);
			rowSet.setPassword(PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public String getColumnName(int index) {
		try {
			return metaData.getColumnName(index);
		} catch (SQLException e) {
			System.err.println("Column out of range");
		}
		
		// return empty column name if error occurs
		return "";
	}
	
	private void setNumberOfColumns(ResultSetMetaData metaData) {
		try {
			numberOfColumns = metaData.getColumnCount();
		} catch (SQLException e) {
			System.err.println("Cannot get number of columns");
		}
	}
	
	public int getNumberOfColumns() {
		return numberOfColumns;
	}
	
	public RowSet getRowSet() {
		return rowSet;
	}
	
	
	public static void main(String[] args) {
		try {
		CashedRowSetQuery crsq = new CashedRowSetQuery();
		
		System.out.println("Default query has: " + crsq.getNumberOfColumns() + " columns");
		for (int i = 1; i <= crsq.getNumberOfColumns();i++) {
			System.out.printf("%-10s\t",crsq.getColumnName(i));
		}
		System.out.println();
		while (crsq.getRowSet().next()) {
			for (int i = 1; i <= crsq.getNumberOfColumns();i++) {
				if (crsq.getRowSet().getString("lastname").equals("Deitel"))
					System.out.printf("%-10s\t",crsq.getRowSet().getObject(i));	
			}
			System.out.println();
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
