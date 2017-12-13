package com.youtube;

import java.sql.*;

public class ConnectToDB {

	public static void main(String[] args) {
		
		try {
			// 1. get connection to db
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", 
					"user", "pass");
			// 2. create a statement
			Statement myStat = myConn.createStatement();
			// 3. create query
			ResultSet myRes = myStat.executeQuery("SELECT * FROM employees");
			// 4. process resultset
			while (myRes.next()) {
				System.out.println(myRes.getString("last_name") + " " + myRes.getString("first_name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
