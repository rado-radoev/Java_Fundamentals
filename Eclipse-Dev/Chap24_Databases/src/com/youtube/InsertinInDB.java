package com.youtube;

import java.sql.*;

public class InsertinInDB {

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
			String sql = "INSERT INTO employees " +
						 " (last_name, first_name, email)" + 
						 " values ('Brown', 'David', 'david.brows@gmail.com')";
			
			myStmt.executeUpdate(sql);
			
			System.out.println("Insert complete");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
