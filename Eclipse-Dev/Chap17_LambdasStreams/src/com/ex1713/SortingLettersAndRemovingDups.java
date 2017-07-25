package com.ex1713;

import java.security.SecureRandom;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SortingLettersAndRemovingDups {

	public static void main(String[] args) {
		
		SecureRandom rnd = new SecureRandom();
		List<Character> list = new ArrayList<Character>();
		
		for (int i = 0; i <= 30; i++) {
			list.add((char) (rnd.nextInt(26) + 97));
		}
		
//		list.stream()
//			.sorted()
//			.forEach(System.out::println);

//		list.stream()
//			.sorted(Comparator.reverseOrder())
//			.forEach(System.out::println);
		
		list.stream()
			.sorted()
			.distinct()
			.forEach(System.out::println);
	}

}
