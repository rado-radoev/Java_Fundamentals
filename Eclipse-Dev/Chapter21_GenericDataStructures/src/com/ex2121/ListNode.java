package com.ex2121;

public class ListNode<T> {

	T data;
	ListNode<T> nextNode;
	
	public ListNode(T data) {
		this(data, null);
	}
	
	public ListNode(T data, ListNode<T> node) {
		this.data = data;
		nextNode = node;
	}
	
	T getData() {
		return data;
	}
	
	ListNode<T> getNext() {
		return nextNode;
	}
}
