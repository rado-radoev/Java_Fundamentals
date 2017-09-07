package com.ex2222;

public class Tree<T extends Comparable<T>> {

	private TreeNode<T> root;
	
	public Tree() {
		root = null;
	}
	
	public TreeNode<T> getRoot() {
		return root;
	}
	
	public TreeNode<T> delete(TreeNode<T> node, T data) {
		if (node == null)
			return node;
		else if (data.compareTo(node.getData()) < 0) {
			node.setLeftNode(delete(node.getLeftNode(), data));
		}
		else if (data.compareTo(node.getData()) > 0) {
			node.setRightNode(delete(node.getRightNode(), data));
		}
		else {
			// Case 1: No child
			if (node.getLeftNode() == null && node.getRightNode() == null) {
				node = null;
			}
			// Case 2: One child
			else if (node.getLeftNode() == null) {
				TreeNode<T> temp = node;
				node = node.getRightNode();
				temp = null;
			}
			else if (node.getRightNode() == null) {
				TreeNode<T> temp = node;
				node = node.getLeftNode();
				temp = null;
			}
			// Case 3: 2 children
			else {
				TreeNode<T> temp = findMin(node.getRightNode());
				node.setData(temp.getData());
				node.setRightNode(delete(node.getLeftNode(), temp.getData()));
			}
		}
		return node;
	}
	
	private TreeNode<T> findMin(TreeNode<T> node) {
		TreeNode<T> current = node;
		
		while (node.getLeftNode() != null) {
			current = current.getLeftNode();
		}
		
		return current;
	}
	
	public TreeNode<T> searchNode(TreeNode<T> node, T data) {
		if (node == null)
			return null;
		
		if (node.getData() == data)
			return node;
		
		if (node.getData().compareTo(data) < 0)
			return searchNode(node.getRightNode(), data);
		else
			return searchNode(node.getLeftNode(), data);
	}
	
	public T contains(TreeNode<T> node, T data) {
		if (node == null)
			return null;
		
		if (node.getData().compareTo(data) < 0)
			return contains(node.getRightNode(), data);
		else if (node.getData().compareTo(data) > 0)
			return contains(node.getLeftNode(), data);
		else
			return node.getData();
	}
	
	public void insertNode(T insertValue) {
		if (root == null)
			root = new TreeNode<T>(insertValue);
		else
			root.insert(insertValue);
	}
	
	public int getDepth(TreeNode<T> node) {
		if (node == null)
			return 0;
		
		return Math.max(getDepth(node.getLeftNode()), getDepth(node.getRightNode())) + 1;
	}
	
	public int getHeight(TreeNode<T> node) {
		if (node == null)
			return -1;
		
		int lDepth = getHeight(node.getLeftNode());
		int rDepth = getHeight(node.getRightNode());
		
		if (lDepth > rDepth)
			return lDepth + 1;
		else
			return rDepth + 1;
	}
	
	// preorder traversal
	public void preorderTraversal() {
		preorderHelper(root);
	}
	
	private void preorderHelper(TreeNode<T> node) {
		if (node == null)
			return;
		
		System.out.printf("%s ", node.getData());
		preorderHelper(node.getLeftNode());
		preorderHelper(node.getRightNode());
	}
	
	// postorder traversal
	public void postorderTraversal() {
		postorderHelper(root);
	}
	
	private void postorderHelper(TreeNode<T> node) {
		if (node == null)
			return;
		
		postorderHelper(node.getLeftNode());
		postorderHelper(node.getRightNode());
		System.out.printf("%s ", node.getData());
	}
	
	// inorder traversal
	public void inorderTraversal() {
		inorderHelper(root);
	}
	
	private void inorderHelper(TreeNode<T> node) {
		if (node == null)
			return;
		
		inorderHelper(node.getLeftNode());
		System.out.printf("%s ", node.getData());
		inorderHelper(node.getRightNode());
	}
}
