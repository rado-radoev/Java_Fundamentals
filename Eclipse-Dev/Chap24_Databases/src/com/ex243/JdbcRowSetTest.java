package com.ex243;

// Display the contents of Authors table

import java.sql.SQLException;
import java.sql.ResultSetMetaData;

import javax.sql.RowSetWriter;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetTest {

	public static void main(String[] args) {
		final String DATABASE_URL = "jdbc:derby:books";
		final String USERNAME = "";
		final String PASSWORD = "";
		final String SELECT_QUERY = "INSERT INTO Authors (FirstName, LastName) VALUES ('Looser', 'BigLooser')";
	
		// use try-with-resources to connect to and query the database
		try (JdbcRowSet rowSet = 
					RowSetProvider.newFactory().createJdbcRowSet()) {
			
			rowSet.setUrl(DATABASE_URL);
			rowSet.setUsername(USERNAME);
			rowSet.setPassword(PASSWORD);
			rowSet.setCommand(SELECT_QUERY); // set query
			rowSet.commit();
			rowSet.setCommand("SELECT * FROM Authors");
			rowSet.execute(); // execute query
			
			// get results meta data
			ResultSetMetaData metaData = rowSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			
			System.out.printf("Authors Table of Books Database:%n%n");
			
			// display the names of the columns in the ResultSet
			for (int i = 1; i <= numberOfColumns; i++)
				System.out.printf("%-16s\t", metaData.getColumnName(i));
			System.out.println();
			
			// display the query results
			while(rowSet.next()) {
				for (int i = 1; i <= numberOfColumns; i++) {
					System.out.printf("%-16s\t", rowSet.getObject(i));
				}
				System.out.println();
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	
	}
	
}
