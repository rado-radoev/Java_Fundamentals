package com.ex136;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import javax.swing.JPanel;

public class Arcs extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		// Draw 10 concentric circles, separated by 10 px each
		final int count = 10;
		int separator = 10;
		
		g2d.drawArc(0, 0, 10, 10, 0, 360);
		
		for (int i = 1; i < count; i++) {
			int sep = separator * i;
			g2d.drawArc(0, sep, 10, 10, 0, 360);
		}
		
	}
}
