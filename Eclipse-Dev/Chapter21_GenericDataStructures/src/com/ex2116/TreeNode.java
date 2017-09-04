package com.ex2116;

public class TreeNode<T extends Comparable<T>> {

	// package access members
	TreeNode<T> leftNode; // left node
	TreeNode<T> rightNode; // right node
	T nodeData; // node value
	int count; // number of value occurances

	// c-tor that initializes data and makes this a leaf node
	public TreeNode(T nodeData) {
		this.nodeData = nodeData;
		leftNode = rightNode = null;
		count++;
	}
	
	// locate insertion point and insert new node. Should include duplicates
	public void insert(T insertValue) {
		// insert in left subtree
		if (insertValue.compareTo(nodeData) < 0) {
			// insert new TreeNode
			if (leftNode == null)
				leftNode = new TreeNode<T>(insertValue);
			else
				leftNode.insert(insertValue);
		}
		else if (insertValue.compareTo(nodeData) > 0) {
			// insert new TreeNode
			if (rightNode == null)
				rightNode = new TreeNode<T>(insertValue);
			else
				rightNode.insert(insertValue);
		}
		else {
			count++;
		}	
	}

}
