package com.fig23;

// Application with two threads manipulating an unsynchronized buffer
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedBufferTest {

	public static void main(String[] args) throws InterruptedException {

		// create new thread pool with two threads
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		// create UnsynchronizedBuffer to store ints
		Buffer sharedLocation = new UnsinchronizedBuffer();
		
		System.out.println("Action\t\tValue\tSum of Produced\tSum of Consumed");
		System.out.printf("------\t\t----\t---------------\t--------------%n%n");
		
		// execute the Producer and Consumer, giving each access to sharedLocation
		executorService.execute(new Producer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		
		executorService.shutdown();  // terminate app when task completes
		executorService.awaitTermination(1, TimeUnit.MINUTES);
	}

}
