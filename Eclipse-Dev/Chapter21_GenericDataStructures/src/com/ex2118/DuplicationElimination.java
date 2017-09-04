package com.ex2118;

import java.security.SecureRandom;

public class DuplicationElimination {

	public static void main(String[] args) {
		SecureRandom rnd = new SecureRandom();
		Tree<Integer> newTree = new Tree<Integer>();
		int[] arr = new int[5000000];
		ArrayTest array = new ArrayTest(arr);
		
		long start;
		long end;
		long timing;
		
		start = System.nanoTime();
		for (int i = 0; i <= 5000000; i++) {
			newTree.insertNode(rnd.nextInt(100) + 1);
		}
		end = System.nanoTime();
		
		timing = (end - start) / 1000000;
		System.out.print("The binary tree took: " + timing + " miliseconds\n");
		
		
		for (int i = 0; i <5000000; i++) {
			arr[i] = rnd.nextInt(100) + 1;
		}
		
		start = 0;
		end = 0;
		timing = 0;
	
		start = System.nanoTime();
		array.removeDuplicates();
		end = System.nanoTime();
		
		timing = (end - start) / 1000000;
		System.out.print("The array took: " + timing + " miliseconds\n");
	}
}
