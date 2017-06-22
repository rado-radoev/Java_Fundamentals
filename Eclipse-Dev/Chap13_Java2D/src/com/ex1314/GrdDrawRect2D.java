package com.ex1314;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class GrdDrawRect2D extends JPanel {
	
	private int rowsX;
	private int rowsY;
	private int colsX;
	private int colsY;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		int[] grid = new int[10];
		
		rowsX = 50;
		rowsY = 50;
		
		colsX = 50;
		colsY = 50;
		
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0 ; col <= grid.length; col++) {
				g2d.draw(new Rectangle2D.Float(rowsX, rowsY, 20, 20));
				rowsX += 20;
			}
			rowsX = 50;
			rowsY += 20;
		}
	}
}
