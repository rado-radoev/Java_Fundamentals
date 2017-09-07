package com.ex2124;

import com.figLinkedList.List;
import com.figLinkedList.EmptyListException;

public class Queue<T> {

	private List<T> queueList;
	private static int size;
	
	public Queue() {
		queueList = new List<T>();
	}
	
	public int size() {
		return size;
	}
	
	public void enqueue(T object) {
		queueList.insertAtBack(object);
		size++;
	}
	
	public T dequeue() throws EmptyListException {
		size--;
		return queueList.removeFromFront();
	}
	
	public T peek() throws EmptyListException {
		return queueList.getFirstNode();
	}
	
	public boolean isEmpty() {
		return queueList.isEmpty();
	}
	
	public void print() {
		queueList.print();
	}
}
