package com.youtube;

import java.sql.*;

public class PrepStatementsDBDelete {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
		String user = "";
		String pass = "";
		PreparedStatement prepStmt = null;
		ResultSet res = null;
		
		try  (// 1. get connection to db
				Connection conn = DriverManager.getConnection(url, user, pass)) {
			
			// 2. prepare a statement
			String sql = "DELETE FROM employees WHERE salary > ? AND department = ?";
			
			prepStmt = conn.prepareStatement(sql);
			
			// 3. set the parameters
			prepStmt.setDouble(1, 80000);
			prepStmt.setString(2, "Legal");

			// 4. Execute SQL query and return number of rows deleted
			int rowsDeleted = prepStmt.executeUpdate();		

			System.out.printf("Number of rows deleted %d", rowsDeleted);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (res != null) {
					res.close();
				}
				
				if (prepStmt != null) {
					prepStmt.close();
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			
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
