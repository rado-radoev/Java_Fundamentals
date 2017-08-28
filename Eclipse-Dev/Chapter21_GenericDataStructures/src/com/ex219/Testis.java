package com.ex219;
import java.security.SecureRandom;

public class Testis {

	public static void main(String[] args) {
		SecureRandom rand = new SecureRandom();
		SortedList<Integer> list = new SortedList<Integer>();
		
		for (int i = 0; i < 6; i++) {
			list.insertAtFront(rand.nextInt(100) + 1);
		}
		
		list.print();
		list.reverse();
		list.print();
	}
}
