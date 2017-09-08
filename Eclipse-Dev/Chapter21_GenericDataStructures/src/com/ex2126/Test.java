package com.ex2126;

public class Test {

	public static void main(String[] args) {
		List<Integer> list = new List<Integer>();
		
		list.insertAtBack(10);
		list.insertAtBack(20);
		list.insertAtBack(30);
		list.insertAtBack(40);
		list.insertAtBack(50);
		list.insertAtBack(60);
		list.insertAtBack(70);
		list.insertAtBack(80);
		list.insertAtBack(90);
		list.insertAtBack(100);
		
		list.print();
		System.out.println();
		list.deleteNode(60);
		System.out.println();
		list.print();
	}
}
