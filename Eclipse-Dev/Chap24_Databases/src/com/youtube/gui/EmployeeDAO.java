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
import java.sql.Statement;
import java.sql.ResultSet;
import java.math.BigDecimal;

public class EmployeeDAO {
	
	private Connection connection;
	
	public EmployeeDAO() {
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
}






