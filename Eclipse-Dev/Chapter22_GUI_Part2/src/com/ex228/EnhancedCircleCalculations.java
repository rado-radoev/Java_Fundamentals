package com.ex228;

import com.ex227.Circle;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTextArea;

public class EnhancedCircleCalculations extends JFrame {

	private final JSlider radiusJSlider;
	private final Circle circle;
	private final JTextArea calculationsTextArea;
	
	public EnhancedCircleCalculations() {
		super("Enhanced Circle Calculator");
		
		circle = new Circle();
		calculationsTextArea = new JTextArea();
		calculationsTextArea.setEditable(false);
	
		// setup JSlider to control radius value
		radiusJSlider = new JSlider(SwingConstants.HORIZONTAL, 100, 200, 150);
		radiusJSlider.setMajorTickSpacing(5); // create tick every 10
		radiusJSlider.setPaintTicks(true);  // print ticks on slider
		
		// register JSlider event listener
		radiusJSlider.addChangeListener(
				// handle change in slider value
				evnet -> {
					circle.setDiameter(radiusJSlider.getValue() * 2);
					calculationsTextArea.setText(String.format("Circle diameter: %.2f cm%nCircle area: %.2f cm%nCircle circumference: %.2f cm%n", 
							getDiameter(),
							getArea(),
							getCircumference()));}
				);
		
		add(radiusJSlider, BorderLayout.SOUTH);
		add(circle, BorderLayout.CENTER);
		add(calculationsTextArea, BorderLayout.NORTH);
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
	
}

