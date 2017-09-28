package com.fig23;

// Producer and Consumer threads correctly manipulating a circular buffer

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class CircularBufferTest {

	public static void main(String[] args) throws InterruptedException {
		// create new thread pool with two threads
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		// create CircularBuffer to store ints
		CircularBuffer sharedLocation = new CircularBuffer();
		
		// display the initial state of the CircularBuffer
		sharedLocation.displayState("Initial State");
	
		// execute the Producer and Consumer tasks
		executorService.execute(new Producer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);
	}

}
