package com.ex227;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Circle extends JPanel {
	
	private int diameter;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawOval(50, 50 , diameter, diameter);
	}
	
	public int getDiameter() {
		return diameter;
	}
	
	public void setDiameter(int diameter) {
		this.diameter = diameter > 10 ? diameter : 10;
		repaint();
	}
}
