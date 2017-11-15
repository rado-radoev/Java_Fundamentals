package com.ex_2310;

import javax.swing.JPanel;


public class BouncingBall extends JPanel {

	// Box height and width
	private int width;
	private int height;

	// Ball Size
	float radius = 40;
	float diameter = radius * 2;

	// Center of Call
	float X = radius + 50;
	float Y = radius + 20;

	// Direction
	float dx = 3;
	float dy = 3;

	// Generate Ball
	DrawBallPanel ball;
	
	public BouncingBall() {

		ball = new DrawBallPanel(radius, diameter, X, Y);
		ball.repaint();
		add(ball);	
		repaint();
	}
}
