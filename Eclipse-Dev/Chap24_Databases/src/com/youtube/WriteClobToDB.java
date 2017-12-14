package com.youtube;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class WriteClobToDB {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
		String user = "";
		String pass = "";
				
		try  (
				// 1. get connection to db
				Connection conn = DriverManager.getConnection(url, user, pass)) {
			
			PreparedStatement preparedStatement = null;
			FileReader input = null;
			
			String sql = "UPDATE employees SET resume=? WHERE email='john.doe@foo.com'";
			preparedStatement = conn.prepareStatement(sql);
			
			// 3. set parameter for resume file name
			File file = new File("sample_resume.txt");
			input = new FileReader(file);
			preparedStatement.setCharacterStream(1, input);
			
			System.out.println("Reading input file: " + file.getAbsolutePath());
			
			// 4. Execute statement
			System.out.println("\nStoring resume in database " + file);
			System.out.println(preparedStatement);
			
			preparedStatement.executeUpdate();
			
			System.out.println("\nCompleted successfully!");
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
	}
}
