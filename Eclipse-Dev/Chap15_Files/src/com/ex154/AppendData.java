package com.ex154;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AppendData {
	
	private static File file;
	private static BufferedWriter bw;
	private static FileWriter fw;
	private static ObjectOutputStream output;
	
	public static void appendFile() {
		
		
		
		Scanner input = new Scanner(System.in);
		
		if (file.getName().equalsIgnoreCase("trans.txt")) {
			System.out.printf("%s %s%n", "Transaction Account Number",
					"Transaction Amount");
			while (input.hasNext()) {
				TransactionRecord transactionRecord = new TransactionRecord(
						input.nextInt(), input.nextDouble());
				
				System.out.printf("%s %s%n", "Transaction Account Number",
						"Transaction Amount");
				
				try {
					fw = new FileWriter(file, true);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				bw = new BufferedWriter(fw);
				
				//bw.write();
			}		
		}
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		file = new File(args[0]);
	}

}
