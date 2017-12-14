package com.youtube;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Statement;

public class MetaDataBasics {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
		String user = "";
		String pass = "";
		Statement statement = null;
		
		try  (// 1. get connection to db
				Connection conn = DriverManager.getConnection(url, user, pass)) {
			
			// 2. get SQL table metadata
			DatabaseMetaData databaseMetaData = conn.getMetaData();
			
			// 3. Display info about database
			System.out.println("Product name: " + databaseMetaData.getDatabaseProductName());
			System.out.println("Product version: " + databaseMetaData.getDatabaseProductVersion());
			System.out.println();
			
			// 4. Display info about JDBC driver
			System.out.println("JDBC Driver Name: " + databaseMetaData.getDriverName());
			System.out.println("JDBC Driver Version: " + databaseMetaData.getDriverVersion());
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
	}
}
