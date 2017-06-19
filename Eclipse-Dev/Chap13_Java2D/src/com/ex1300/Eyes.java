package com.ex1300;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Eyes extends JPanel {
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D leftEye = (Graphics2D) g;
		Graphics2D rightEye = (Graphics2D) g;
		
		leftEye.setPaint(Color.WHITE);
		leftEye.fill(new Ellipse2D.Double(5, 30, 70, 100));
		rightEye.setPaint(Color.WHITE);
		rightEye.fill(new Ellipse2D.Double(70, 30, 70, 100));
	}
}
