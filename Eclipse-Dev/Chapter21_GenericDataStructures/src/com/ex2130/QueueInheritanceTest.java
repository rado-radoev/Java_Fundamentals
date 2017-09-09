package com.ex2130;

import com.figLinkedList.EmptyListException;

public class QueueInheritanceTest {

	public static void main(String[] args) {
		QueueInheritance<Integer> queue = new QueueInheritance();
		
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

