package com.fig2320;

// Buffer interface specifies methods called by Producer and Consumer
public interface Buffer {

	// place value into Buffer
	public void blockingPut(int value) throws InterruptedException;
	
	// return int value from Buffer
	public int blockingGet() throws InterruptedException;
}
