package com.ex197;

import java.security.SecureRandom;

public class BucketSort {

	public static void main(String[] args) {
		int[] list = {1,6,8,2,4,0,9};
		sort(list);
	}
	
	
	public static int[] sort(int[] list) {
		int[][] buckets = new int[10][list.length - 1];
		
		for (int i = 0; i < list.length - 1; i++) {
			buckets[list[i] % 10][0] = list[i];
		}
		
		for (int i = 0; i < list.length - 1; i++) {
			list[i] = buckets[i][0];
		}
		
		return list;
	}

}
