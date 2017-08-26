package com.ex216;
import com.figLinkedList.List;
import com.figLinkedList.EmptyListException;


public class ListConcatenate {
	
	public static <T> List<T> concatenate(List<T> list1, List<T> list2) {
		if (list1.isEmpty())
			return list2;
		else if (list2.isEmpty())
			return list1;
		else {
			try {
				while (true)
					list1.insertAtBack(list2.removeFromFront());
			}
			catch (EmptyListException ele) {
				return list1;
			}
		}
	}
}
