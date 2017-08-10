package com.ex195;

import java.security.SecureRandom;
import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		SecureRandom sr = new SecureRandom();
		
		int[] array = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = sr.nextInt(20);
		}
		
		System.out.println(Arrays.toString(bubbleSort(array)));
	}
	
	public static int[] bubbleSort(int[] list) {
		for (int i = 0; i < list.length - 1;i++) {
			for (int j = 0; j < list.length - 1 - i;j++) {
				if (list[j] > list[j + 1]) {
					int temp = list[j];
					list[j] = list[j+1];
					list[j + 1] = temp;
				}
			}
		}
		
		return list;
	}

}
