package com.fig23;
//Creating a synchronized buffer using an ArrayBlockingQueue

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer	 {

	private final ArrayBlockingQueue<Integer> buffer;  // shared buffer
	
	public BlockingBuffer() {
		buffer = new ArrayBlockingQueue<>(1);
	}

	@Override
	// place value into buffer
	public void blockingPut(int value) throws InterruptedException {
		buffer.put(value);  // place value in buffer. Since queue size is 1 only 1 element is allowed to be in the queue
		System.out.printf("%s%2d\t%s%d%n", "Producer writes ", value, "Buffer cells occupied: ", buffer.size());
	}

	@Override
	// return value from buffer
	public int blockingGet() throws InterruptedException {
		int readValue = buffer.take();	// remove value from buffer
		System.out.printf("%s %2d\t%s%d%n", "Consumer reads ", readValue, "Buffer cells occupied: ", buffer.size());
		
		return readValue;
	}
	
	
}
