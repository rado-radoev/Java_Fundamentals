package com.ex2119;

// http://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
// http://www.geeksforgeeks.org/iterative-method-to-find-height-of-binary-tree/

import java.security.SecureRandom;

public class TreeTest {

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<Integer>();
		SecureRandom rnd = new SecureRandom();
		
		for (int i = 0; i <= 100; i++) {
			tree.insertNode(rnd.nextInt(500));
		}
		
		for (int i = 0; i <= 20; i++) {
			tree.insertNode(rnd.nextInt(900));
		}
		
		System.out.println("Tree height: " + tree.getHeight(tree.getRoot()));
		System.out.println("Tree depth: " + tree.getDepth(tree.getRoot()));
		System.out.println("Tree height(iterative): " + tree.getHeightIterative(tree.getRoot()));
	}

}
