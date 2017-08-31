package com.StackComposition;
import com.figLinkedList.EmptyListException;
import com.figLinkedList.List;
import com.figLinkedList.ListNode;

public class StackComposition<T> {

	private List<T> stackList;
	
	// constructor
	public StackComposition() {
		stackList = new List<T>("Stack");
	}

	// add object to stack
	public void push(T object) {
		stackList.insertAtFront(object);
	}
	
	// removed object from stack
	public T pop() throws EmptyListException {
		return stackList.removeFromFront();
	}
	
	
	// determine if stack is empty
	public boolean isEmpty() {
		return stackList.isEmpty();
	}
	
	public void print() {
		stackList.print();
	}
	
	public T peek() {
		if (stackList.isEmpty())
			return null;
		else
			return stackList.getFirstNode();
	}
}
