package com.ex2126;

public class ListNode<T extends Comparable<T>> {

	ListNode<T> nextNode;
	T data;
	
	public ListNode(T data) {
		this(data, null);
	}
	
	public ListNode(T data, ListNode<T> nextNode) {
		this.data = data;
		this.nextNode = nextNode;
	}
	
	T getData() {
		return data;
	}
	
	ListNode<T> getNext() {
		return nextNode;
	}
	
}
