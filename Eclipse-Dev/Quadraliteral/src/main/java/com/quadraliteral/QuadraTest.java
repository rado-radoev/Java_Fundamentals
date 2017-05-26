package com.quadraliteral;

public class QuadraTest {

	public static void main(String[] args) {
		Quadraliteral shape = new Rectangle(
				new Point (1, 2),
				new Point (2, 3),
				new Point (3, 4),
				new Point (4, 1));
		System.out.print(shape.area());
	}
}
