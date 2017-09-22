package com.ex2216_Test;

import java.awt.Graphics;
import java.awt.Color;

public class Rectangle extends MyBoundedShape {
	
	public Rectangle() {}
	
	public Rectangle (int x1, int y1, int x2, int y2, Color color, boolean fill) {
		super(x1, y1, x2, y2, color, fill);
	}

	@Override
	public void draw(Graphics g) {
		if (getFill()) {
			g.fillRect(getX1(), getY1(), getX2() - getX1(), getY2() - getY2());
		}
		else {
			g.fillRect(getX1(), getY1(), getX2() - getX1(), getY2() - getY1());
		}
		
	}

}