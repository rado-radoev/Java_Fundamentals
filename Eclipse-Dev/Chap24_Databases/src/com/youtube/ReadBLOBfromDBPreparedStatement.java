package com.youtube;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadBLOBfromDBPreparedStatement {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
		String user = "";
		String pass = "";
						
		try  (
				// 1. get connection to db
				Connection conn = DriverManager.getConnection(url, user, pass)) {

			PreparedStatement statement = null;
			ResultSet resultSet = null;
			
			InputStream input = null;
			FileOutputStream output = null;
			
			
			// 2. execute statement 
			String sql = "SELECT resume FROM employees WHERE email=?";
			statement = conn.prepareStatement(sql);
			statement.setString(1, "john.doe@foo.com");
			
			resultSet = statement.executeQuery();
			
			// 3. set up handle to the file
			File file = new File("resume_from_db.pdf");
			output = new FileOutputStream(file);
			
			if (resultSet.next()) {
				input = resultSet.getBinaryStream("resume");
				System.out.println("Reading resume from database ...");
				System.out.println(statement);
				
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);
				}
				
				System.out.println("\nSaved to file:  " + file.getAbsolutePath() );
				System.out.println("\nCompleted successfully!");
				output.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();	
		} 
		
	}
}
