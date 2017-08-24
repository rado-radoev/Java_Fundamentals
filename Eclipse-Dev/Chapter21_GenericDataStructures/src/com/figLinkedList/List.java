package com.figLinkedList;

public class List<T> {

	private ListNode<T> firstNode;
	private ListNode<T> lastNode;
	private String name; // string like "list" used in printing
	
	// C-tor creates empty list with "list" as the name
	
	public List() {
		this("list");
	}
	
	// C-tor creates an empty list with a name
	public List(String listName) {
		name = listName;
		firstNode = lastNode = null;
	}
	
	// insert item at from of the list
	public void insertAtFront(T insertItem)	{
		if (isEmpty()) // firstNode and lastNode refer to same object
			firstNode = lastNode = new ListNode<T>(insertItem);
		else
			firstNode = new ListNode<T>(insertItem, firstNode);
	}
	
	// insert item at the end of the list
	public void insertAtBack(T insertItem) {
		if (isEmpty()) // first node and last node are the same. meaning there is only one node in the list
			firstNode = lastNode = new ListNode<T>(insertItem);
		else
			lastNode = lastNode.nextNode = new ListNode<T>(insertItem);
	}
	
	// remove first node from list
	public T removeFromFront() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException(name);
	
		T removedItem = firstNode.data; // retrieve data being removed
		
		if (firstNode == lastNode)
			firstNode = lastNode = null;
		else
			firstNode = firstNode.nextNode;
		
		return removedItem;
	}
	
	// remove last node from list
	public T removeFromBack() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException(name);
		
		T removedItem = lastNode.data;
		
		if (firstNode == lastNode)
			firstNode = lastNode = null;
		else {
			ListNode<T> current = firstNode;
			
			// loop while current node des not refer to last node
			while (current.nextNode != lastNode) {
				current = current.nextNode;
			}
			
			lastNode = current;
			current.nextNode = null;
		}
		
		return removedItem;
	}
	
	public boolean isEmpty() {
		return firstNode == null; // return true if list is empty
	}
	
	public void print()	{
		if (isEmpty()) {
			System.out.printf("Empty %s%n", name);
			return;
		}
		
		System.out.printf("The %s is: ", name);
		ListNode<T> current = firstNode;
		
		// while not at the end of the list, output current node's data
		while (current != null) {
			System.out.printf("%s ", current.data);
			current = current.nextNode;
		}
		
		System.out.println();
	}
}









