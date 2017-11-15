package com.ex2317;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.TreeMap;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//Class that stores two instants in time
class TimeData {
	public Instant start;
	public Instant end;
	
	public double timeInSeconds() {
		return Duration.between(start, end).toMillis() / 1000_0;
	}
}

public class FileTypeSummary {

	public static void main(String[] args) throws IOException {
		
		TimeData timeData = new TimeData();
		   timeData.start = Instant.now();
		   try {
			sequentialTest();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   timeData.end = Instant.now();
		   
		   TimeData timeData2 = new TimeData();
		   double seqTime = 
				   Duration.between(timeData.start, timeData.end).toMillis();
		   System.out.println("Sequential run took: " + seqTime + " milliseconds");
		   
		   
		   timeData2.start = Instant.now();
		   try {
			parallelTest();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   timeData2.end = Instant.now();
		   double parTime =
				   Duration.between(timeData2.start, timeData2.end).toMillis();
		   System.out.println("Parallel run took: " + parTime + " milliseconds");
		   
		   
		   String percentage = NumberFormat.getPercentInstance().format(seqTime / parTime);
		   System.out.println("Sequential task, took " + percentage + " more time than the parallel task");
		
	}
	
	public static void parallelTest() throws IOException {
		Pattern pattern = Pattern.compile("\\.[A-Za-z]{3,}$");
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter directory:");
		Path path = Paths.get(input.nextLine());
		DirectoryStream<Path> dir = Files.newDirectoryStream(path);
		
		List<String> directories = new ArrayList<>();
		dir.spliterator().forEachRemaining(curdir -> directories.add(curdir.toString()));
		
		Map<String, Long> fileSummaryLength = directories.parallelStream()
				.map(Paths::get)
				.filter(Files::isRegularFile)
				.flatMap(paths -> pattern.splitAsStream(paths.toString()))
				.collect(Collectors.groupingBy(String::toLowerCase,
						TreeMap::new, Collectors.counting()));
		
		
		Set<String> fileSummary = directories.parallelStream()
			.map(Paths::get)
			.filter(Files::isRegularFile)
			.flatMap(paths -> pattern.splitAsStream(paths.toString()))
			.collect(Collectors.toCollection(TreeSet::new));

		fileSummary.parallelStream()
			.sorted(Comparator.reverseOrder())
			.forEach(System.out::println);
	}
	
	public static void sequentialTest() throws IOException {
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
