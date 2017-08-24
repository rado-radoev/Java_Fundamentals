package com.figQueueTest;
import com.figQueue.Queue;
import com.figLinkedList.EmptyListException;

public class QueueTest {

	public static void main(String[] args) {

		Queue<Integer> queue = new Queue<>();
		
		// use enqueue method
		queue.enqueue(-1);
		queue.print();
		queue.enqueue(0);
		queue.print();
		queue.enqueue(1);
		queue.print();
		queue.enqueue(5);
		queue.print();
		
		// remove objects from queue
		try {
			int removedItem;
			
			while (true) {
				removedItem = queue.dequeue();
				System.out.printf("%n%d dequeue%n", removedItem);
				queue.print();
			}
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
	}

}
