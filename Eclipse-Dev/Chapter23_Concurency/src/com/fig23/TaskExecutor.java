package com.fig23;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class TaskExecutor {

	public static void main(String[] args) {
		// craete and name each runnable
		PrintTask task1 = new PrintTask("Task 1");
		PrintTask task2 = new PrintTask("Task 2");
		PrintTask task3 = new PrintTask("Task 3");
	
	
		System.out.println("Starting executor");
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		// start the three PrintTasks;
		executorService.execute(task1);
		executorService.execute(task2);
		executorService.execute(task3);
		
		// shut down Executor service - it decides when to shut down threads
		executorService.shutdown();
		
		System.out.printf("Tasks started, main ends%n%n");
	}
}
