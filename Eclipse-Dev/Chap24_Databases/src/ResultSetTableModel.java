// A TableModel that supplies ResultSet data to a JTable

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

/* ResultSet rows and columns are counter from 1 and JTable rows and columns are
 * counted from 0. When processing ResultSet rows or columns for user in a JTable 
 * it is necessary to add 1 to to the row or column number to manipulate the 
 * Appropriate RestulSet column (i.e., JTable column 0 is ResultSet column 1 and
 * JTable row 0 is ResultSet row 1).
 */
public class ResultSetTableModel extends AbstractTableModel {
	
	private final Connection connection;
	private final Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;
	private final String NODBCONN = "Not Connected to Database";
	
	// keep track of database connection status
	private boolean connectedToDatabase = false;
	
	// constructor initializes resultSet and obtains its metadata object:
	// determines number of rows
	public ResultSetTableModel(String url, String userName, String password, String query) throws SQLException {
		// connect to database
		connection = DriverManager.getConnection(url, userName, password);
		
		// create statement to query database
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		// update database connection status
		connectedToDatabase = true;
		
		// set query and execute it
		setQuery(query);
	}

	// get class that represents column type
	public Class getColumnClass(int column) throws IllegalStateException {
		// ensure database connection is available
		checkDBConnAlive();
		
		// determine Java class of column
		try {
			String className = metaData.getColumnClassName(column + 1);
			
			// return class object that represents className
			return Class.forName(className);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// if problem occurs above, assume type object
		return Object.class;
	}

	
	// get number of columns in ResultSet
	@Override
	public int getColumnCount() throws IllegalStateException {
		// ensure database connection is available
		checkDBConnAlive();
		
		try {
			return metaData.getColumnCount();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
		// if problems occur above, return 0 for number of columns
		return 0;
	}
	
	
	// get number of particular column in ResultSet
	@Override
	public String getColumnName(int column) throws IllegalStateException {
		// ensure database connection is available
		if (!connectedToDatabase) 
			throw new IllegalStateException(NODBCONN);
		
		// determine column name
		try {
			return metaData.getColumnName(column + 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// if problem occurs, return empty string for column name
		return "";
	}
	
	// return number of rows in ResultSet
	public int getRowCount() throws IllegalStateException {
		// ensure database connection is alive
		checkDBConnAlive();
		
		return numberOfRows;
	}
	
	// obtain value in particular row and column
	public Object getValueAt(int row, int column) throws IllegalStateException {
		// ensure daabase connection is alive
		checkDBConnAlive();
		
		// obtain a value at specified ResultSet row and column
		try {
			resultSet.absolute(row + 1);
			return resultSet.getObject(column + 1); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// if problem, return empty string object
		return "";
	}
	
	// set new database query string
	public void setQuery(String query) throws SQLException, IllegalStateException{
		// ensure database connection is alive
		checkDBConnAlive();
		
		// specify query and execute it
		resultSet = statement.executeQuery(query);
		
		// obtain meta data for ResultSet
		metaData = resultSet.getMetaData();
		
		// determine number of rows in ResultSet
		resultSet.last(); // move to last row
		numberOfRows = resultSet.getRow(); // get row number
		
		// notify JTable that model has changed
		fireTableStructureChanged();
	}
	
	// close Statement and Connection
	public void disconnectFromDatabase() {
		if (connectedToDatabase) {
			// close Statement and Connection
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			} finally {  // update database connection status
				connectedToDatabase = false;
			}
		}
	}
	
	
	// ensure database connection is alive
	private boolean checkDBConnAlive() throws IllegalStateException {
		if (!connectedToDatabase)
			throw new IllegalStateException(NODBCONN);
		return true;
	}
}





























