package com.ex2216_Test;

import java.awt.Color;

public abstract class MyBoundedShape extends MyShape {

	private boolean fill;
	
	public MyBoundedShape() { 
		setFill(fill);
	}
	
	public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, boolean fill) {
		super(x1, y1, x2, y2, color);
		setFill(fill);
	}
	
	public final void setFill(boolean fill) {
		this.fill = fill;
	}
	
	public final boolean getFill() {
		return fill;
	}
}
