package com.ex1327;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.geom.Arc2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.util.Random;

public class PieChart extends JPanel {

	private int pieGraphs;
	private Random rnd;
	private Arc2D arc;
	
	public PieChart() {
		rnd = new Random(System.currentTimeMillis());
		pieGraphs = 4;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setStroke(new BasicStroke(1.5f));
		g2d.draw(new Arc2D.Double(150, 150, 300, 300, 0, 300, Arc2D.PIE));
		
		int startAngle = 0;
		int endAngle = 300;
		for (int i = 0; i < pieGraphs; i++) {
			g2d.setPaint(new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
			g2d.fillArc(150, 150, 300, 300, startAngle, endAngle / (i + 1));
			startAngle += 75;
		}
	}
}
