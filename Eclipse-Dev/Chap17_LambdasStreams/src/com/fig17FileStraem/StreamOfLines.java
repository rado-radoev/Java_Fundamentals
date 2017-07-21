package com.fig17FileStraem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamOfLines {

	public static void main(String[] args) throws IOException {
		// regex matching on or more consecutive white spaces
		Pattern pattern = Pattern.compile("\\s+");
		
		// count occurrences of each word in a stream<String> sorted by word
		Map<String, Long> wordCounts = 
				Files.lines(Paths.get("Chapter2Paragraph.txt"))
					.map(line -> line.replaceAll("(?!')\\p{P}", ""))
					.flatMap(line -> pattern.splitAsStream(line))
					.collect(Collectors.groupingBy(String::toLowerCase,
							TreeMap::new, Collectors.counting()));
				

		// display the words grouped by starting letter
		wordCounts.entrySet()
        .stream()
        .collect(
           Collectors.groupingBy(entry -> entry.getKey().charAt(0),TreeMap::new, Collectors.toList()))
        .forEach((letter, wordlist) -> {
        	System.out.printf("%n%C%n", letter);
        	wordlist.stream()
        		.forEach(word -> System.out.printf("%13s: %d%n", word.getKey(), word.getValue()));
        });
		
		
	}

}
