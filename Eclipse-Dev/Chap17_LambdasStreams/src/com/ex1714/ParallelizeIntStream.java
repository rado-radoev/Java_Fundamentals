package com.ex1714;

import java.util.stream.IntStream;

public class ParallelizeIntStream {

	public static void main(String[] args) {
//		System.out.printf("Prepare int stream for prallelization by mapping each "
//				+ "int to a square and then summing: ");

		int[] values = {5, 9, 6, 1, 4, 20, 7, 3, 2};

		IntStream iStream = IntStream.of(values);
		
		System.out.println(
		iStream.parallel()
			.mapToDouble(num -> num * num)
			.reduce(0, (num1, num2) -> num1 + num2));
		
		
		System.out.print(
		IntStream.of(values)
			.mapToDouble(num -> num * num)
			.reduce(0, (num1, num2) -> num1 + num2));
	
	
	}

}
