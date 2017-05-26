package com.quadraliteral;

public class QuadraTest {

	public static void main(String[] args) {
		Quadraliteral shape = new Rectangle(
				new Point (1, 6),
				new Point (6, 10));
		System.out.print(shape.area());
	}
}
