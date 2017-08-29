package com.ex2111;

// Class to respresent one node in a list
public class ListNode <T> {

	// package access members: List can access these directly
	T data; // data for this node
	ListNode<T> nextNode; // reference to the next node in the list
	
	// C-tor creates a ListNode that refers to object
	ListNode(T object) {
		this(object, null);
	}
	
	// C-tor creates ListNode that refers to the specified object
	// and to the next ListNode
	ListNode(T object, ListNode<T> node) {
		data = object;
		nextNode = node;
	}
	
	// return reference to data in node
	T getData() {
		return data;
	}
	
	// return reference to next node in list
	ListNode<T> getNext() {
		return nextNode;
	}
} // end class ListNode
