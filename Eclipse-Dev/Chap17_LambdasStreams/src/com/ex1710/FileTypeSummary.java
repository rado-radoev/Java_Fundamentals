package com.ex1710;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class FileTypeSummary {

	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter directory:");
		Path path = Paths.get(input.nextLine());
		DirectoryStream<Path> dir = Files.newDirectoryStream(path);
		
		List<String> directories = new ArrayList<>();
		dir.spliterator().forEachRemaining(curdir -> directories.add(curdir.toString()));
		
		directories.stream()
			.map(entry -> Paths.get(entry))
			.filter(entry -> Files.isDirectory((entry)));

		

	}

}
