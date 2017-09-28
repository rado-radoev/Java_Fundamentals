package com.fig23;

import java.awt.DisplayMode;

// Synchronizing access to shared mutable data using Object methods wait notifyAll

public class SynchronizedBuffer implements Buffer {

	private int buffer = -1;  // shared to produce and consumer threads
	private boolean occupied = false;
	
	// place value into buffer
	public synchronized void blockingPut(int value) throws InterruptedException {
		// while there are no empty locations, place thread in waiting state
		while (occupied) {
			// output thread information and buffer information, then wait
			System.out.println("Producer tries to write");
			displayState("Buffer full. Producer waits");
			wait();
		}
		
		buffer = value;  // set new buffer value
		
		// indicate producer cannot store another value
		// until consumer retrieves current buffer value
		occupied = true;
		
		displayState("Producer writes " + buffer);
		
		notifyAll(); // tell waiting thread(s) to enter runnable state 
	}
	
	// return value from buffer
	public synchronized int blockingGet() throws InterruptedException {
		// while no data to read, place thread in waiting state
		while(!occupied) {
			// output thread information and buffer information, then wait
			System.out.println("Consumer tries to read");
			displayState("Buffer empty. Consumer waits");
			wait();
		}
		
		// indicate that producer can store another value
		// because consumer just retrieved buffer value
		occupied = false;
		
		displayState("Consumer reads " + buffer);
		
		notifyAll();  // tell waiting thread(s) to enter runnable state
		
		return buffer;
	}
	
	// display current operation and buffer state
	private synchronized void displayState(String operation) {
		System.out.printf("%-40s%d\t\t%b%n%n", operation, buffer, occupied);
	}
}



































