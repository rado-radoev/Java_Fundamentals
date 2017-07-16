package com.ex1617;

// insert elements in a linkedlist in sorted order


import java.util.List;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Arrays;

public class SortedLList {

	public static void main(String[] args) {
		Random rnd = new Random(System.currentTimeMillis());
		Integer[] randoms = new Integer[25];
		int sum = 0;
		for (int i = 0; i < randoms.length;i++) {
			randoms[i] = rnd.nextInt(101);
			sum += randoms[i];
		}
		
		
		LinkedList<Integer> list = new LinkedList<>(Arrays.asList(randoms));
		System.out.println("Before sorting the list: " + list);
		Collections.sort(list);
		System.out.println("After sorting the list: " + list);
		System.out.println("The list elements total: " + sum);
		System.out.println("The avertage of the elements in the list: " + (sum / list.size()));
	}

}
