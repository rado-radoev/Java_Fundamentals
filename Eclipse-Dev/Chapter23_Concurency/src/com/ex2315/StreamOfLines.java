package com.ex2315;

// Fig. 17.17: StreamOfLines.java
// Counting word occurrences in a text file.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.Duration;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


// Class that stores two instants in time
class TimeData {
	public Instant start;
	public Instant end;
	
	public double timeInSeconds() {
		return Duration.between(start, end).toMillis() / 1000_0;
	}
}


public class StreamOfLines
{
   public static void main(String[] args) 
   {
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
   
   public static double calculateTime(TimeData result1 , TimeData result2) {
	   TimeData bothThreads = new TimeData();
	   
	   // determine earlier start time
	   bothThreads.start = result1.start.compareTo(result2.start) < 0 ?
			   result1.start : result2.start;
	   
	   // determine later end time
	   bothThreads.end = result1.end.compareTo(result2.end) > 0 ?
			   result1.end : result2.end;
	   
	   return bothThreads.timeInSeconds();
   }
   
   public static void sequentialTest() throws IOException {
	// Regex that matches one or more consecutive whitespace characters
	      Pattern pattern = Pattern.compile("\\s+"); 

	      // count occurrences of each word in a Stream<String> sorted by word
	      Map<String, Long> wordCounts = 
	         Files.lines(Paths.get("//Users//superlamer//GitHub//Java_Fundamentals//Eclipse-Dev//Chapter23_Concurency//bin//com//ex2315//Chapter2Paragraph.txt"))
	              .map(line -> line.replaceAll("(?!')\\p{P}", ""))
	              .flatMap(line -> pattern.splitAsStream(line))
	              .collect(Collectors.groupingBy(String::toLowerCase,
	                 TreeMap::new, Collectors.counting()));
	      
	      // display the words grouped by starting letter
	      wordCounts.entrySet()
	         .stream()
	         .collect(
	            Collectors.groupingBy(entry -> entry.getKey().charAt(0), 
	               TreeMap::new, Collectors.toList()))
	         .forEach((letter, wordList) -> 
	            { 
	               System.out.printf("%n%C%n", letter);
	               wordList.stream().forEach(word -> System.out.printf(
	                  "%13s: %d%n", word.getKey(), word.getValue()));
	            });
   }
   
   public static void parallelTest() throws IOException {
	      // Regex that matches one or more consecutive whitespace characters
	      Pattern pattern = Pattern.compile("\\s+"); 

	      // count occurrences of each word in a Stream<String> sorted by word
	      Map<String, Long> wordCounts = 
	         Files.lines(Paths.get("//Users//superlamer//GitHub//Java_Fundamentals//Eclipse-Dev//Chapter23_Concurency//bin//com//ex2315//Chapter2Paragraph.txt"))
	         	  .parallel()
	              .map(line -> line.replaceAll("(?!')\\p{P}", ""))
	              .flatMap(line -> pattern.splitAsStream(line))
	              .collect(Collectors.groupingBy(String::toLowerCase,
	                 TreeMap::new, Collectors.counting()));
	      
	      // display the words grouped by starting letter
	      wordCounts.entrySet()
	         .parallelStream()
	         .collect(
	            Collectors.groupingBy(entry -> entry.getKey().charAt(0), 
	               TreeMap::new, Collectors.toList()))
	         .forEach((letter, wordList) -> 
	            { 
	               System.out.printf("%n%C%n", letter);
	               wordList.stream().forEach(word -> System.out.printf(
	                  "%13s: %d%n", word.getKey(), word.getValue()));
	            });
   }
   
} // end class StreamOfLines
