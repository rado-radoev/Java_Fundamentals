package com.ex2216_Test;

import java.awt.Graphics;
import java.awt.Color;

/*
 * https://www.javaworld.com/article/3033445/learn-java/java-101-polymorphism-in-java.html
 * https://codereview.stackexchange.com/questions/83769/implement-a-shape-abstract-class
 * https://github.com/jonathansotoan/deitel/blob/master/graphicsExercises/inheritanceExercises/InheritanceShapes/InheritanceShapesTest.java
 */
public abstract class MyShape {

	private Color color;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	public MyShape() {}
	
	public MyShape(int x1, int y1, int x2, int y2, Color color) {
		this.color = color;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getX1() {
		return x1 > x2 ? x2 : x1; //upper left x coord (the smaller of the two x values)
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1 > y2 ? y2 : y1; // upper left y coord (the smaller of the two y values)
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return Math.abs(getX1() - getX2());
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return Math.abs(getY1() - getY2());
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public abstract void draw(Graphics g);
}
