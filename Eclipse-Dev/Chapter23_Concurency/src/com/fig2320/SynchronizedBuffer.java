package com.fig2320;
 
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.fig2320.Buffer;

import java.util.concurrent.locks.Condition;


public class SynchronizedBuffer implements Buffer {

	// lock to control synchronization with this buffer
	private final Lock accessLock = new ReentrantLock();
	
	// conditions to control reading and writing
	private final Condition canWrite = accessLock.newCondition();
	private final Condition canRead = accessLock.newCondition();
	
	private int buffer = -1; // shared by producer and consumer threads
	private boolean occupied = false; // whete buffer is occupied
	
	// place int value into buffer
	public void blockingPut(int value) throws InterruptedException {
		accessLock.lock(); // lock this object
		
		
		// output thread information and buffer information then wait
		try {
			// while buffer is not empty, put thread in waiting state
			while (occupied) {
				System.out.println("Producer tries to write");
				displayState("Buffer full. Producer waits.");
				canWrite.await();  // wait unitl buffer is empty
			}
			
			buffer = value; // set the new buffer value
			
			// indicate that producer cannot store another value
			// until consumer retrieves current buffer value
			occupied = true;
			
			displayState("Producer writes " + buffer);
			
			// signal any threads waiting to read from buffer
			canRead.signalAll();
			
		} finally {
			accessLock.unlock(); // unlock this object
		}
	}
	
	// return value from buffer
	public int blockingGet()	throws InterruptedException {
		int readvValue = 0; // initialize value read from buffer
		accessLock.lock(); // lock this object
		
		// output thread information and buffer information, then wait
		try {
			while (!occupied) {
				System.out.println("Consumer tries to read.");
				displayState("Buffer empty. Consumer waits.");
				canRead.await(); // wait until buffer is full
			}
			
			// indicate that producer can store another value
			// because consumer just retrieved buffer value
			occupied = false;
			
			readvValue = buffer; // retrieve value from buffer
			displayState("Consumer reads " + readvValue);
			
			// signal any thread waiting for buffer to be empty
			canWrite.signalAll();
			
		} finally {
			accessLock.unlock(); // unlock this object
		}
		
		return readvValue;
	}
	
	
	// display current operation and bufffer state
	public void displayState(String operation) {
		try {
			
			accessLock.lock(); // lock this object
			System.out.printf("%-40s%d\t\t%b%n%n", operation, buffer, occupied);
			
			
		} finally {
			accessLock.unlock(); // unlock this object
		}
	}
	
}




































