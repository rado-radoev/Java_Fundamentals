package com.ex2129;

public class IndexedListTest {

	public static void main(String[] args) {
		IndexedList<String> list = new IndexedList<String>();
		
		list.insertInIndexedList("Hasan");
		list.insertInIndexedList("Petkan");
		list.insertInIndexedList("Viktor");
		list.insertInIndexedList("Radoev");
		list.insertInIndexedList("Gosho");
		list.insertInIndexedList("Losho");
		list.insertInIndexedList("Mosho");
		list.insertInIndexedList("Posho");
		list.insertInIndexedList("Tosho");
		list.insertInIndexedList("Misho");
		
		list.print();
		System.out.println();

		list.deleteFromIndexedList("Mosho");
		list.print();
		System.out.println();
	}

}
