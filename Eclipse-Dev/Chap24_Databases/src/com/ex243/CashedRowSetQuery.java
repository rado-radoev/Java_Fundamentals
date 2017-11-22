package com.ex243;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class CashedRowSetQuery {
	private final String DATABASE_URL = "jdbc:derby:books";
	private final String DEFAULT_QUERY = "SELECT * FROM Authors";
	private final String USERNAME = "";
	private final String PASSWORD = "";
	private CachedRowSet rowSet;
	private ResultSetMetaData metaData;
	private int numberOfColumns;
	
	// default construtor
	CashedRowSetQuery() throws SQLException {
		// create cachedRowSet
		rowSet = RowSetProvider.newFactory().createCachedRowSet();
		
		// connect to db
		connectToDB();
		
		// get table properties
		metaData = rowSet.getMetaData();
		setNumberOfColumns(metaData);
		
		
	} // end of default constructor

	// TO DO: how to present this data to the JFRAME ????
	
	// connect to db
	private final void connectToDB() {
		try {
			rowSet.setUrl(DATABASE_URL);
			rowSet.setUsername(USERNAME);
			rowSet.setPassword(PASSWORD);
			rowSet.setCommand(DEFAULT_QUERY);
			rowSet.execute();
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
	
}
