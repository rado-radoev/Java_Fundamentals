package com.fig23;

import java.util.Arrays;
import java.security.SecureRandom;


// Class that manages an integer array to be shared by multiple threads
public class SimpleArraySinchronized {		// THREAD SAFE

	private static final SecureRandom generator = new SecureRandom();
	private final int[] array; 	// the shared integer array
	private int writeIndex; 		// Shared index of next element to write
	
	// Construct a simple array of a given size
	public SimpleArraySinchronized(int size) {
		array = new int[size];
	}
	
	// add a value to the shared array
	public synchronized void add(int value) {
		int position = writeIndex;	// store the write index
		
		try {
			// put thread to sleep for 0-499 milliseconds
			Thread.sleep(generator.nextInt(500));
		} catch (Exception e) {
			Thread.currentThread().interrupt();  // re-interrupt the thread
		}
		
		// put value in the appropriate element
		array[position] = value;
		System.out.printf("%s wrote %2d to element %d.%n",
				Thread.currentThread().getName(), value, position	);
		
		++writeIndex;  // increment index of element to be written next
		System.out.printf("Next write index: %d%n", writeIndex);
	}
	
	// used for outputting the contents of the share integer array
	public synchronized String toString() {
		return Arrays.toString(array);
	}
}
