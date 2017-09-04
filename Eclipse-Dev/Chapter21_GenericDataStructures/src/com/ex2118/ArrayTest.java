package com.ex2118;

public class ArrayTest {
	
	int[] array;
	
	public ArrayTest(int[] array) {
		this.array = array;
	}
	
	public void removeDuplicates() {
		MergeSort.mergeSort(array);
		
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] == array[i + 1]) {
				for (int j = i + 1; j < array.length - 1; j++) {
					array[j] = array[j +1];
				}
			}
		}
	}

}
