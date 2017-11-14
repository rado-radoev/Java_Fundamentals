package com.ex_2310;

import javax.swing.JPanel;


public class BouncingBall extends JPanel implements Runnable {

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
		add(ball);	
	}
	
	private void draw(DrawBallPanel drawBall) {
		while (true) {

			width = getWidth();
			height = getHeight();

			X = X + dx;
			Y = Y + dy;

			if (X - radius < 0) {
				dx = -dx;
				X = radius;
			} else if (X + radius > width) {
				dx = -dx;
				X = width - radius;
			}

			if (Y - radius < 0) {
				dy = -dy;
				Y = radius;
			} else if (Y + radius > height) {
				dy = -dy;
				Y = height - radius;
			}
			
			drawBall.repaint();

			try {
				Thread.sleep(50);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}

		}
	}
	
	@Override
	public void run() {
		draw(ball);
	}

}
