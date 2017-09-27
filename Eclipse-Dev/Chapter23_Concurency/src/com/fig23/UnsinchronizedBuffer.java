package com.fig23;

// UnsincronizedBuffer maintains the shared integer that is accessed by a producer thread and a consumer thread

public class UnsinchronizedBuffer implements Buffer {
	
	private int buffer = -1;  // shared by producer and consumer
	
	@Override
	// place value into buffer
	public void blockingPut(int value) throws InterruptedException {
		System.out.printf("Producer writes\t%2d", value);
		buffer = value;
	}

	@Override
	// return value from buffer
	public int blockingGet() throws InterruptedException {
		System.out.printf("Consumer reades\t%2d", buffer);
		return buffer;
	}

}
