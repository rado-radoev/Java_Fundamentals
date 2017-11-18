
// PreparedStatements used by the AddressBook application
import java.security.KeyStore.ProtectionParameter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class PersonQueries {

	private static final String URL = "jdbc:derby:addressbook";
	private static final String USERNAME = "";
	private static final String PASSWORD = "";
	
	private Connection connection; // manages connection
	private PreparedStatement selectAllPeople;
	private PreparedStatement selectPeopleByLastName;
	private PreparedStatement insertNewPerson;
	
	// constructor
	public PersonQueries() {
		try {
			connection = 
					DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			// create query that selects all entries in the address book
			selectAllPeople =
					connection.prepareStatement("SELECT * FROM Addresses");
			
			// create query that selects entries with a specific last name
			selectPeopleByLastName = connection.prepareStatement(
					"SELECT * FROM Addresses WHERE lastname = ?");
			
			// create insert that adds a new entry into the database
			insertNewPerson = connection.prepareStatement(
					"INSERT INTO Addresses" + 
					"(FirstName, LastName, Email, PhoneNumber)" +
					"VALUES (?, ?, ?, ?)");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1); // terminate application
		} 
	}
	
	// select all of the addresses in the database
	public List< Person > getAllPeople() {
		List < Person > results = null;
		ResultSet resultSet = null;
	
		try {
			// executeQuery returns ResultSet containing matching entries
			resultSet = selectAllPeople.executeQuery();
			results = new ArrayList< Person >();
			
			while (resultSet.next()) {
				results.add(new Person(
						resultSet.getInt("addressID"),
						resultSet.getString("FirstName"),
						resultSet.getString("LastName"),
						resultSet.getString("Email"),
						resultSet.getString("PhoneNumber")));
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
				close();
			}
		}
		return results;
	}
	
	// select person by last name
	public List< Person > getPeopleByLastName(String name) {
		List < Person > results = null;
		ResultSet resultSet = null;
		
		try {
			selectPeopleByLastName.setString(1, name);
			
			// executeQuery returns ResultSet, containing mathching criteria
			resultSet = selectPeopleByLastName.executeQuery();
			results = new ArrayList< Person >();
			
			while (resultSet.next()) {
				results.add(new Person(
						resultSet.getInt("addressID"),
						resultSet.getString("FirstName"),
						resultSet.getString("LastName"),
						resultSet.getString("Email"),
						resultSet.getString("PhoneNumber")));
			}
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
				close();
			}
		}
		
		return results;
	}
	
	// add an entry
	public int addPerson(
			String firstName, String lastName, String email, String phoneNumnber) {
		int result = 0;
		
		// set parameters, then execute insertNewPerson
		try {
			insertNewPerson.setString(1, firstName);
			insertNewPerson.setString(2, lastName);
			insertNewPerson.setString(3, email);
			insertNewPerson.setString(4, phoneNumnber);
			
			// insert the new entry; returns # of rows updated
			result = insertNewPerson.executeUpdate();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		
		return result;
	}
	
	// close the database connection
	public void close() {
		try {
			connection.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
} // end class PersonQueries





























