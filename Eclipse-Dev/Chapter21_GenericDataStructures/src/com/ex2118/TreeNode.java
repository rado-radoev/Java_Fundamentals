package com.ex2118;

public class TreeNode<T extends Comparable<T>> {
	
	TreeNode<T> leftNode;
	TreeNode<T> rightNode;
	T data;
	
	public TreeNode(T data) {
		this.data = data;
		leftNode = rightNode = null;
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