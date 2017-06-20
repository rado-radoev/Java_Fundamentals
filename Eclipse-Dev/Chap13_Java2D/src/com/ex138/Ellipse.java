package com.ex138;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

public class Ellipse extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		// Draw 10 concentric circles, separated by 10 px each
		final int count = 10;
		int separator = 50;
		
		g2d.draw(new Ellipse2D.Double(0, 0, 50, 50));
		
		for (int i = 1; i < count; i++) {
			int sep = separator * i;
			g2d.draw(new Ellipse2D.Double(0, sep, 50, 50));
		}
		
	}
}
