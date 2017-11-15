package com.ex2316;

// Summ	arize the number of characters in the text file

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import java.util.regex.Pattern;

//Class that stores two instants in time
class TimeData {
	public Instant start;
	public Instant end;
	
	public double timeInSeconds() {
		return Duration.between(start, end).toMillis() / 1000_0;
	}
}

public class CountChars {
	
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
		// regex pattern to mach only characters
		Pattern pattern = Pattern.compile("\\s+");

		// count occurances of each character in a Stream<String>
			Map<Character, Long> charCount = Files.lines(Paths.get("Chapter2Paragraph.txt"))
					.parallel()
					.flatMap(line -> pattern.splitAsStream(line))
					.map(line -> line.replaceAll("\\p{P}", ""))
					.map(line -> line.charAt(0))
					.collect(Collectors.groupingBy(line -> line.toString().charAt(0),
							TreeMap::new, Collectors.counting()));

			System.out.printf("%s %s%n", "Letter", "Occurance");
			charCount.entrySet()
	        .parallelStream()
	        .collect(
	           Collectors.groupingBy(entry -> entry.getKey(), TreeMap::new, Collectors.toList()))
	        .forEach((letter, wordlist) -> {
	        	wordlist
	        	.stream()
        		.forEach(word -> System.out.printf("%3s%7d%n", word.getKey(), word.getValue()));
	        });
				
	}

	public static void sequentialTest() throws IOException {
		// regex pattern to mach only characters
		Pattern pattern = Pattern.compile("\\s+");

		// count occurances of each character in a Stream<String>
			Map<Character, Long> charCount = Files.lines(Paths.get("Chapter2Paragraph.txt"))
					.flatMap(line -> pattern.splitAsStream(line))
					.map(line -> line.replaceAll("\\p{P}", ""))
					.map(line -> line.charAt(0))
					.collect(Collectors.groupingBy(line -> line.toString().charAt(0),
							TreeMap::new, Collectors.counting()));

			System.out.printf("%s %s%n", "Letter", "Occurance");
			charCount.entrySet()
	        .stream()
	        .collect(
	           Collectors.groupingBy(entry -> entry.getKey(), TreeMap::new, Collectors.toList()))
	        .forEach((letter, wordlist) -> {
	        	wordlist
	        	.stream()
        		.forEach(word -> System.out.printf("%3s%7d%n", word.getKey(), word.getValue()));
	        });
				
	}
}







