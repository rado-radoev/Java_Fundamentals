package com.properties;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		Properties table = new Properties();
		
		table.setProperty("color", "blue");
		table.setProperty("width", "200");
		
		System.out.println(" After adding first two properties - color and width");
		listProperties(table);
		
		// replace property value
		table.setProperty("color", "red");
		
		System.out.println("\n After replacing propery color");
		listProperties(table);
		
		saveProperties(table);
		
		System.out.println("\n After cleaning up the properties");
		table.clear();
		listProperties(table);
		
		// loading properties from the file
		loadProperties(table);
		
		// get value of property color
		Object value = table.getProperty("color");
		
		// check if value is in table
		if (value != null) {
			System.out.printf("\n Property color's value is %s%n", value);
		}
		else {
			System.out.println("\n Property color not in table");
		}
		
		
		
	}
	
	private static void loadProperties(Properties props) {
		try {
			FileInputStream input = new FileInputStream("props.dat");
			props.load(input);
			input.close();
			System.out.println("\n After loading properties");
			listProperties(props);			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static void saveProperties (Properties props) {
		// save contents of table
		try {
			FileOutputStream output = new FileOutputStream("props.dat");
			props.store(output, "Sample Properties");
			output.close();
			System.out.println("\n After saving properties to file");
			listProperties(props);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	private static void listProperties (Properties props) {
		//Set <Object> keys = props.keySet();
		
		// output name/value pairs
		for (Object key : props.keySet()) {
			System.out.printf("%s\t%s%n", key, props.getProperty((String) key));
		}
	}
}
