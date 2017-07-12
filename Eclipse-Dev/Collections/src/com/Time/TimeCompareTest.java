package com.Time;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

import javax.naming.TimeLimitExceededException;

import java.util.LinkedList;
import java.util.Collection;
import java.util.Collections;
import java.util.Arrays;

public class TimeCompareTest {

	public static void main(String[] args) {
		
		Time[] times = {new Time(14, 25, 06), new Time(18, 22, 55),
				new Time(16,04,25), new Time(16,30,00), new Time(18,22,55)}; 
		
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

		Collections.sort(timesList, new TimeCompare());
		System.out.println("After running TimeCompare comparator and sorting: " + timesList);
		
		Collections.shuffle(timesList, new Random(System.currentTimeMillis()));
		System.out.println("After shuffeling with random int: " + timesList);
		
		Collections.reverse(timesList);
		System.out.println("After reversing the list" + timesList);
		
		Time[] timesCopy = new Time[times.length];
		List<Time> copyList = Arrays.asList(timesCopy);
		
		Collections.copy(copyList, timesList);
		System.out.println("copied list: " + copyList);
		
		Collections.fill(copyList, new Time());
		System.out.println("CopyList after filled with new time" + copyList);
		
		System.out.println("Min time: " + Collections.min(timesList, new TimeCompare()));
		System.out.println("Max time: " + Collections.max(timesList, new TimeCompare()));
		
		Collections.sort(timesList, new TimeCompare());
		System.out.println("After collection is sorted again: " + timesList);
		
		System.out.println("Perform binary search for time: 18:22:55 and output index: " +
				Collections.binarySearch(timesList, new Time(18,22,55), new TimeCompare()));
		
		Collections.copy(copyList, timesList);
		System.out.println("CopyList copied again: " + copyList);
		
		System.out.println("Does the 2 lists have elements in common: " + 
				(Collections.disjoint(copyList, timesList) ? "they don't" : "they do"));
		
	}
}

















