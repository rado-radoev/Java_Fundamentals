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
		final String SELECT_QUERY = "SELECT * FROM Titles";
		
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
					
					System.out.printf("%-16s\t", rowSet.getObject(i));
				}
				System.out.println();
			}
			
			// insert AuthorID to AuthorISBN
//			rowSet.setCommand("INSERT INTO AuthorISBN (AuthorID, ISBN) VALUES (?, ?)");
//			rowSet.setInt(1, 1001);
//			rowSet.setInt(2, 999999999);
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
