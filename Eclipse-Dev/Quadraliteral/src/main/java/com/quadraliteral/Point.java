package com.quadraliteral;

public class Point {

	// Define 4 side of quadraliteral
	private int x;
	private int y;	
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getXYDistance() {
		return getX() + getY();
	}

}
