package com.quadraliteral;

public class Rectangle extends Quadraliteral {

	public Rectangle(int a, int b, int c, int d) {
		super(a, b, c, d);
		
	}

	@Override
	public int area() {
		int heigth = getAB();
		int length = getBC();
		int area = heigth * length;
		return area;
	}

	@Override
	public String toString() {
		return String.format("%s%d", 
				super.toString(),
				area());
	}
}
