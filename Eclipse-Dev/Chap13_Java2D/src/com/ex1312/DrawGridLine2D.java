package com.ex1312;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.BasicStroke;
import java.util.Random;

public class DrawGridLine2D extends JPanel {
	
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
		Random rnd = new Random(System.currentTimeMillis());
		
		// set 8 x 8 array
		int[] grid = new int[9];
		
		startPosX = 50;
		x = startPosX;
		endPosX = startPosX * grid.length;
		
		startPosY = 50;
		y = startPosY;
		endPosY = startPosY * grid.length;
		
		Graphics2D g2d = (Graphics2D) g;
		float[] dashes = {10};
		
		g2d.setStroke(new BasicStroke(6f));
		for (int i = 0; i < grid.length; i++) {
			g2d.setPaint(new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
			g2d.setStroke(new BasicStroke(4, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 5, dashes, 0));
			g2d.draw(new Line2D.Double(startPosX, y, endPosX, y));
			g2d.draw(new Line2D.Double(x, startPosY, x, endPosY));
			
			x += startPosX;
			y += startPosY;
		}
		
	}
}
