package com.ex179;

// Summarize the number of characters in the text file

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.regex.Pattern;

public class CountChars {
	
	public static void main(String[] args) throws IOException {
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







