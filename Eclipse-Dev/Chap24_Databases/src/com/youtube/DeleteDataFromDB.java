package com.youtube;

import java.sql.*;

public class DeleteDataFromDB {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false";
		String user = "";
		String pass = "";
		
		
		try {
			// 1. get connection to db
			Connection myConn = DriverManager.getConnection(url, user, pass);
			// 2. create a statement
			Statement myStmt = myConn.createStatement();
			// 3. execute SQL query
			String sql = "DELETE FROM employees WHERE last_name='Brown'";
			
			// execute sql statement
			int rowsAffected = myStmt.executeUpdate(sql);
			
			System.out.println("Rows affected: " + rowsAffected);
			System.out.println("Delete complete");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
