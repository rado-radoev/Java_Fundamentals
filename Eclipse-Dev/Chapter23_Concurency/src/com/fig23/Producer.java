package com.fig23;
// Producer with a Run method that inserts the values 1 to 10 in buffer

import java.security.SecureRandom;

public class Producer implements Runnable {
	
	private static final SecureRandom generator = new SecureRandom();
	private final Buffer sharedLocation;	// reference to shared object
	
	// constructor
	public Producer(Buffer sharedLocation) {
		this.sharedLocation = sharedLocation;
	}

	@Override
	// Store values from 1 to 10 in sharedLocation
	public void run() {
		int sum = 0;		
		
		for (int i = 1; i <= 10; i++) {
			try { // sleep from 0 to 3 seconds, then place value in Buffer
				Thread.sleep(generator.nextInt(3000));	// random sleep
				sharedLocation.blockingPut(i);
				sum += i;
				// uncomment this line for unsynchronized System.out.printf("\t%2d%n", sum);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		
		System.out.printf("Producer done producing%nTerminating Producer%n");
	}

	
}
