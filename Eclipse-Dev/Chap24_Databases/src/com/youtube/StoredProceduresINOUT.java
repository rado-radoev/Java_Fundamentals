package com.youtube;

import java.sql.*;

public class StoredProceduresINOUT {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
		String user = "";
		String pass = "";
		CallableStatement myStmt = null;
		
		try  (// 1. get connection to db
				Connection conn = DriverManager.getConnection(url, user, pass)) {
			
			String department = "Engineering";

			// Prep the stored procedure call
			myStmt = conn.prepareCall("{call greet_the_department(?)}");
			
			// set the parameters			
			myStmt.setString(1, department);
			// register the parameter as inout parameter
			myStmt.registerOutParameter(1, Types.VARCHAR );
			
			// call stored procedure
			System.out.println("\nCalling stored procedure. greet_the_department: " + department);
			myStmt.execute();
			System.out.println("Finished calling stored procedure");
						
			String result = myStmt.getString(1);
			
			System.out.println("\nThe result = " + result);
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
	}
}
