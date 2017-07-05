package com.ex152;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileManipulation {
	
	private final String separator = File.separator;
	private static Formatter output;
	
	
	
	public static void main(String[] args) throws IOException {

		// prompt the user to enter a file, using absolute path
		Scanner input = new Scanner(System.in);
		
		System.out.printf("Enter file name using full path to file:%n");
		Path path = Paths.get(input.nextLine());
		
		displayFolderContents(path);
	}
	
	// output to text file
	private static void openFile(File file) {
		try {
			output = new Formatter(file.getAbsolutePath());
		}
		catch (SecurityException securityException) {
			System.err.println("No write permissions!");
		}
		catch (FileNotFoundException fileNotFound) {
			System.err.println("File not found!");
		}
	}
	
	// helper method that writes text to file
	private void writeText(Formatter output) {
		output.format("%s", "this is a test");
	}
	
	// helper method to display contents in directory
	private static void displayDirInfo(Path dir) throws IOException {
		System.out.printf("%n%s exists: %n", dir.getFileName());
		System.out.printf("%s is directory: %n", Files.isDirectory(dir));
		System.out.printf("Absolute paths is: %s%n", dir.toAbsolutePath());
		System.out.printf("Has size of: %s%n", Files.size(dir));
	}
	
	private static void displayFolderContents(Path dir) throws IOException {
		DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir);
		
		for (Path p : directoryStream) {
			if (Files.isDirectory(p))
				displayDirInfo(p);
		}
	}
	
}




