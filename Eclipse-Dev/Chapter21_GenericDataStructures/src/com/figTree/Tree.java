package com.figTree;

public class Tree<T extends Comparable<T>> {

	private TreeNode<T> root;
		
	// constructor that initializes an empty Tree of Integers
	public Tree() {
		root = null;
	}
	
	// insert a new node in the binary search tree
	public void insertNode(T insertValue) {
		if (root == null)
			root = new TreeNode<T>(insertValue); // create a new root(parent) node
		else
			root.insert(insertValue); // call the TreeNode insert method until an empty node is found
	}
	
	// begin preorder traversal
	public void preorderTraversal() {
		preorderHelper(root);
	}
	
	// recurvise method to perform preorder traversal
	private void preorderHelper(TreeNode<T> node) {
		if (node == null)
			return;
		
		System.out.printf("%s ", node.data); 	// output node data
		preorderHelper(node.leftNode); 	// traverse left subtree
		preorderHelper(node.rightNode);	// traverse right subtree
	}
	
	// begin inorder traversal
	public void inorderTraversal() {
		inorderHelper(root);
	}
	
	// recursive method to perform inorder traversal
	private void inorderHelper(TreeNode<T> node) {
		if (node == null)
			return;
		
		inorderHelper(node.leftNode);  // traverse left subtree
		System.out.printf("%s ", node.data);   // output node data
		inorderHelper(node.rightNode);   // traverse right subtree
	}
	
	// begin postorder traversal
	public void postorderTraversal() {
		postorderHelper(root);
	}
	
	// recursive method to perform posorder traversal
	private void postorderHelper(TreeNode<T> node) {
		if (node == null)
			return;
		
		postorderHelper(node.leftNode); // traverse left subtree
		postorderHelper(node.rightNode);  // traverse right subtree
		System.out.printf("%s ", node.data); // output node data
	}
}















