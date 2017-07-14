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
		
		System.out.println("After adding first two properties - color and width");
	
	}

}
