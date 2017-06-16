package com.ex1300;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Iris extends Shapes {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D leftIris = (Graphics2D) g;
		Graphics2D rightIris = (Graphics2D) g;
		
		leftIris.setPaint(Color.BLACK);
		rightIris.setPaint(Color.BLACK);
		rightIris.fill(new Ellipse2D.Double(20, 80, 40, 40));
		leftIris.fill(new Ellipse2D.Double(85, 80, 40, 40));
	}
}
