package com.ex2119;

import java.util.Queue;
import java.util.LinkedList;

public class Tree<T extends Comparable<T>> {

	private TreeNode<T> root;
	
	public Tree() {
		root = null;
	}
	
	public TreeNode<T> getRoot() {
		return root;
	}

	public int getDepth(TreeNode<T> node) {
		if (node == null) 
			return 0;
		else
		  return Math.max(getDepth(node.getLeftNode()), getDepth(node.getRightNode())) + 1	;
	}
	
	public int getHeightIterative(TreeNode<T> node) {
		// Base case
		if (node == null)
			return 0;
		
		// Create an empty queue for level order traversal
		Queue<TreeNode<T>> queue = new LinkedList();
		
		// Enqueue root and initialize height
		queue.add(node);
		int height = 0;
		
		while (true) {
			// nodeCount (queue size) indicates number of nodes
			// at current level
			int nodeCount = queue.size();
			if (nodeCount == 0)
				return height;
			else
				height++;
			
			// Dequeue all nodes of current level and Enqueue all nodes of 
			// next level
			while (nodeCount > 0) {
				TreeNode<T> newNode = queue.poll();
				if (newNode.getLeftNode() != null)
					queue.add(newNode.getLeftNode());
				else if (newNode.getRightNode() != null)
					queue.add(newNode.getRightNode());
				
				nodeCount--;
			}
		}
	}
	
	public int getHeight(TreeNode<T> node) {
		if (node == null) {
	        return -1;
	    }

	    int lDepth = getHeight(node.getLeftNode());
	    int rDepth = getHeight(node.getRightNode());

	    if (lDepth > rDepth) {
	        return lDepth + 1;
	    } else {
	        return rDepth + 1;
	    }
	}
	
	public void insertNode(T insertValue) {
		if (root == null)
			root = new TreeNode<T>(insertValue);
		else
			root.insert(insertValue);
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
