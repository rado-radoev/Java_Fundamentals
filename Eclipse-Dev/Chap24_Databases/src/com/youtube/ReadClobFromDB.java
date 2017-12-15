package com.youtube;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadClobFromDB {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
		String user = "root";
		String pass = "rado";
				
		try  (
				// 1. get connection to db
				Connection conn = DriverManager.getConnection(url, user, pass)) {
			
			Statement statement = null;
			ResultSet resultSet = null;
			Reader input = null;
			FileWriter output = null;
			
			// 2. execute statement
			statement = conn.createStatement();
			String sql = "SELECT resume FROM employees WHERE email='john.doe@foo.com'";
			resultSet = statement.executeQuery(sql);
			
			// 3. setup handle to the file
			File file = new File("resume_from_db.txt");
			output = new FileWriter(file);
			
			if (resultSet.next()) {
				input = resultSet.getCharacterStream("resume");
				System.out.println("Reading resume from database ...");
				System.out.println();
				
				int character;
				while((character = input.read()) > 0) {
					output.write(character);
				}
			}
			
			System.out.println("\nSaved to file: " + file.getAbsolutePath());
			System.out.println("\nCompleted successfully!");
			
			output.close();
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
	}
}
