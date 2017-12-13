package com.youtube;

import java.sql.*;

public class UpdateDB {

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
			String sql = "UPDATE employees " + 
						 " SET email='david.brown@contoso.com'" +
						 " WHERE last_name LIKE 'Bro%' " +
						 " AND first_name LIKE 'Dav%'";
			
			myStmt.executeUpdate(sql);
			
			System.out.println("Update complete");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
