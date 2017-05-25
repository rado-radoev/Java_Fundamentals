package com.polymorphism;

public class PieceWorker extends Employee {
	
	private double wage; // wage per piece
	private int pieces; // number of pieces produced

	public PieceWorker(String firstName, String lastName, int birthDay, int birthMonth, int birthYear,
			String socialSecurityNumber, double wage, int pieces) {
		
		super(firstName, lastName, birthDay, birthMonth, birthYear, socialSecurityNumber);
		
		this.pieces = pieces;
		this.wage = wage;
		
	}
	
	public int getPieces() {
		return pieces;
	}
	
	public double getWage() {
		return wage;
	}
	
	public void setPieces(int pieces) {
		if (pieces < 0) {
			throw new IllegalArgumentException("Number of pieces must be >= 0");
		}
		this.pieces = pieces;
	}
	
	public void setWage(double wage) {
		if (wage < 0) {
			throw new IllegalArgumentException("Wage must be >= 0");
		}
		this.wage = wage;
	}

	@Override
	public double earnings() {
		return getPieces() * getWage() + bDayBonus();
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s%n%s: %d%n%s: $%,.2f", 
				"Piece Worker", 
				super.toString(), 
				"number of pieces", 
				getPieces(), 
				"wage per piece",
				getWage());
	}

}
