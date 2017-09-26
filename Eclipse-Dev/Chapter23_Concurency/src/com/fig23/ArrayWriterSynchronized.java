package com.fig23;

import java.lang.Runnable;
import java.lang.Thread.State;

// Adds integers to an array shared with other Runnables
public class ArrayWriterSynchronized implements Runnable {
	
	private final SimpleArraySinchronized sharedSimpleArray;
	private final int startValue;
	
	public ArrayWriterSynchronized(int value, SimpleArraySinchronized array) {
		startValue = value;
		sharedSimpleArray = array;
	}

	@Override
	public void run() {
		for (int i = startValue; i < startValue + 3; i++) {
			sharedSimpleArray.add(i); // add an element to the shared array
		}
	}

	
}
