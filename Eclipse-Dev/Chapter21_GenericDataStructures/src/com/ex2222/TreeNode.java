package com.ex2222;

public class TreeNode<T extends Comparable<T>> {
	
	/**
	 * Class members
	 */
	private TreeNode<T> leftNode;
	private TreeNode<T> rightNode;
	private T data;
	
	/**
	 * TreeNode Constructor
	 * @param data Node data
	 */
	public TreeNode(T data) {
		this.data = data;
		leftNode = rightNode = null;
	}
	
	/**
	 * Data attribute getter
	 * @return the data object for the specific node
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * Get left Node
	 * @return the left node object
	 */
	public TreeNode<T> getLeftNode() {
		return leftNode;
	}
	
	/**
	 * Get right Node
	 * @return the right node object
	 */
	public TreeNode<T> getRightNode() {
		return rightNode;
	}
	
	/**
	 * Data attribute setter
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * Set left Node
	 */
	public void setLeftNode(TreeNode<T> leftNode) {
		this.leftNode = leftNode;
	}
	
	/**
	 * Set right Node
	 */
	public void setRightNode(TreeNode<T> rightNode) {
		this.rightNode = rightNode;
	}
	
	/**
	 * Insert node in the tree. Do not allow duplicates
	 * @param insertValue The value to be inserted in the tree
	 */
	public void insert(T insertValue) {
		// if the inserted value is less then the node value
		if (insertValue.compareTo(data) < 0) {
			// if a left node does not exist
			if (leftNode == null)
				// create a left node and assign the new value to it
				leftNode = new TreeNode<T>(insertValue);
			else
				// if the node exists, keep digging down 
				leftNode.insert(insertValue);
		} // if the inserted value is higher then the node value
		else if (insertValue.compareTo(data) > 0) {
			// if the right node does not exist
			if (rightNode == null)
				rightNode = new TreeNode<T>(insertValue);
			else // if the the node exists, keep digging down
				rightNode.insert(insertValue);
		}
	}

}
