package com.quadraliteral;

public class Rectangle extends Quadraliteral {

	/**
	 * Create a Rectangle object
	 * @param sideA	sets the width
	 * @param sideC sets the length
	 */
	public Rectangle(Point sideA, Point sideC) {
		super(sideA, sideC, sideA, sideC);
		
		if (super.getABdistance() == super.getCDdistance() &&
			super.getBCdistance() == super.getDAdistance() &&
			super.getABdistance() != super.getBCdistance()) {
		System.out.printf("%s: %s%n", 
				"Current figure is",
				getClass().getName());
		}
		else {
			System.out.printf("%s%n", "Rectangle should have opposite sides in congruent.");
			throw new IllegalArgumentException();
		}
	}

	@Override
	public double area() {
		double heigth = super.getABdistance();
		double length = super.getBCdistance();
		double area = heigth * length;
		return area;
	}

	@Override
	public String toString() {
		return String.format("%s%f", 
				super.toString(),
				area());
	}
}
