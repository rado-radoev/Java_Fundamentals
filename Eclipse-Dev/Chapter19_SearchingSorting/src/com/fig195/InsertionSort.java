package com.fig195;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] data = {34,56,4,10,77,51,93,30,5,52};
	
		for (int next = 1; next < data.length;next++) {
			int insert = data[next];
			int moveItem = next;
			
			while (moveItem > 0 && data[moveItem - 1] > insert) {
				data[moveItem] = data[moveItem - 1];
				moveItem--;
			}
			
			data[moveItem] = insert;
		}
		
		System.out.println(Arrays.toString(data));
	}

}
