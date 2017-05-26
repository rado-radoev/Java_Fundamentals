package com.quadraliteral;

public class QuadraTest {

	public static void main(String[] args) {
		Quadraliteral shape = new Rectangle(
				new Point (1, 6),
				new Point (6, 10));
		System.out.printf("%s: %s%n", "area is",shape.area());
		
		
		Quadraliteral shape2 = new Trapezoid(
				new Point(1,5),
				new Point(1, 12),
				new Point(1,5),
				new Point(1, 6));
		
		System.out.printf("%s: %s%n", "area is",Math.floor(shape2.area()));
	}
}
