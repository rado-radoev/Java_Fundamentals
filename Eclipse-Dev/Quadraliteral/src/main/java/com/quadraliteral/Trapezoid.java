package com.quadraliteral;

public class Trapezoid extends Quadraliteral {

	public Trapezoid(Point sideA, Point sideB, Point sideC, Point sideD) {
		super(sideA, sideB, sideC, sideD);
	}
	
	public double heigth() {
		double b;
		if (getDAdistance() > getBCdistance()) {
			b = getDAdistance() - getBCdistance();
		}
		else {
			b = getBCdistance() - getDAdistance();
		}
		
		// Pythoagorean theoreme to find height
		// a*a + b*b =  h*h
		// https://www.youtube.com/watch?v=5KmCDSI3n-8
		
		double height = Math.sqrt(Math.pow(getABdistance(), 2) + Math.pow(b, 2));
		return height;
	}

	@Override
	public double area() {
		// https://www.youtube.com/watch?v=pnjCyF09m2I
		double area = (getDAdistance() + getBCdistance()) * (heigth() / 2);
		return area;
	}

	// How to identify trapezoid: http://sciencing.com/identify-trapezoid-6423.html
	// How to calculate area from sides: http://www.1728.org/quadtrap.htm
	
	
}
