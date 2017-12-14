package com.youtube;

import java.sql.*;

public class StoredProceduresOUT {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
		String user = "";
		String pass = "";
		CallableStatement myStmt = null;
		
		try  (// 1. get connection to db
				Connection conn = DriverManager.getConnection(url, user, pass)) {
			
			String theDepartment = "Engineering";
					
			// Prep the stored procedure call
			myStmt = conn.prepareCall("{call get_count_for_department(?, ?)}");
			
			// set the parameters
			myStmt.setString(1, theDepartment);
			myStmt.registerOutParameter(2, Types.INTEGER);
			
			// call stored procedure
			System.out.println("\nCalling stored procedure. get_count_for_department: " +  "('" + theDepartment +"', ?)");
			myStmt.execute();
			System.out.println("Finished calling stored procedure");
			
			// get the value of the OUT parameter
			int theCount = myStmt.getInt(2);
			
			System.out.println("\nThe count = " + theCount);
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
	}
}
