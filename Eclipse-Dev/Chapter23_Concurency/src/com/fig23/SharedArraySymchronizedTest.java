package com.fig23;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class SharedArraySymchronizedTest {

	public static void main(String[] args) {
		// construct the shared object
		SimpleArraySinchronized sharedSimpleArray = new SimpleArraySinchronized(6);
		
		// crate two tasks to write to the shared SimpleArray
		ArrayWriterSynchronized writer1 = new ArrayWriterSynchronized(1, sharedSimpleArray);
		ArrayWriterSynchronized writer2 = new ArrayWriterSynchronized(11, sharedSimpleArray);
		
		// execute the tasks with an ExecutorService
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(writer1);
		executorService.execute(writer2);
		
		executorService.shutdown();
		
		try {
			// Wait for 1 minute for both writers to finis executing
			boolean tasksEnded = executorService.awaitTermination(1, TimeUnit.MINUTES);
			
			if (tasksEnded) {
				System.out.printf("%nContents of SimpleArray:%n");
				System.out.println(sharedSimpleArray);
			}
			else {
				System.out.println("Timed out while waiting for tasks to finish.");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
