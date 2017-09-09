package com.ex2129;

public class List<T extends Comparable<T>> {

	// take a look a this; http://www.chegg.com/homework-help/indexed-lists-presented-text-linked-lists-must-searched-sequ-chapter-22-problem-29e-solution-9780136023395-exc
	
	private ListNode<T> firstNode;
	private ListNode<T> lastNode;
	private int size;
	
	public List() {
		super();
		firstNode = lastNode = null;
	}
	
	public int getSize() {
		return size;
	}
	
	public ListNode<T> getFirstNode() {
		return firstNode;
	}

	public ListNode<T> getLastNode() {
		return lastNode;
	}

	public void insertAtFront(T value) {
		if (isEmpty())
			firstNode = lastNode = new ListNode<T>(value);
		else
			firstNode = new ListNode<T>(value, firstNode);
		size++;
	}
	
	public void insertAtBack(T value) {
		if (isEmpty())
			firstNode = lastNode = new ListNode<T>(value);
		else
			lastNode = lastNode.nextNode = new ListNode<T>(value);
		size++;
	}
	
	public void deleteNode(ListNode<T> node) {
		ListNode<T> currentNode = firstNode;
		ListNode<T> previousNode = currentNode;
		
		while (currentNode != null) {		

			if (currentNode == node) {
				previousNode.nextNode = currentNode.nextNode;
				size--;
			}
			
			previousNode = currentNode;
			currentNode = currentNode.nextNode;
		}
	}
	
	public void deleteNode(T value) {
		ListNode<T> currentNode = firstNode;
		ListNode<T> previousNode = currentNode;
		
		while (currentNode != null) {		

			if (currentNode.data.compareTo(value) == 0) {
				previousNode.nextNode = currentNode.nextNode;
				size--;
			}
			
			previousNode = currentNode;
			currentNode = currentNode.nextNode;
		}
	}
	
	public T search(ListNode<T> node, T value) {
		if (firstNode == null)
			return null;
		
		if (firstNode.data.compareTo(value) == 0)
			return firstNode.data;
		else
			return search(node.nextNode, value);
		
	}
	
	public boolean isEmpty() {
		return firstNode == null;
	}
	
	public void print()	{
		ListNode<T> currentNode = firstNode;
		
		while(currentNode != null) {
			System.out.printf("%s ", currentNode.data);
			currentNode = currentNode.nextNode;
		}
	}
}
