package com.ex1710;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.TreeMap;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FileTypeSummary {

	public static void main(String[] args) throws IOException {
		
		Pattern pattern = Pattern.compile("\\.[A-Za-z]{3,}$");
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter directory:");
		Path path = Paths.get(input.nextLine());
		DirectoryStream<Path> dir = Files.newDirectoryStream(path);
		
		List<String> directories = new ArrayList<>();
		dir.spliterator().forEachRemaining(curdir -> directories.add(curdir.toString()));
		
		Map<String, Long> fileSummaryLength = directories.stream()
				.map(Paths::get)
				.filter(Files::isRegularFile)
				.flatMap(paths -> pattern.splitAsStream(paths.toString()))
				.collect(Collectors.groupingBy(String::toLowerCase,
						TreeMap::new, Collectors.counting()));
		
		
		Set<String> fileSummary = directories.stream()
			.map(Paths::get)
			.filter(Files::isRegularFile)
			.flatMap(paths -> pattern.splitAsStream(paths.toString()))
			.collect(Collectors.toCollection(TreeSet::new));

		fileSummary.stream()
			.sorted(Comparator.reverseOrder())
			.forEach(System.out::println);

		
	}

}
