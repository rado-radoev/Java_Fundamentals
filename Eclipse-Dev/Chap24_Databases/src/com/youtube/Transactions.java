package com.youtube;

import java.sql.*;
import java.util.Scanner;

public class Transactions {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
		String user = "";
		String pass = "";
		Statement statement = null;
		
		try  (// 1. get connection to db
				Connection conn = DriverManager.getConnection(url, user, pass)) {
			
			// turn off auto commit
			conn.setAutoCommit(false);
			
			// show salaries BEFORE
			System.out.println("Salaries BEFORE:\n");
			showSalaries(conn, "HR");
			showSalaries(conn, "Engineering");
			
			// create a statement
			statement = conn.createStatement();

			// Transaction Step 1: Delete all HR employees
			statement.executeUpdate("DELETE FROM employees WHERE department='HR'");
			
			// Transaction Step 2: Set salaries to 300_000 for all Engineering
			statement.executeUpdate("UPDATE employees SET salary=300000 WHERE department='Engineering'");
			
			System.out.println("\n>> Transaction steps are ready.\n");
			
			boolean ok = (askUserOkToSave());
			
			if (ok) {
				// store in database
				conn.commit();
				System.out.println("\n>> Transaction COMMITED.\n");
			} else {
				// discard
				conn.rollback();
				System.out.println("\n>> Transaction DISCARDED.\n");
			}
			
			// show salaries AFTER
			System.out.println("Salaries AFTER:\n");
			showSalaries(conn, "HR");
			showSalaries(conn, "Engineering");
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
	}
	
	private static boolean askUserOkToSave() {
		System.out.print("Should I commit (yes/no): ");
		Scanner in = new Scanner(System.in);
		String answer = in.nextLine();
		
		if (answer.toLowerCase().equals("yes"))
			return true;
		else if (answer.toLowerCase().equals("no"))
			return false;
		
		return false;
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
