package com.ex2130;

import com.figLinkedList.List;

public class QueueInheritance<T> extends List<T> {

	public QueueInheritance() {
		super("Queue inheritance");
	}
	
	public void enqueue(T object) {
		insertAtBack(object);
	}
	
	public T dequeue() {
		return removeFromFront();
	}
	


}
