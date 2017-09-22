package com.ex2216_Test;

import java.awt.Graphics;
import java.awt.Color;

public class Line extends MyShape {
	
	MyShape shape;
	
	public Line() { }
	
	public Line(int x1, int y1, int x2, int y2, Color color) {
		super(x1, y1, x2, y2, color);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(getX1(), getY1(), getX2(), getY2());
	}
}
