package com.ex2129;

public class ListNode<T> {

	ListNode<T> nextNode;
	T data;
	T index;
	
	public ListNode(T data, T index) {
		nextNode = null;
		this.data = data;
		this.index = index;
	}
	
	public T getData() {
		return data;
	}
	
	public T getIndex() {
		return index;
	}
}
