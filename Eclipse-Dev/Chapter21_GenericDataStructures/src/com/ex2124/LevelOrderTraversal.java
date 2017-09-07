package com.ex2124;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<Integer>();
	
		tree.insertNode(12);
		tree.insertNode(5);
		tree.insertNode(3);
		tree.insertNode(1);
		tree.insertNode(7);
		tree.insertNode(9);
		tree.insertNode(8);
		tree.insertNode(11);
		tree.insertNode(15);
		tree.insertNode(13);
		tree.insertNode(14);
		tree.insertNode(17);
		tree.insertNode(20);
		tree.insertNode(18);
		
		tree.levelOrder();
	}
}
