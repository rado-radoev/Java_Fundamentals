package com.quadraliteral;

public abstract class Quadraliteral {

	// Define 4 sides of quadraliteral
	// Using Point with composite relation. Every quadraliteral has-a Point
	// Points are considered as A, B, C, D Points, representing each of the 4
	// angles of a quadraliteral shape.
	// In clockwise direction, starting from A(bottom left), B(upper left), 
	// C(upper right), D(bottom right)
	private Point sideA;
	private Point sideB;
	private Point sideC;
	private Point sideD;
	
	public Quadraliteral(Point sideA, Point sideB, Point sideC, Point sideD) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
		this.sideD = sideD;
	}
	
	// return side A-B as X,Y coordinates
	public Point getSideA() {
		return sideA;
	}
	
	// Get the length between A - B
	public double getABdistance() {
		return getSideA().getY() - getSideA().getX();
	}
	
	// return side B-C as X,Y coordinates
	public Point getSideB()	{
		return sideB;
	}
	
	// Get the length between B - C
	public double getBCdistance() {
		return getSideB().getY() - getSideB().getX();
	}
	
	// return side C - D as X, Y coordinates
	public Point getSideC() {
		return sideC;
	}
	
	// Get the length between C - D
	public double getCDdistance() {
		return getSideC().getY() - getSideC().getX();
	}
	
	// return side D - A as X, Y coordinates
	public Point getSideD() {
		return sideD;
	}
	
	// Get the length between D - A 
	public double getDAdistance() {
		return getSideD().getY() - getSideD().getX  ();
	}
	
	// abstract method to be overloaded by subclass
	public abstract double area();

	@Override
	public String toString() {
		return String.format("%s %s %s: ", 
				"area of",
				getClass().getName(),
				"is");		
	}
}
