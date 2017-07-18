package com.testStreams;

import java.util.stream.IntStream;
import java.util.function.IntPredicate;

public class StreamsTest {

	public static void main(String[] args) {
		int[] nums = {1,756,423,21,4,89,45,12,4};
		
		System.out.print("Original values: ");
		IntStream.of(nums)
			.forEach(value -> System.out.printf("%d ", value));
		
		System.out.println();
		
		// count min max sum and average
		System.out.println("Count: " + IntStream.of(nums).count());
		System.out.println("Min: " + IntStream.of(nums).min().getAsInt());
		System.out.println("Max: " + IntStream.of(nums).max().getAsInt());
		System.out.println("Sum: " + IntStream.of(nums).sum());
		System.out.println("Average: " + IntStream.of(nums).average().orElse(0.D));
		
		// sum of values with reduce method
		System.out.println("Sum via reduce method: " + IntStream.of(nums).reduce(0, (x,y) -> x + y));
		
		// sum of squares of values with reduce method
		System.out.println("Sum of squares via reduce method: " + IntStream.of(nums).reduce(0, (x, y) -> x + y * y));
		
		// product of values with reduce method
		System.out.println("Product via reduce method: " + IntStream.of(nums).reduce(1, (x,y) -> x * y));
		
		// even values displayed in sorted order
		System.out.println("Even values displayed in sorted order: "); 
		IntStream.of(nums)
				.filter(value -> value % 2 == 0)
				.sorted()
				.forEach(value -> System.out.printf("%d ", value));
		
		System.out.println();
		// odd values multiplied by 10 and display in sorted order
		System.out.println("Odd values multiplied by 10 and display in sorted order: ");
		IntStream.of(nums)
			.filter(value -> value % 2 != 0)
			.map(value -> value * 10)
			.sorted()
			.forEach(value -> System.out.printf("%d ", value));
		System.out.println();
		
		
		// sum range of integers from 1 to 10 exclusive
		System.out.println("Sum range of integers from 1 to 10 exclusive: " + IntStream.range(1, 10).sum());
		
		// sum range of integers from 1 to 10 inclusive
		System.out.println("Sum range of integers from 1 to 10 inclusive: " + IntStream.rangeClosed(1, 10).sum());
		
		
		// get summary statistics
		System.out.println(IntStream.of(nums).summaryStatistics());
		
		// display range even and greater than 5
		IntPredicate even = value -> value % 2 == 0;
		IntPredicate greaterThan5 = value -> value > 5;
		
		System.out.println("Even and greater than 5: ");
		IntStream.range(1, 20)
			.filter(even.and(greaterThan5))
			.forEach(value -> System.out.printf("%d ", value));
		
	}

}








