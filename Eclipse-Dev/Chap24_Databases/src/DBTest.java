
// Display the contents of Authors table

import java.sql.Connection;
import java.sql.Driver;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DBTest {

	public static void main(String[] args) {
		final String DATABASE_URL = "jdbc:derby:books";
		final String SELECT_QUERY = "SELECT authorID, firstName, lastName FROM authors";
	
		// use try-with-resources to connect to and query the database
		try (
				Connection connection = DriverManager.getConnection(
					DATABASE_URL);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(SELECT_QUERY))
		{
			// get results meta data
			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			
			System.out.printf("Authors Table of Books Database:%n%n");
			
			// display the names of the columns in the ResultSet
			for (int i = 1; i <= numberOfColumns; i++)
				System.out.printf("%-16s\t", metaData.getColumnName(i));
			System.out.println();
			
			// display the query results
			while(resultSet.next()) {
				for (int i = 1; i <= numberOfColumns; i++)
					System.out.printf("%-16s\t", resultSet.getObject(i));
				System.out.println();
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	
	}
	
}
