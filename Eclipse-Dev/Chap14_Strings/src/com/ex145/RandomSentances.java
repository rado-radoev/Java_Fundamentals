package com.ex145;

import java.util.Random;

public class RandomSentances {
 
	 private static String[] article = {"the", "a", "one", "some", "any"};
	 private static String[] noun = {"boy", "girl", "dog", "town", "car"};
	 private static String[] verb = {"drove", "jumped", "ran", "walked", "skipped"};
	 private static String[] preposition = {"to", "from", "over", "under", "on"};
	 private static String[] output = new String[20];
	 private static Random rnd = new Random(System.currentTimeMillis());

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 20; i++) {
			String temp = String.format("%s %s %s %s %s %s", 
					article[rnd.nextInt(article.length)],
					noun[rnd.nextInt(noun.length)],
					verb[rnd.nextInt(verb.length)],
					preposition[rnd.nextInt(preposition.length)],
					article[rnd.nextInt(article.length)],
					noun[rnd.nextInt(noun.length)]);
			
			String append = Character.toString(temp.charAt(0)).toUpperCase() + temp.substring(1);
			output[i] = append.concat(".");
		}
		
		
		for (String s : output) {
			System.out.println(s);
		}

	}

}
