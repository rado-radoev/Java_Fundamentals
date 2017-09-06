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
	
	/**
	 * Insert Item in the beginning of the list
	 * @param insertItem Item to insert in the front of the list
	 */
	public void insertAtFron(T insertItem) {
		if (isEmpty()) {// if first and last node are the same, only one node is in the list
			firstNode = lastNode = new ListNode<T>(insertItem);
		}
		else {
			firstNode = new ListNode<T>(insertItem, firstNode);
		}
	}
	
	/**
	 * Insert item at the back of the list
	 * @param insertItem Item to insert in the back of the list
	 */
	public void insertAtBack(T insertItem) {
		if (isEmpty()) {
			firstNode = lastNode = new ListNode<T>(insertItem);
		}
		else {
			lastNode = lastNode.nextNode = new ListNode<T>(insertItem);
		}
	}
	
	/**
	 * Remove head of List
	 * @return the item being removed
	 * @throws EmptyListException
	 */
	public T removeFromFront() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException();
		
		T removedItem = firstNode.data; // retrieve the item before removing it
		
		if (firstNode == lastNode)
			firstNode = lastNode = null; // if only one node exists null it
		else
			firstNode = firstNode.nextNode; // else first node becomes the 2nd node
		
		return removedItem;
	}
	
	/**
	 * Remove item from the back of the list
	 * @return removed item
	 * @throws EmptyListException
	 */
	public T removFromBack() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException();
		
		T removedItem = lastNode.data;	// retrieve last item before removing it
		
		if (firstNode == lastNode)
			firstNode = lastNode = null;	// if only one item, null it
		else {
			ListNode<T> currentNode = firstNode; // start from the 1st node
			
			while(currentNode != lastNode) { // loop through all the nodes until the second to last node is reached
				currentNode = currentNode.nextNode; //move one node at a time
			}
			
			lastNode = currentNode; // the last node is assigned the previous node
			currentNode.nextNode = null; // the last node, which is currentNode.nextNode is nulled
		}
		
		return removedItem;
	}
	
	/**
	 * Insert at specific position
	 * @param previousNode position where the new node should be inserted
	 * @param insertItem new node data
	 * @throws NullNodeException
	 */
	public void insertAtPosition(ListNode<T> previousNode, T insertItem) throws NullNodeException {
		// check if previousNode is not null
		if (previousNode == null)
			throw new NullNodeException();
		
		// create the new node to be inserted
		ListNode<T> newNode = new ListNode<T>(insertItem);
		
		// make next of new node, next of previous node
		newNode.nextNode = previousNode.nextNode;
		
		// make previous node next to point to new node
		previousNode.nextNode = newNode;
	}
	
	/**
	 * Print the list backwards
	 */
	public void printListBackwards() {
		printListBackwardsHelper(firstNode);
	}
	
	/**
	 * Helper function that prints the list backwards using recursion
	 * @param node
	 */
	private void printListBackwardsHelper(ListNode<T> node) {
		if (node == null)
			return;

		printListBackwardsHelper(node.nextNode);
		System.out.printf("%s ", node.data);		
	}
	
	/**
	 * Prints all the nodes in the list
	 */
	public void print() {
		if (isEmpty()) {
			System.out.printf("%s%s%n", "The List is empty");
			return;
		}
		else {
			System.out.printf("%n%s%n", "List contains:");
			
			ListNode<T> currentNode = firstNode;
			
			while (currentNode != null) {
				System.out.printf("%s ", currentNode.data);
				currentNode = currentNode.nextNode;
			}
		}
			
	}
	
	
	/**
	 * Check if list is empty
	 * @return ture if list is empty, false if list is not empty
	 */
	public boolean isEmpty() {
		return getFirstNode() == null;
	}

}
