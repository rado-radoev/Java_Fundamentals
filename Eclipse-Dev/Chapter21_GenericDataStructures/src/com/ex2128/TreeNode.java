package com.ex2128;

public class TreeNode<T extends Comparable<T>> {

	TreeNode<T> leftNode;
	TreeNode<T> rightNode;
	T data;
	
	public TreeNode(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	public void insert(T value) {
		if (value.compareTo(data) < 0) {
			if (leftNode == null)
				leftNode = new TreeNode<T>(value);
			else
				leftNode.insert(value);
		}
		else if (value.compareTo(data) > 0) {
			if (rightNode == null)
				rightNode = new TreeNode<T>(value);
			else
				rightNode.insert(value);
		}
			 
	}
}
