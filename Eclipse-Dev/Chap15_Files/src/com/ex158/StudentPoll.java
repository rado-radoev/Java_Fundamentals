package com.ex158;


import java.io.IOException;
import java.util.Formatter;
import java.io.FileNotFoundException;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.File;

public class StudentPoll {
	
	private static Formatter format;
	private static String file;

	public static void main(String[] args) {
		file = args[0];
		openFile();
		writeFile();
		closeFile();

	}
	
	private static void writeFile() {
		System.out.printf("%s %d %s %s %s %d %s %s%n" , 
				"Please, rate the food in the student cafeteria, with",
				1, 
				"being", 
				"\"awful\"",
				"and",
				5,
				"being",
				"\"excellent\"");
		
		
		
		// read the inputs from 20 students.
		// write them to a file using formatter
		Scanner input = new Scanner(System.in);

		int student = 1;
		do {
			try {
				System.out.println("Place your rating (1-5). Press CTLR + D to end input before the 20th student");
				System.out.printf("%s %d %s", "student" ,student, "vote: ");
				format.format("%d%n", input.nextInt());
			} catch (FormatterClosedException fce) {
				System.out.println("Error writing to the file");
			} catch (NoSuchElementException nse) {
				System.out.println("Invalid input");
			}

			student++;
		} while (input.hasNext() && student <= 20);
		
	}
	
	
	// open poll.txt file for writing
	private static void openFile() {
		
		Path path = Paths.get(file);
		
		if (!Files.exists(Paths.get(file))) {
			try {
				Files.createFile(path);
			} catch (IOException ioException) {
				System.out.print("Cannot create file.");
			}
		}
		
		try {
			format = new Formatter(file);
		} catch (SecurityException se) {
			System.out.println(file + " no write permissions.");
		} catch (FileNotFoundException fnf) {
			System.out.println(file + " not found.");
		}
	}
	
	
	private static void closeFile() {
		if (format != null)
			format.close();
	}

}
