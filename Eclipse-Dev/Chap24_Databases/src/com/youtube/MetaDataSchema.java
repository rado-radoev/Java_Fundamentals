package com.youtube;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class MetaDataSchema {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
		String user = "";
		String pass = "";
		
		String catalog = null, schemaPattern = null, tableNamePattern = null, columnNamePattern = null;
		String[] types = null;
		
		
		try  (
				// 1. get connection to db
				Connection conn = DriverManager.getConnection(url, user, pass)) {
			
			ResultSet resultSet = null;
			
			// 2. get the metadata
			DatabaseMetaData databaseMetaData = conn.getMetaData();

			// 3. get list of tables
			System.out.println("List of Tables");
			System.out.println("--------------");
			
			resultSet = databaseMetaData.getTables(catalog, schemaPattern, tableNamePattern, types);
			
			// get table names
			while(resultSet.next()) {
				System.out.println(resultSet.getString("TABLE_NAME"));
			}
			
			// 4. get list of columns
			System.out.println("\n\nList of Columns");
			System.out.println("--------------");
			
			resultSet = databaseMetaData.getColumns(catalog, schemaPattern, "employees", columnNamePattern);
			
			// get column names
			while(resultSet.next()) {
				System.out.println(resultSet.getString("COLUMN_NAME"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
	}
}
