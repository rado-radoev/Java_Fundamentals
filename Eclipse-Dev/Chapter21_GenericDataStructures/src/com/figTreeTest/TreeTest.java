package com.figTreeTest;

import java.security.SecureRandom;
import com.figTree.Tree;

public class TreeTest {

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<Integer>();
		SecureRandom randomNumber = new SecureRandom();
		
		System.out.println("Inserting the following values: ");
		
		// insert 10 random integers from 0-99 tree
		for (int i = 1; i <= 10; i++) {
			int value = randomNumber.nextInt(100);
			System.out.printf("%d ", value);
			tree.insertNode(value);
		}
		
		System.out.printf("%n%nPreoder traversal%n");
		tree.preorderTraversal();
		System.out.printf("%n%nInorder traversal%n");
		tree.inorderTraversal();
		System.out.printf("%n%nPostorder traversal%n");
		tree.postorderTraversal();
	}

}
