package com.queue;

import java.util.PriorityQueue;

public class Queues {

	public static void main(String[] args) {
		queueTest2();
	}
	
	private static void queueTest2() {
		PriorityQueue<Time> queue = new PriorityQueue<>(new TimeCompare());
		
		queue.offer(new Time(17,05,43));
		queue.offer(new Time());
		queue.offer(new Time(22,37,12));
		queue.offer(new Time(8,26,55));
		
		System.out.printf("%s%n", "Polling from times queue: ");
		
		while (!queue.isEmpty()) {
			System.out.printf("%s ", queue.poll());
			
		}
	}
	
	
	private static void queueTest1() {
		PriorityQueue<Double> queue = new PriorityQueue<>();
		
		queue.offer(3.33);
		queue.offer(5.42);
		queue.offer(0.01);
		queue.offer(58.00);
		
		System.out.println("Polling from queue:");
	
		while (queue.size() > 0) {
			System.out.printf("%.2f ", queue.peek());
			queue.poll();
		}
	}
}
