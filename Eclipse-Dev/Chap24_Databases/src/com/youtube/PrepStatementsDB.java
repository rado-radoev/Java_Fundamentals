package com.youtube;

import java.sql.*;

public class PrepStatementsDB {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
		String user = "";
		String pass = "";
		Connection conn =  null;
		PreparedStatement prepStmt = null;
		ResultSet res = null;
		
		try {
			// 1. get connection to db
			conn = DriverManager.getConnection(url, user, pass);
			// 2. prepare a statement

			String sql = "SELECT * FROM employees WHERE salary > ? AND department = ?";
			
			prepStmt = conn.prepareStatement(sql);
			
			// 3. set the parameters
			prepStmt.setDouble(1, 80000);
			prepStmt.setString(2, "Legal");

			// 4. Execute SQL query
			res = prepStmt.executeQuery();
			
			display(res);
			
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
				
				if (conn != null) {
					conn.close();
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
