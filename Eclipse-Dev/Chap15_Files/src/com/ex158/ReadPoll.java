package com.ex158;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Formatter;

public class ReadPoll {
	
	private static Formatter output;
	private static String file;
	
	
	private static void openFile() {
		try {
			output = new Formatter("output.txt");
		} catch (Exception e) {
			System.out.println("Cannot create file.");
		}
	}
	
	private static void outputResults() {
		int[] answers = readPoll();
		for (int i = 1; i < answers.length;i++) {
			output.format("%d: %d%n", i, answers[i]);
		}
	}
	
	private static int[] readPoll() {
		
		int[] answers = new int[6];
		
		try (Scanner input = new Scanner(Paths.get("poll.txt"))) {
			while (input.hasNext()) {
				int num = input.nextInt();
				answers[num]++;
			}
		} catch (NoSuchElementException nse) {
			nse.printStackTrace();
		} catch (IllegalStateException ise) {
			System.out.printf("error reading file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return answers;
	}
	

	private static void closeFile() {
		if (output != null) {
			output.close();
		}
	}
	
	public static void main(String[] args) {
		openFile();
		outputResults();
		closeFile();
	}

}
