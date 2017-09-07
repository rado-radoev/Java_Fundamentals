package com.ex2122;

// watch this: https://www.youtube.com/watch?v=gcULXE7ViZw
// http://www.geeksforgeeks.org/find-the-minimum-element-in-a-binary-search-tree/
// http://www.geeksforgeeks.org/find-maximum-or-minimum-in-binary-tree/
// http://www.geeksforgeeks.org/binary-search-tree-set-2-delete/

import java.security.SecureRandom;

public class BinaryTreeDelete {

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<Integer>();
		SecureRandom rnd = new SecureRandom();
		
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
		
//		System.out.printf("%s%n", tree.searchNode(tree.getRoot(), 20));
//		System.out.printf("%s%n", tree.search(tree.getRoot(), 20));
		tree.inorderTraversal();
		System.out.println();
		tree.delete(tree.getRoot(), 7);
		tree.inorderTraversal();
	}

}
