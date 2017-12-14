package com.youtube;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class ResultSetMetaData {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
		String user = "";
		String pass = "";
				
		try  (
				// 1. get connection to db
				Connection conn = DriverManager.getConnection(url, user, pass)) {
			
			ResultSet resultSet = null;
			Statement statement = null;
			
			// 2. Run query
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT id, last_name, first_name, salary FROM employees");
			
			// 3. get result set metadata
			java.sql.ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			
			// 4. display info
			int columnsCount = resultSetMetaData.getColumnCount();
			System.out.println("Column count: " + columnsCount + "\n");
			
			// output data for each column
			for (int col = 1; col <= columnsCount; col++) {
				System.out.println("Column name: " + resultSetMetaData.getColumnName(col));
				System.out.println("Column type name: " + resultSetMetaData.getColumnTypeName(col));
				System.out.println("Is Nullable: " + resultSetMetaData.isNullable(col));
				System.out.println("Is Auto Increment: " + resultSetMetaData.isAutoIncrement(col));
				System.out.println();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
	}
}
