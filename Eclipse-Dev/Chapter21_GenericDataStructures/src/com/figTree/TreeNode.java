package com.figTree;

//Class TreeNode definition
public class TreeNode<T extends Comparable<T>> {

	// package access members
	TreeNode<T> leftNode;
	TreeNode<T> rightNode;
	T data;	// node value
	
	// constructor initializes data and makes this a leaf node
	public TreeNode(T nodeData) {
		data = nodeData;
		leftNode = rightNode = null;	// node has no children
	}
	
	// locate insertion point and insert new node; ignore duplicate values
	public void insert(T insertValue) {
		
		// insert in left subtree
		if (insertValue.compareTo(data) < 0) {
			// insert new TreeNode
			if (leftNode == null) 
				leftNode = new TreeNode<T>(insertValue);
			else // continue traversing left subtree recursively
				leftNode.insert(insertValue);
		}
		// insert in right subtree
		else if (insertValue.compareTo(data) > 0) {
			
			// insert new tree node
			if (rightNode == null)
				rightNode = new TreeNode<T>(insertValue);
			else // continue traversing right subtree recursively
				rightNode.insert(insertValue);
		}
	}
}
 