package com.ex176;

import java.util.function.DoubleBinaryOperator;
import java.util.function.BinaryOperator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.function.Function;

public class Lambdas {
	
	private static SecureRandom random = new SecureRandom();

	public static void main(String[] args) {
			calcProduct((a, b ) -> a * b, 10d, 20d);
			
			System.out.println(calcProd2((a,b) -> a * b, 11.3, 12.5));
			
			
			Thread t = new Thread(() -> System.out.println("Welcome to Java!"));
			t.start();
			
			List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
			System.out.println(list.stream()
				.filter(value -> value % 2 !=0)
				.reduce(0, (x,y) -> x + y));
			
			random.ints(10000, 1, 3)
				.boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.forEach((side, frequency) -> System.out.printf("%-6d%d%n", side, frequency));
				

	}

	public static void calcProduct (DoubleBinaryOperator binOp, Double a, Double b) {
		System.out.println(binOp.applyAsDouble(a, b));
	}
	
	public static Double calcProd2 (BinaryOperator<Double> binOp, Double a, Double b) {
		return binOp.apply(a, b);
	}
}
