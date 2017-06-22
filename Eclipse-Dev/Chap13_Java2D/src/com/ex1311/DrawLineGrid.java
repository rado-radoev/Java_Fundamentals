package com.ex1311;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class DrawLineGrid extends JPanel {
	
	private int y;
	private int x;
	private int startPosX;
	private int endPosX;
	private int startPosY;
	private int endPosY;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		this.setBackground(new Color(230,230,250));
		
		// set 8 x 8 array
		int[] grid = new int[9];
		
		startPosX = 10;
		x = startPosX;
		endPosX = startPosX * grid.length;
		
		startPosY = 10;
		y = startPosY;
		endPosY = startPosY * grid.length;
		
		// loop through grid and draw a line for each row and each column
		for (int i = 0; i < grid.length; i++) {
			g.drawLine(startPosX, y, endPosX, y);
			g.drawLine(x, startPosY, x, endPosY);
			
			x += 10;
			y += 10;
		}		
	}
}
