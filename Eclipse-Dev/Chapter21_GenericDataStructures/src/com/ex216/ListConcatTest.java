package com.ex216;
import com.figLinkedList.List;

public class ListConcatTest {

	public static void main(String[] args) {
		List<Integer> list1 = new List<>();
		List<Integer> list2 = new List<>();
		
		// insert integers in list1
		list1.insertAtFront(-1);
		list1.insertAtFront(0);
		list1.insertAtBack(1);
		list1.insertAtBack(5);
		
		// insert integers in list1
		list2.insertAtFront(-10);
		list2.insertAtFront(1);
		list2.insertAtBack(10);
		list2.insertAtBack(50);
		
		ListConcatenate.concatenate(list1, list2);
		list1.print();
	}

}
