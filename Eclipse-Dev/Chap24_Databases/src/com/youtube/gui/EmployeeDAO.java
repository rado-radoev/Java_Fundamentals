package com.youtube.gui;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Date;

import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.math.BigDecimal;



public class EmployeeDAO {
	
	private Connection connection;
	private User usr;
	
	public EmployeeDAO() {
		this(null);
	}
	
	public EmployeeDAO(User usr) {
		this.usr = usr;
		
		// get db properties
		Properties props = new Properties();
		
		try {
			props.load(new FileInputStream("database.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		// connect to database 
		try  {
			
		connection = DriverManager.getConnection(dburl, user, password);
		System.out.println("DB connection successful to: " + dburl.substring(33));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void addAuditHistory(Employee employee, User user, String action) {
		PreparedStatement statement = null;
		String sql = "INSERT INTO audit_history (user_id, employee_id, action, action_date_time) values (?, ?, ?, ?)";
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, user.getId());
			statement.setInt(2, employee.getId());
			statement.setString(3, action);
			statement.setString(4, new Date().toString());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public boolean updateEmployee(Employee employee) {
		PreparedStatement statement = null;
		String sql = "UPDATE employees SET first_name=?, last_name=?, email=?, salary=? WHERE id=?";
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, employee.getFirstName());
			statement.setString(2, employee.getLastName());
			statement.setString(3, employee.getEmail());
			statement.setBigDecimal(4, employee.getSalary());
			statement.setInt(5, employee.getId());
			
			statement.executeUpdate();
			
			addAuditHistory(employee, usr, "Update user" + employee.getFirstName() + " "  + employee.getLastName());
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addEmployee(Employee employee) {
		PreparedStatement statement = null;
		String sql = "INSERT INTO employees (first_name, last_name, email, salary) " + 
				" values (?, ?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, employee.getFirstName());
			statement.setString(2, employee.getLastName());
			statement.setString(3, employee.getEmail());
			statement.setBigDecimal(4, employee.getSalary());
			
			statement.executeUpdate();
			addAuditHistory(employee, usr, "Add user" + employee.getFirstName() + " "  + employee.getLastName());
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Employee> getAllEmployees() throws SQLException {
		List<Employee> list = new ArrayList<>();
		
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM employees");
			
			while (resultSet.next()) {
				Employee tempEmployee = convertRowToEmployee(resultSet);
				list.add(tempEmployee);
			}
			
			return list;
		} finally {
			close(statement, resultSet);
		}
	}
	
	public List<Employee> searchEmployees(String lastName) throws SQLException {
		List<Employee> list = new ArrayList<Employee>();
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			lastName += '%';
			preparedStatement = connection.prepareStatement("SELECT * FROM employees WHERE last_name LIKE ?");
			preparedStatement.setString(1, lastName);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				list.add(convertRowToEmployee(resultSet));
			}
			
			return list;
		} finally {
			close(preparedStatement, resultSet);
		}
		
	}
	
	private Employee convertRowToEmployee(ResultSet resultSet) throws SQLException {
			int id = resultSet.getInt("id");
			String lastName = resultSet.getString("last_Name");
			String firstName = resultSet.getString("first_Name");
			String email = resultSet.getString("email");
			BigDecimal salary = resultSet.getBigDecimal("salary");

		return new Employee(id, lastName, firstName, email, salary);
	}
	
	public User convertRowToUser(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String lastName = result.getString("last_name");
		String firstName = result.getString("first_name");
		String email = result.getString("email");
		
		User tempU = new User(id, lastName, firstName, email);
		
		return tempU;
	}
	
	public List<User> getUsers() throws SQLException {
		List<User> list = new ArrayList<User>();
		
		Statement statement = null;
		ResultSet result = null;
		
		String sql = "SELECT * FROM users ORDER BY last_name";
		try {
			statement = connection.createStatement();
			result = statement.executeQuery(sql);
			
			while (result.next()) {
				User tempUser = convertRowToUser(result);
				list.add(tempUser);
			}
			
			return list;
		} finally {
			close(statement, result);
		}
	}
	
	public List<AuditHistory> getAuditHistory(int employeeId) throws SQLException {
		List<AuditHistory> list = new ArrayList<AuditHistory>();
		
		Statement statement = null;
		ResultSet result = null;
		
		try {
			statement = connection.createStatement();
			String sql = "SELECT history.user_id, history.employee_id, history.action, history.action_date_time, users.first_name, users.last_name  "
					+ "FROM audit_history history, users users "
					+ "WHERE history.user_id=users.id AND history.employee_id=" + employeeId;
			
			result = statement.executeQuery(sql);
			
			while (result.next()) {
				int userId = result.getInt("history.user_id");
				String action = result.getString("history.action");
				
				Timestamp timeStamp = result.getTimestamp("history.action_date_time");
				Date actionDateTime = new Date(timeStamp.getTime());
				
				String userFirstName = result.getString("users.first_name");
				String userLastName = result.getString("users.last_name");
				
				AuditHistory temp = new AuditHistory(userId, employeeId, action, actionDateTime, userFirstName, userLastName);
				list.add(temp);
			}
			
			return list;
			
		} finally {
			close(statement, result);
		}
	}
	
	private <T> void close(T...object) throws SQLException {
		for (T obj : object) {
			if (obj != null) {
				if (obj instanceof ResultSet) {
					((ResultSet) obj).close();
				}
				else if (obj instanceof Connection) {
					((Connection)obj).close();
				}
				else if (obj instanceof Statement) {
					((Statement)obj).close();
				}
				else {
					throw new IllegalArgumentException("Object of incorrect type");
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		EmployeeDAO dao = new EmployeeDAO();
		System.out.println(dao.searchEmployees("thom"));

		System.out.println(dao.getAllEmployees());
		
		System.out.println(dao.getAuditHistory(4));
	}
}






