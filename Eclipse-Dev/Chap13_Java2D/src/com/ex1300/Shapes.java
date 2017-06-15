package com.ex1300;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.BasicStroke;

public class Shapes extends JPanel {
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.GREEN);
		g.drawLine(1, 260, 280, 1);
		g.setColor(Color.RED);
		g.drawLine(280, 1, 1, 260);
	}
}
