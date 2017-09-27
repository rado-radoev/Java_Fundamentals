package com.fig23;
// Consumer with a run methdo that loops, reading 10 values from buffer

import java.security.SecureRandom;

public class Consumer implements Runnable {

	private static final SecureRandom generator = new SecureRandom();
	private final Buffer sharedLocation;		// reference to shared object
	
	public Consumer(Buffer sharedLocation) {
		this.sharedLocation = sharedLocation;
	}
	
	@Override
	// Read sharedLocation's value 10 times and sum the values
	public void run() {
		int sum = 0;
		
		for (int i = 1; i <= 10; i++) {
			// sleep from 0 to 3 seconds and then read value from buffer
			try {
				Thread.sleep(generator.nextInt(3000));  // random sleep
				sum += sharedLocation.blockingGet();
				// uncomment this line for unsynchronized System.out.printf("\t\t\t%2d%n", sum);
 			} catch (InterruptedException e) {
 				Thread.currentThread().interrupt();
			}
		}
		
		System.out.printf("%n%s %d%n%s%n", 
				"Consumer read values totaling", sum, "Terminating Consumer");
	}
}
