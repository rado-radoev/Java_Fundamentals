package com.ex1510;

import java.util.Formatter;
import java.util.FormatterClosedException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Map;


public class PhishingScanner {
	
	private static Formatter output;
	private static Map<String,Integer> spamListScores;
	private static int lineCount;
	
	private static void openFile() {
		
		spamListScores = new HashMap<String, Integer>();
		Pattern word = Pattern.compile("\\b(\\w+[^0-9])\\b");
		Pattern score = Pattern.compile("[0-9]$");
		
		try  (Scanner input = new Scanner(Paths.get("spamlist.txt"))) {
			while (input.hasNext()) {
				lineCount++;
				// read each line 
				// grab the text and add it to hashmaps as key
				// grab the number and add it to the hashmap key as value
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
