package com.ex2119;

public class TreeNode<T extends Comparable<T>> {
	
	private TreeNode<T> leftNode;
	private TreeNode<T> rightNode;
	private T data;
	
	public TreeNode(T data) {
		this.data = data;
		leftNode = rightNode = null;
	}
	
	public T getData() {
		return data;
	}
	
	public TreeNode<T> getLeftNode() {
		return leftNode;
	}
	
	public TreeNode<T> getRightNode() {
		return rightNode;
	}
	
	public void insert(T insertValue) {
		if (insertValue.compareTo(data) < 0) {
			if (leftNode == null)
				leftNode = new TreeNode<T>(insertValue);
			else 
				leftNode.insert(insertValue);
		}
		else if (insertValue.compareTo(data) > 0) {
			if (rightNode == null)
				rightNode = new TreeNode<T>(insertValue);
			else
				rightNode.insert(insertValue);
		}
	}

}