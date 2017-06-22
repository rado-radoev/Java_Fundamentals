package com.ex1316;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

public class DrawCubes extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
	
		paintCube(g2d, 300, 300);
		
		paintCube(g2d, -300, -300);
		
		//repaint();
		
	}
	
	private void paintCube(Graphics2D g2d, int xLoc, int yLoc) {
		int[] xPoints = {0,100, 100, 0};
		int[] yPoints = {0, 0, 150 , 150};
	
		GeneralPath cube = new GeneralPath();
	
		cube.moveTo(xPoints[0], yPoints[0]);
		
		for (int i = 1; i < xPoints.length; i++) {
			cube.lineTo(xPoints[i], yPoints[i]);
		} 
		
		cube.closePath();
		
		g2d.translate(xLoc, yLoc);
		
		g2d.setPaint(Color.BLACK);
		g2d.fill(cube);
	}
}
