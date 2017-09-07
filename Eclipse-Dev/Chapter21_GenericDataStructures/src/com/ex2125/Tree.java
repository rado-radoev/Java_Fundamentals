package com.ex2125;

import java.util.Comparator;

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
	
	public T minValue(T data) {
		if (root == null)
			return null;
		
		T curVal = root.data;
		T left = minValue(root.leftNode.data);
		T right = minValue(root.rightNode.data);
		
		T lrMin = left.compareTo(right) < 0 ? left : right;
		
		T min = curVal.compareTo(lrMin) < 0 ? curVal : lrMin;
		
		return min;
		
	}
	
	public void outputTree() {
		
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
