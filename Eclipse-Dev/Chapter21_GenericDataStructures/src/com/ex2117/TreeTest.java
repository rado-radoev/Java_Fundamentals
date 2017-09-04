package com.ex2117;

public class TreeTest {

	public static void main (String[] args) {
		Tree<String> tree = new Tree<String>();
		
		String str = "This is a test string tokenize it or not it is up to you";
		String[] splitted = str.split("\\s");
		
		for (int i = 0; i < splitted.length; i++) {
			tree.insertNode(splitted[i]);
		}
		
		System.out.println("\nPreoder traversal");
		tree.preorderTraversal();
		
		System.out.println("\nPostorder traversal");
		tree.postorderTraversal();
		
		System.out.println("\nInorder traversal");
		tree.inorderTraversal();
	}
}
