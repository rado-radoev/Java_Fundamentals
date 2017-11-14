package com.ex_2310;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class DrawBallPanel extends JPanel {
	
	// ball size
	private float radius;
	private float diameter;
	
	// center of Call
	float X;
	float Y;
	
	public DrawBallPanel(float radius, float diameter,
			float X, float Y) {
		this.radius = radius;
		this.diameter = diameter;
		this.X = X;
		this.Y = Y;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.BLUE);
		g2d.fillOval((int)(X-radius), (int)(Y-radius), (int)diameter, (int)diameter);
	}
}
