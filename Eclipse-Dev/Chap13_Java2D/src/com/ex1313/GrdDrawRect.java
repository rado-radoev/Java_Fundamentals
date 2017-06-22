package com.ex1313;

import javax.swing.JPanel;
import java.awt.Graphics;

public class GrdDrawRect extends JPanel {
	
	private int rowsX;
	private int rowsY;
	private int colsX;
	private int colsY;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int[] grid = new int[10];
		
		rowsX = 50;
		rowsY = 50;
		
		colsX = 50;
		colsY = 50;
		
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0 ; col <= grid.length; col++) {
				g.drawRect(rowsX, rowsY, 20, 20);
				rowsX += 20;
			}
			rowsX = 50;
			rowsY += 20;
		}
	}
}
