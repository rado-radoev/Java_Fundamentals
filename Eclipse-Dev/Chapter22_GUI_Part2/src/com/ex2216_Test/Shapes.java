package com.ex2216_Test;

public enum Shapes {

	OVAL("Oval"),
	LINE("Line"),
	RECTANGLE("Rectangle");
	
	private String shape;
	
	Shapes(String shape) {
		this.shape = shape;
	}
	
	public String getShape() {
		return shape;
	}
}
