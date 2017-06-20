package com.ex137;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;
import java.util.Random;
import java.awt.Color;
import java.awt.BasicStroke;

public class Lines extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		Random random = new Random(System.currentTimeMillis());

		
		for (int i = 0; i < 10; i++) {
			g2d.setPaint(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
			g2d.setStroke(new BasicStroke(random.nextFloat(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 10f));
			g2d.draw(new Line2D.Double((double)random.nextInt(450), 
					(double)random.nextInt(450), 
					(double)random.nextInt(450), 
					(double)random.nextInt(450)));	
		}
		// Draw 10 random lines in random colors and random thickness

	
	}
}
