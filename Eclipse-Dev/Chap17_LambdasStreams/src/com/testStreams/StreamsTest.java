package com.testStreams;

import java.util.stream.IntStream;

public class StreamsTest {

	public static void main(String[] args) {
		int[] nums = {1,756,423,21,4,89,45,12,4};
		
		System.out.println(IntStream.of(nums)
				.sum());
		System.out.println(IntStream.of(nums));

	}

}
