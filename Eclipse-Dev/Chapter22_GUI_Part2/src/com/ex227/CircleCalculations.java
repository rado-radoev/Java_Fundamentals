package com.ex227;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.security.SecureRandom;
import java.awt.BorderLayout;

public class CircleCalculations extends JFrame {

	private final JTextArea calculations;	// display the results of the calculations
	private final SecureRandom rnd;
	private final Circle circle;
	private final BorderLayout layout;
	
	public CircleCalculations() {
		super("Display circle calculations");
			
		layout = new BorderLayout();
		setLayout(layout);
		
		rnd = new SecureRandom();
		int diam = rnd.nextInt(100) + 10;
		circle = new Circle();
		
		circle.setDiameter(diam);
		
		add(circle, BorderLayout.CENTER);
		
		calculations = new JTextArea();
		calculations.setEditable(false);
		calculations.setText(String.format("Circle diameter: %.2f cm%nCircle area: %.2f cm%nCircle circumference: %.2f cm%n", 
				getDiameter(),
				getArea(),
				getCircumference()));
		
		add(calculations, BorderLayout.SOUTH);
	}
	
	public double getDiameter() {
		return circle.getDiameter();
	}
	
	public double getArea() {
		double radius = (double)getDiameter() / 2;
		return Math.PI * radius;
	}
	
	public double getCircumference() {
		double radius = (double)getDiameter() / 2;
		
		return  2 * Math.PI * radius;
	}
	
	public double getRadius() {
		return (double)getDiameter() / 2;
	}
	
	public JTextArea getCalculations() {
		return calculations;
	}
	
	public void setCalculations(String text) {
		calculations.setText(text);
	}
	
}
