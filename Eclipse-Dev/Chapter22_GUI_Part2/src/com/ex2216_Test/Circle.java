package com.ex2216_Test;

import java.awt.Graphics;

public class Circle extends MyShape {

	private int x, y, r;

	Circle(int x, int y, int r)
	{
		this.x = x;
		this.y = y;
		this.r = r;
	}

   // For brevity, I've omitted getX(), getY(), and getRadius() methods.

   @Override
   public void draw() {
	   System.out.println("Drawing circle (" + x + ", "+ y + ", " + r + ")");
   }
}

