package com.ex2124;

public class Tree<T extends Comparable<T>> {

	private TreeNode<T> root;
	private Queue<TreeNode<T>> queue;
	
	public Tree() {
		root = null;
		queue = new Queue<TreeNode<T>>();
	}
	
	public void insertNode(T value) {
		if (root == null)
			root = new TreeNode<T>(value);
		else
			root.insert(value);
	}
	
	public void levelOrder() {
		if (root == null)
			return;
		
		queue.enqueue(root);
		
		while (queue.size() > 0) {
			TreeNode<T> currentNode = queue.dequeue();
			System.out.printf("%s ", currentNode.data);
			
			if (currentNode.leftNode != null)
				queue.enqueue(currentNode.leftNode);
			
			if (currentNode.rightNode != null)
				queue.enqueue(currentNode.rightNode);
		}
	}
}
