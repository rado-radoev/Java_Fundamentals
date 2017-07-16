package com.ex1621;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PirorityQueueTest {

	public static void main(String[] args) {
		// queue of capacity 11
		Queue<Double> queue = new PriorityQueue<>(1, Collections.reverseOrder());
		

		// insert elements into queue
		queue.offer(3.2);
		queue.offer(9.8);
		queue.offer(5.4);
		
		
		// display elements in queue
		while (queue.size() > 0) {
			System.out.println(queue.poll());
			
		}

	}

}
