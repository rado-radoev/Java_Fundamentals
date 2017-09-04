package com.ex2116;

//https://stackoverflow.com/questions/16727871/bst-with-duplicates

public class TreeNode<T extends Comparable<T>> {

	// package access members
	TreeNode<T> leftNode; // left node
	TreeNode<T> rightNode; // right node
	T nodeData; // node value
	int count; // number of value occurrences

	// c-tor that initializes data and makes this a leaf node
	public TreeNode(T nodeData) {
		this.nodeData = nodeData;
		leftNode = rightNode = null;
		count++;
	}
	
	/*Insert duplicates by putting lowest value to the right*/
	public void insert(T insertValue) {
		if (insertValue.compareTo(nodeData) < 0) {
			// insert new TreeNode
			if (leftNode == null)
				leftNode = new TreeNode<T>(insertValue);
			else
				leftNode.insert(insertValue);
		}
		else if (insertValue.compareTo(nodeData) >= 0) {
			// insert new TreeNode
			if (rightNode == null)
				rightNode = new TreeNode<T>(insertValue);
			else
				rightNode.insert(insertValue);
		}
	}
	
	
	/*Insert duplicates by putting lowest value to the left
	public void insert(T insertValue) {
		if (insertValue.compareTo(nodeData) <= 0) {
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
	}
	*/
	
	/*Insert duplicates by counting occurrences
	// locate insertion point and insert new node. Includes the number of occurrances
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
	*/

}
