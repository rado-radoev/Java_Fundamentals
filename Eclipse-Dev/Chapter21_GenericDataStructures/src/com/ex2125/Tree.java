package com.ex2125;


public class Tree<T extends Comparable<T>> {

	private TreeNode<T> root;
	private Queue<TreeNode<T>> queue;
	
	public Tree() {
		root = null;
		queue = new Queue<TreeNode<T>>();
	}
	
	public TreeNode<T> getRoot() {
		return root;
	}
	
	public void insertNode(T value) {
		if (root == null)
			root = new TreeNode<T>(value);
		else
			root.insert(value);
	}
	
	public T minValue() {
		return minValue(root).data;
	}
	
	private TreeNode<T> minValue(TreeNode<T> node) {
		if (node == null)
			return null;
		
		T value = node.data;
		TreeNode<T> left = minValue(node.leftNode);
		
		TreeNode<T> minNode = left.data.compareTo(value) < 0 ? left : node;
		
		return minNode;
		
	}
	
	
	
	public void outputTree(TreeNode<T> node, int totalSpaces) {
		while (node != null) {
			outputTree(node.rightNode, totalSpaces + 5);  // traverse right subtree 
			
			for (int i = 1; i <= totalSpaces;i++)
				System.out.printf(" ");
			
			System.out.printf("%s%n", node.data);   // output node data

			node = node.leftNode;
			totalSpaces += 5;		
		}
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
