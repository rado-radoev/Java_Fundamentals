/*
 * Program that reads a list of spam words and matches provided text
 */
package com.ex1510;

import java.util.Formatter;
import java.util.FormatterClosedException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;



public class PhishingScanner {
	
	private static Formatter output;
	private static Map<String,Integer> spamListScores;
	private static int lineCount;
	private static int[] scores = new int[4];
	
	public static void main(String[] args) {
		loadSpamList();
		String s = "Greetings from Avanset: Price Drop 40% on everything with Avanset! Dear customers! Join Avanset team to celebrate World Chocolate Day! Only 1 week from Monday, July 10th till Sunday, July 16th get 40% OFF all the purchases on Avanset website. Use the chance to become a certified IT expert easier and cheaper. Make your life sweeter! To use the discount simply type in the Promo Code 40OffJuly17 on the checkout page and enjoy your preparation. Enjoy this life! Activate your brain. Shop with Avanset team!Choose the VCE Exam Simulator plan that suits you best: VCE Exam Simulator BASIC let you play existing .vce exam files VCE Exam Simulator PRO let you play and edit existing .vce exam files and create your own exams The Offer is on this week only and ends on Sunday, July 16th, so don’t miss this great opportunity to save 40% with Avanset and invest in your better future today! Enter the Promo Code 40OffJuly17 at the checkout to use 40% OFF. Click here to get started!Avanset makes exam preparation easier, so here’s to getting certified hassle-free! Follow us on Facebook: tps://www.facebook.com/avansetcom For Mac users, click here. Want to install it on your mobile device?Thank you for your loyalty and support!Avanset Support Team support@avanset.comwww.avanset.omAvanset.com Mailing Address:27 Old Gloucester StreetLondonWC1N 3AXUnited KingdomNOTICE: You have received this email at rradoev@gmail.com as you are a registered member of Avanset.com. If you wish to discontinue receiving the Avanset.com Newsletter, please UNSUBSCRIBE.";
		scanText(s);
		checkScore();
		
	}
	
	/**
	 * <p>Method that checks the spam score and displays a message<br />
	 * how likely it is that the message is spam or not
	 * </p>
	 */
	private static void checkScore() {
		int total = 0;
		for (int i = 1; i < scores.length;i++) {
			total += scores[i];
		}
		
		System.out.println("Total score is: " + total + ". " + (total > 10 ? "Message is probably spam." : "Message does not look like spam."));
	}
	
	/**
	 * <p>Method that accepts a string of text and parses each word individually<br />
	 * Then it matches each word from the text to the list of predefined spam words.<br />
	 * If a match is found, the word score is written to an array.
	 * </p>
	 * 
	 * <ul>
	 * 	Example
	 * 	<li>scanText("This is a FREE spam message"); </li>
	 * </ul>
	 * 
	 * @param text - A string that will be scanned against the spam list.
	 * @return none
	 */
	private static void scanText (String text) {
		Pattern p = Pattern.compile("\\b\\w+\\b");
		Matcher m = p.matcher(text);
		
		while (m.find()) {
			if (spamListScores.containsKey(m.group())) {
				scores[spamListScores.get(m.group())]++;
			}
		}
	}
	
	/**
	 * <p>Reads the spam list and their score to the screen</p>
	 * */
	@SuppressWarnings("unused")
	private static void readSpamList() {
		for (String key : spamListScores.keySet()) {
			System.out.println("Key: " + key + " value: " + spamListScores.get(key));
		}
	}
	
	/**
	 * <HTML>
	*	<BODY>
	*	This method scans a text file, containing spam words and a score assigned to them
	*	and outputs it into a HashMap
	*	<p>
	*	The hasmap is loaded into memory in order to be used later on for processing strings
	*	</p>
	*	
	*	@throws IOException
	*	@since 1.0 
	*	@see java.util.Map
	*	</BODY>
	* 	</HTML>
	 * */
	private static void loadSpamList() {
		
		spamListScores = new HashMap<String, Integer>();

		try  (Scanner input = new Scanner(Paths.get("spamlist"))) {
			while (input.hasNext()) {
				String[] splitted = input.nextLine().split(",");
				spamListScores.put(splitted[0], Integer.valueOf(splitted[1]));
			}
		} catch (IOException ioException) {
			System.out.print("Cannot open file;");
		}
	}

}
