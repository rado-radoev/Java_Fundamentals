package com.ex242;
// PreparedStetementes used by the Books Query Application
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;



/*
 * ResultSet rows and columns are counter from 1 and JTable
 * rows and columns are counter from 0. When processing ResultSet rows or columns
 * for use in a JTable, it is necessary to add
 * 1 to the rows or column number to manipulate the appropriate ResultSet column
 * (JTable column 0 is ResultSet column 1 and JTable row 0 is ResultSet row 1).
 */
public class DBQueries extends AbstractTableModel {

	private Connection connection;
	private PreparedStatement allAuthors;
	private PreparedStatement booksByAuthor;
	private PreparedStatement booksByTitle;
	private PreparedStatement booksByYear;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	
	public DBQueries(String db) {
		
		try {
			// connect to a database
			connection = DriverManager.getConnection(db);
			
			// Prepare Statements to query database
			
			// create query that selects all authors
			allAuthors = connection.prepareStatement(
				"SELECT * FROM Authors", 
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			// create query that selects author's first and last names, title of books written
			// year published and their ISBN when provided author's first name
			// results sorted by first name and then by last name
			booksByAuthor = connection.prepareStatement(
					 "SELECT FirstName, LastName, Title, Copyright, Titles.ISBN " + 
					 "FROM Authors " +
					 "INNER JOIN AuthorISBN " +  
					 "ON Authors.AuthorID = AuthorISBN.AuthorID " + 
					 "INNER JOIN Titles " +
					 "ON AuthorISBN.ISBN = Titles.ISBN " + 
					 "WHERE FirstName like ? " +
					 "ORDER BY LastName, FirstName",
					 ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			// create query that selects author's first and last names and book titles
			// when provided book title
			// results sorted by author's first name and then by last name
			booksByTitle = connection.prepareStatement(
					 "SELECT firstname, lastname, title " + 
					 "FROM Authors " + 
					 "INNER JOIN AuthorISBN " + 
					 "ON Authors.AuthorID = AuthorISBN.AuthorID " +  
					 "INNER JOIN Titles " + 
					 "ON AuthorISBN.ISBN = Titles.ISBN " +  
					 "WHERE title LIKE ? " +
					 "ORDER BY LastName, FirstName", 
					 ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			// create a query that selects author's first and last names, book title,
			// edition number and publication year
			// when year provided
			// results are sorted by year
			booksByYear = connection.prepareStatement(
					 "SELECT firstname, lastname, title, editionNumber, copyright " +   
					 "FROM Authors " +
					 "INNER JOIN AuthorISBN " + 
					 "ON Authors.AuthorID = AuthorISBN.AuthorID " + 
					 "INNER JOIN Titles " +
					 "ON AuthorISBN.ISBN = Titles.ISBN " + 
					 "WHERE copyright LIKE ? " +
					 "ORDER BY copyright",
					 ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// method that returns a class representation of all the objects in the column
	// used by JTable to configure default cell renderer and cell editor for the columns.
	public Class getColumnClass(int columnIndex) {
		try {
			String className = metaData.getColumnClassName(columnIndex + 1);
			
			// return Class object that represents className
			return Class.forName(className);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return Object.class;
	}
	
	// select user defined statement
	public void getUserDefined(String userStatement) {
		try {
			PreparedStatement uStatement = connection.prepareStatement(userStatement);
			uStatement.executeQuery();
			
			// notify JTable that model has changed
			fireTableStructureChanged();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// select all authors
	public void getAllAuthors() {
		try {
			allAuthors.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// select all books by year
	public void getBooksByYear(String year) {
		try {
			booksByYear.setString(1, year);  // specify year
			
			// executeQuery returns ResultSet containing matching entries
			resultSet = booksByYear.executeQuery();
			
			// notify JTable that model has changed
			fireTableStructureChanged();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// select all books by title
	public void getBooksByTitle(String bookTitle) {
		try {
			booksByTitle.setString(1, bookTitle); // specify title
			
			// executeQuery returns ResultSet containing matching entries
			resultSet = booksByTitle.executeQuery();
			
			// notify JTable that model has changed
			fireTableStructureChanged();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// select all books by author
	public void getBooksByAuthor(String author) {
		try {
			booksByAuthor.setString(1, author); // specify author
			
			// executeQuery returns ResultSet containing matching entries
			resultSet = booksByAuthor.executeQuery();
			
			// notify JTable that model has changed
			fireTableStructureChanged();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			disconnect();
		}
	}
		
	// get number of rows
	@Override
	public int getRowCount() {
		int rowNumber = 0;
		
		try {
			resultSet.last();
			rowNumber = resultSet.getRow();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowNumber;
	}

	// get number of columns in column set
	@Override
	public int getColumnCount() {
		try {
			metaData.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// return 0 if there are no columns
		return 0;
	}

	// get the value in a particular row and column
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			resultSet.absolute(rowIndex + 1);
			return resultSet.getObject(columnIndex + 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// return an empty string if nothing is found
		return "";
	}
	
	// get column name
	@Override
	public String getColumnName(int columnIndex) {
		try {
			return metaData.getColumnName(columnIndex + 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// if there is no column name to return, return an empty string
		return "";
	}
	
	public void disconnect() {
		try {
			resultSet.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	
}
