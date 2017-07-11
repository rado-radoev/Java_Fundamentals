package com.Time;

import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
import java.util.Collection;
import java.util.Collections;
import java.util.Arrays;

public class TimeCompareTest {

	public static void main(String[] args) {
		
		Time[] times = {new Time(14, 25, 06), new Time(18, 22, 55),
				new Time(16,04,25), new Time(16,30,00)}; 
		
		List<Time> timesList = new LinkedList<>(Arrays.asList(times));
		
		System.out.println("Before the shuffle: " + timesList);
		Collections.shuffle(timesList);
		System.out.println("After the shuffle: " + timesList);
		timesList.add(0, new Time(5,5,2));
		System.out.println("After adding tiem to index 0: " + timesList);
		timesList.subList(1, 3).clear();
		System.out.println("After index 1 and 2 are removed: " + timesList);
		Collections.reverse(timesList);
		System.out.println("After list is reversed: " + timesList);
		Collections.swap(timesList, timesList.size() - 1, 0);
		System.out.println("After swapping last and first index: " + timesList);
		Collections.addAll(timesList, new Time(16,21,32));
		System.out.println("After adding another time: " + timesList);

		List<Time> copiedList = new LinkedList<Time>(Arrays.asList());
		Collections.copy(copiedList, timesList);
		System.out.println("New list after copying: " + copiedList);
	}
}
