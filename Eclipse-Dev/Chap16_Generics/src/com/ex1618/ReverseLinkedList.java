package com.ex1618;

// copying and reversing linked list

import java.util.LinkedList;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class ReverseLinkedList {

	public static void main(String[] args) {
		Character[] chars = {'a', 'b', 'c', 'd', 'e', 'f' , 'g', 'h', 'i', 'j'};		
		List<Character> list = new LinkedList<>(Arrays.asList(chars));
		
		List<Character> reversedList = new LinkedList<>(list);

		Collections.sort(reversedList, Collections.reverseOrder());
		System.out.println("Before sorting the list: " + list);
		System.out.println("After reversin and coyping the list: " + reversedList);
	}

}
