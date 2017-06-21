package com.ex1310;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.Color;
import java.util.Random;
import java.awt.Graphics;

public class Triangles extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Generate pseudo random
		Random rand = new Random(System.currentTimeMillis());
		
		// generate coordinates for triangles
		int[] xPoint = {20, 60, 100};
		int[] yPoint = {20, 60, 20};
		
//		for (int i = 0; i < xPoint.length;i++) {
//			rand.setSeed(System.currentTimeMillis());
//			xPoint[i] = (rand.nextInt(31) * 2) + 10;
//			yPoint[i] = (rand.nextInt(31) * 2) + 10;
// 		}
		
		
		// create Graphics2D obj
		Graphics2D g2d = (Graphics2D) g;
		
		
		GeneralPath triangle = new GeneralPath();
	
		// set the initial coordinate of the general path
		triangle.moveTo(xPoint[0], yPoint[0]);
	
		for (int i = 1; i < xPoint.length; i++) {
			triangle.lineTo(xPoint[i], yPoint[i]);
			
		}
		
		triangle.closePath();
		
		triangle.closePath();
		g2d.translate(150, 150);
		
		for (int i = 0; i < 20; i++) {
			g2d.rotate(Math.PI / 10.0);
			g2d.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
			g2d.fill(triangle);
		}
		
		
		
	}
}









