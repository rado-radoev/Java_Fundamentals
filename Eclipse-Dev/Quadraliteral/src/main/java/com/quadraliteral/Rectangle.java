package com.quadraliteral;

public class Rectangle extends Quadraliteral {

	public Rectangle(Point sideA, Point sideB, Point sideC, Point sideD) {
		super(sideA, sideB, sideC, sideD);
	}

	@Override
	public double area() {
		double heigth = getABdistance();
		double length = getABdistance();
		double area = heigth * length;
		return area;
	}

	@Override
	public String toString() {
		return String.format("%s%d", 
				super.toString(),
				area());
	}
}
