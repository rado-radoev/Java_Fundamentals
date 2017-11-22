package com.ex243;

// Display the contents of Authors table

import java.sql.SQLException;
import java.sql.ResultSetMetaData;

import javax.sql.RowSetWriter;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetTest {

	public static void main(String[] args) {
		final String DATABASE_URL = "jdbc:derby:books";
		final String USERNAME = "";
		final String PASSWORD = "";
		// final String SELECT_QUERY = "SELECT * FROM Authors";
		final String SELECT_QUERY = "SELECT FirstName, LastName, Title, Copyright, Titles.ISBN " + 
				 "FROM Authors " +
				 "INNER JOIN AuthorISBN " +  
				 "ON Authors.AuthorID = AuthorISBN.AuthorID " + 
				 "INNER JOIN Titles " +
				 "ON AuthorISBN.ISBN = Titles.ISBN " + 
				 "WHERE FirstName like 'Frank' " +
				 "ORDER BY LastName, FirstName";
		
		// INSERT INTO Authors (FirstName, LastName) VALUES ('Looser', 'BigLooser')
	
		// use try-with-resources to connect to and query the database
		try (CachedRowSet rowSet = 
					RowSetProvider.newFactory().createCachedRowSet()) {
			
			
			rowSet.setUrl(DATABASE_URL);
			rowSet.setUsername(USERNAME);
			rowSet.setPassword(PASSWORD);
			rowSet.setCommand(SELECT_QUERY); // set query
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
//					// if column name is last name and contains Petel as an entry
//					// change it to Deitel and update row
//					if (rowSet.getString("lastName").equals("Petel")) {
//						String newLastName = "Deitel";
////						System.out.println("Updating: " + 
////								rowSet.getString("lastName") +
////								" to " + newLastName);
//						
//						rowSet.updateString("lastName", newLastName);
//						rowSet.updateRow();
//					}
				
					// find authorID
/*					if (rowSet.getString("FirstName").equals("Frank"))
						authorID = rowSet.getInt("AuthorID");
*/					
					// delete row from titles
//					try {
//						if (rowSet.getInt("ISBN") == 999999999) {
//							rowSet.deleteRow();
//						}	
//					} catch (SQLException e) {
//						// in case there is a string added to the ISBN field
//					}
					
							
					System.out.printf("%-16s\t", rowSet.getObject(i));
				}
				System.out.println();
			}
			
			// add isbn, title, editionnumber and copyright to titles 
//			rowSet.setCommand("INSERT INTO Titles (ISBN, Title, EditionNumber, Copyright) VALUES (?, ?, ? ,?)");
//			rowSet.setLong(1, 9999999999L);
//			rowSet.setString(2, "Catch me if you can");
//			rowSet.setInt(3, 2);
//			rowSet.setInt(4, 2017);
//			rowSet.execute();
			
			
			// insert AuthorID to AuthorISBN
//			rowSet.setCommand("INSERT INTO AuthorISBN (AuthorID, ISBN) VALUES (?, ?)");
//			rowSet.setInt(1, 1101);
//			rowSet.setLong(2, 9999999999L);
//			rowSet.execute();
			
			
//			// insert new author
//			rowSet.setCommand("INSERT INTO Authors (FirstName, LastName) VALUES (?, ?)");
//			rowSet.setString(1, "Frank");
//			rowSet.setString(2, "Abignale");
//			rowSet.execute();
//			
//			// move back to top of rowSet
//			rowSet.first();
//	
//			while (rowSet.next()) {
//				if (rowSet.getInt("AuthorID") == 1102) {
//					rowSet.deleteRow();
//				}
//					
//			}
			
			// sync the row back to the db
			rowSet.acceptChanges();
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	
	}
	
}
