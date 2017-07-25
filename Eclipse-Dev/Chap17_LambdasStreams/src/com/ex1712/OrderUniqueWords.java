package com.ex1712;

import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.regex.Pattern;

public class OrderUniqueWords {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter sentence here: (No punctuation)");
		String sentence = input.nextLine();
		
//		Pattern.compile(" ").splitAsStream(sentence)
//			.map(String::toLowerCase)
//			.distinct()
//			.sorted()
//			.forEach(System.out::println);
		
		
		Map<String, Long> wordCounts = 
				Pattern.compile(" ").splitAsStream(sentence)
					//.distinct()
					.collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()));

		wordCounts.entrySet()
			.stream()
			.collect(Collectors.groupingBy(entry -> entry.getKey(), TreeMap::new, Collectors.toList()))
			.forEach((letter, wordlist) -> {
				wordlist.stream().forEach(word -> System.out.printf("%s %d%n", word.getKey(), word.getValue()));
			});
	}

}
