package com.ex2116;

public class Tree<T extends Comparable<T>> {

	private TreeNode<T> root;
	
	// constructor initializes an empty tree of integers
	public Tree() {
		root = null;
	}
	
	// insert new node in the binary search tree
	public void insertNode(T insertValue) {
		if (root == null)
			root = new TreeNode<T>(insertValue); // create a root node
		else
			root.insert(insertValue); // call the insert method
	}
	
	// preorder traversal
	public void preorderTraversal() {
		preorderHelper(root);
	}
	
	private void preorderHelper(TreeNode<T> node) {
		if (node == null)
			return;
		
		System.out.printf("%s ", node.nodeData);
		preorderHelper(node.leftNode);
		preorderHelper(node.rightNode);
	}
	
	// postorder traversal
	public void postorderTraversal() {
		postorderHelper(root);
	}
	
	private void postorderHelper(TreeNode<T> node) {
		if (node == null)
			return;
		
		postorderHelper(node.leftNode);
		postorderHelper(node.rightNode);
		System.out.printf("%s ", node.nodeData);
	}
	
	// inorder traversal
	public void inorderTraversal() {
		inorderHelper(root);
	}
	
	private void inorderHelper(TreeNode<T> node) {
		if (node == null)
			return;
		
		inorderHelper(node.leftNode);
		System.out.printf("%s ", node.nodeData);
		inorderHelper(node.rightNode);
	}
}
