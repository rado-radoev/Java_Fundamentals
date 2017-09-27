package com.fig23;
// Two threads manipulating a blocking buffer that properly
// impelments the producer/consumer relationship

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BlockingBufferTest{

	public static void main(String[] args) throws InterruptedException {
		// create new thread pool with two threads
		ExecutorService executor = Executors.newCachedThreadPool();
		
		// create BlockingBuffer to store ints
		Buffer sharedLocation = new BlockingBuffer();
		
		executor.execute(new Producer(sharedLocation));
		executor.execute(new Consumer(sharedLocation));
		
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.MINUTES);
	}
}
