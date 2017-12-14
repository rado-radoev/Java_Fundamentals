package com.youtube;

import java.sql.*;

public class StoredProceduresIN {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
		String user = "";
		String pass = "";
		CallableStatement myStmt = null;
		
		try  (// 1. get connection to db
				Connection conn = DriverManager.getConnection(url, user, pass)) {
			
			String theDepartment = "Engineering";
			int theIncreaseAmount = 10000;
			
			// Show salaries BEFORE
			System.out.println("Salaries BEFORE\n");
			showSalaries(conn, theDepartment);
			
			// Prep the stored procedure call
			myStmt = conn.prepareCall("{call increase_salaries_for_department(?, ?)}");
			
			// set the parameters
			myStmt.setString(1, theDepartment);
			myStmt.setDouble(2, theIncreaseAmount);
			
			// call stored procedure
			System.out.println("\nCalling stored procedure. increase_salaries_for_department: " + theDepartment);
			myStmt.execute();
			System.out.println("Finished calling stored procedure");
			
			// show salaries AFTER
			System.out.println("\n\nSalaries AFTER\n");
			showSalaries(conn, theDepartment);
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
	}
	
	private static void showSalaries(Connection myConn, String theDepartment) {
		

		try (PreparedStatement myStmt = myConn.prepareStatement("select * from employees where department=?"))  { 

			// Prepare statement		
			myStmt.setString(1, theDepartment);
			
			// Execute SQL query
			ResultSet myRs = myStmt.executeQuery();

			// Process result set
			while (myRs.next()) {
				String lastName = myRs.getString("last_name");
				String firstName = myRs.getString("first_name");
				double salary = myRs.getDouble("salary");
				String department = myRs.getString("department");
				
				System.out.printf("%s, %s, %s, %.2f\n", lastName, firstName, department, salary);
			}
			
			
			if (myRs != null)
				myRs.close()	;
			
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
	}

}
