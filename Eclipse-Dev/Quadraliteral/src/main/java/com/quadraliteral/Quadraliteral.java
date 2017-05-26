package com.quadraliteral;

public abstract class Quadraliteral {

	private int ab;
	private int bc;
	private int cd;
	private int da;
	
	public Quadraliteral(int coordX, int coordY, int coordX1, int coordY1) {
		ab = new Point(coordX, coordY).getXYDistance();
		bc = new Point(coordY, coordX1).getXYDistance();
		cd = new Point(coordX1, coordY1).getXYDistance();
		da = new Point(coordY1, coordX).getXYDistance();
	}
	
	public int getAB() {
		return ab;
	}
	
	public int getBC() {
		return bc;
	}

	public int getCD() {
		return cd;
	}

	public int getDA() {
		return da;
	}

	// abstract method to be overloaded by subclass
	public abstract int area();

	@Override
	public String toString() {
		return String.format("%s %s %s: ", 
				"area of",
				getClass().getName(),
				"is");		
	}
}
