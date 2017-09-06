package com.ex2120;

public class List<T> {
	
	// private class members for first and last list nodes
	private ListNode<T> firstNode;
	private ListNode<T> lastNode;
	
	// constructor setting first and last node to null
	public List() {
		super();
		firstNode = lastNode = null;
	}

	// getters and setters for first and last Node
	public ListNode<T> getFirstNode() {
		return firstNode;
	}
	
	public void setFirstNode(ListNode<T> firstNode) {
		this.firstNode = firstNode;
	}
	
	public ListNode<T> getLastNode() {
		return lastNode;
	}
	
	public void setLastNode(ListNode<T> lastNode) {
		this.lastNode = lastNode;
	}
	
	public void insertAtFron(T insertItem) {
		if (isEmpty()) // if first and last node are the same, only one node is in the list
			setFirstNode(new ListNode<T>(insertItem));
			
	}
	
	/**
	 * Check if list is empty
	 * @return ture if list is empty, false if list is not empty
	 */
	public boolean isEmpty() {
		return getFirstNode() == null;
	}

}
