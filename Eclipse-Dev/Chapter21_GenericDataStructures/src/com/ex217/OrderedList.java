package com.ex217;
import com.ex217.SortedList;
import java.security.SecureRandom;

public class OrderedList {
	
	public static void main(String[] args) {
		SecureRandom rand = new SecureRandom();
		SortedList<Integer> list = new SortedList<Integer>();
		
		for (int i = 0; i < 25; i++) {
			list.insertAtFront(rand.nextInt(100) + 1);
		}
		
		// display list
		list.print();
		
		list.mergeSort()
	}

}
