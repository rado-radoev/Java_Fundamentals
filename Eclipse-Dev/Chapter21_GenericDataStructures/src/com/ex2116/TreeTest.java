package com.ex2116;

import java.security.SecureRandom;

public class TreeTest {

	public static void main (String[] args) {
		Tree<Integer> tree = new Tree<Integer>();
		SecureRandom rand = new SecureRandom();
		
		System.out.println("Inserting the following values: ");
		
		// insert 10 random  integers from 0-99 in tree
		for (int i = 0; i <= 10; i++) {
			int value = rand.nextInt(10);
			System.out.printf("%d ", value);
			tree.insertNode(value);
		}
		
		System.out.println("\nPreoder traversal");
		tree.preorderTraversal();
		
		System.out.println("\nPostorder traversal");
		tree.postorderTraversal();
		
		System.out.println("\nInorder traversal");
		tree.inorderTraversal();
	}
}
