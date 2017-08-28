package com.ex219;

public class SortedList<T extends Comparable<T>> {

	private ListNode<T> firstNode;
	private ListNode<T> lastNode;
	private String name; // string like "list" used in printing
	
	// C-tor creates empty list with "list" as the name
	
	public SortedList() {
		this("list");
	}
	
	// C-tor creates an empty list with a name
	public SortedList(String listName) {
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
	
	// Check if list is empty
	public boolean isEmpty() {
		return firstNode == null; // return true if list is empty
	}
	
	// Print all elements in the list
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
	
	// Publicly visible sort method. Uses merge sort.
	public void sort() {
		mergeSort(firstNode);
	}
	
	
	// Use merge sort to break up the list
	private ListNode<T> mergeSort(ListNode<T> head) {
		// Base case, if head is null
		if (head == null || head.nextNode == null)
			return head;
		
		// get the middle of the list
		ListNode<T> leftToMiddle= getMiddle(head);
		ListNode<T> middleToRight = leftToMiddle.nextNode;
		
		// Set the next of middle node to null ????
		leftToMiddle.nextNode = null;
		
		// Apply mergeSort on left list
		ListNode<T> left = mergeSort(head);
		
		// Apply mergetSort to right list
		ListNode<T> right = mergeSort(middleToRight);
		
		ListNode<T> sortedList = sortedMerge(left, right);
		return sortedList;
	}
	
	// merge two nodes
	private ListNode<T> sortedMerge (ListNode<T> a, ListNode<T> b) {
		// temprary node that will contain the return value
		ListNode<T> result = null;
		
		// base case
		if (a == null)
			return b;
		else if (b == null)
			return a;
		
		// check if node a data is higher or lower then node b data
		if (a.data.compareTo(b.data) <  0) {
			result = a;
			result.nextNode = sortedMerge(a.nextNode, b);
		}
		else if (a.data.compareTo(b.data) >  0) {
			result = b;
			result.nextNode = sortedMerge(a, b.nextNode);
		}
		
		return result;
	}
	
	// Utility function to get the middle of the linked list
	private ListNode<T> getMiddle (ListNode<T> head) {
		// Base case
		if (head == null)
			return head;
		
		// the fast pointer will go twice as fast as the slow pointer
		// slow pointer will point to the middle of the list
		ListNode<T> fastPointer = head.nextNode;
		ListNode<T> slowPointer = head;
		
		// continue while you reach the end of the list
		while (fastPointer != null) {
			fastPointer = fastPointer.nextNode;
			
			// if next pointer is not the end of the list 
			// increment the slow and fast pointers
			if (fastPointer != null) {
				slowPointer = slowPointer.nextNode;
				fastPointer = fastPointer.nextNode;
			}
		}
		
		return slowPointer;
	}
	
	private ListNode<T> reverseHelper (ListNode<T> head) {
		ListNode<T> result = null;
		
		if (head == null)
			return head;
		
		result = head.nextNode;

		result.nextNode = reverseHelper(result);
		return result;
	}
	
	
	public void reverse() {
		reverseHelper(firstNode);
	}
}









