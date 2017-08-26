package com.ex216;
import com.figLinkedList.List;

public class ListConcatTest {

	public static void main(String[] args) {
		List<Integer> list1 = new List<>();
		List<Integer> list2 = new List<>();
		
		// insert integers in list1
		list1.insertAtFront(1);
		list1.insertAtFront(2);
		list1.insertAtBack(3);
		list1.insertAtBack(4);
		
		// insert integers in list2
		list2.insertAtFront(5);
		list2.insertAtFront(6);
		list2.insertAtBack(7);
		list2.insertAtBack(8);
		
		ListConcatenate.concatenate(list1, list2);
		list1.print();
	}

}
