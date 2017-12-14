package com.youtube;

import java.sql.*;

public class StoredProceduresResultSet {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
		String user = "";
		String pass = "";
		CallableStatement myStmt = null;
		
		try  (// 1. get connection to db
				Connection conn = DriverManager.getConnection(url, user, pass)) {
			
			String theDepartment = "Engineering";
					
			// Prep the stored procedure call
			myStmt = conn.prepareCall("{call get_employees_for_department(?)}");
			
			// set the parameters
			myStmt.setString(1, theDepartment);
			
			// call stored procedure
			System.out.println("\nCalling stored procedure. get_employees_for_department: " +  "('" + theDepartment +"')");
			myStmt.execute();
			System.out.println("Finished calling stored procedure\n");
			
			// get the resultset
			ResultSet res = myStmt.getResultSet();
			
			display(res);
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
	}
	
	private static void display(ResultSet myRs) throws SQLException {
		while (myRs.next()) {
			String lastName = myRs.getString("last_name");
			String firstName = myRs.getString("first_name");
			double salary = myRs.getDouble("salary");
			String department = myRs.getString("department");
			
			System.out.printf("%s, %s, %.2f, %s\n", lastName, firstName, salary, department);
		}
	}
}
