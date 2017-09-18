package com.ex2211;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextField;

public class MyColorChooser extends JFrame {

	private final JTextField redTextField;
	private final JTextField greenTextField;
	private final JTextField blueTextField;
	private final JLabel redLabel;
	private final JLabel greenLabel;
	private final JLabel blueLabel;
	private final JSlider redSlider;
	private final JSlider greenSlider;
	private final JSlider blueSlider;
	private final JPanel colorsDisplayValuePanel;
	private final JPanel colorsDisplayJSlider;
	
	public MyColorChooser() {
		super("Color Chooser");
				
		// set up text fields
		redTextField = new JTextField("0", 3);
		greenTextField = new JTextField("0", 3);
		blueTextField = new JTextField("0", 3);
		
		// create Labels
		redLabel = new JLabel("Color red:");
		greenLabel = new JLabel("Color green:");
		blueLabel = new JLabel("Color blue:");
		
		// create JPanel to hold and display color values
		colorsDisplayValuePanel = new JPanel();
		
		// create JPanel to hold and display color JSliders
		colorsDisplayJSlider = new JPanel();
		

		// red color
		redSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
		redSlider.setMajorTickSpacing(10);
		redSlider.setPaintTicks(true);
		redSlider.addChangeListener(
				event -> {redTextField.setText(String.valueOf(redSlider.getValue()));}
				);
		colorsDisplayJSlider.add(redSlider);
		// green color
		greenSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
		greenSlider.setMajorTickSpacing(10);
		greenSlider.setPaintTicks(true);
		greenSlider.addChangeListener(
				event -> {greenTextField.setText(String.valueOf(greenSlider.getValue()));}
				);
		colorsDisplayJSlider.add(greenSlider);
		// blue color
		blueSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
		blueSlider.setMajorTickSpacing(10);
		blueSlider.setPaintTicks(true);
		blueSlider.addChangeListener(
				event -> {blueTextField.setText(String.valueOf(blueSlider.getValue()));}
				);
		colorsDisplayJSlider.add(blueSlider);
		
		// group color lables and text fields to jpanel
		colorsDisplayValuePanel.add(redLabel);
		colorsDisplayValuePanel.add(redTextField);
		colorsDisplayValuePanel.add(greenLabel);
		colorsDisplayValuePanel.add(greenTextField);
		colorsDisplayValuePanel.add(blueLabel);
		colorsDisplayValuePanel.add(blueTextField);
		

		add(colorsDisplayValuePanel, BorderLayout.NORTH);
		add(colorsDisplayJSlider, BorderLayout.SOUTH);
		
	}
	
}   
