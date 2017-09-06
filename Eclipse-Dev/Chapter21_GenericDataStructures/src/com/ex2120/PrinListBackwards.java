package com.ex2120;

public class PrinListBackwards {

	public static void main(String[] args) {

		List<Integer> list = new List<Integer>();
		
		
		list.insertAtBack(10);
		list.insertAtBack(20);
		list.insertAtBack(30);
		
		System.out.println("Print list backwards, using recursion");
		list.printListBackwards();
		
		list.insertAtPosition(list.getFirstNode(), 5);
		list.print();
	}

}
