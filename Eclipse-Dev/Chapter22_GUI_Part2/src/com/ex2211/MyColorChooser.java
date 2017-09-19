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

	private final RGB[] colorNames = {RGB.RED, RGB.GREEN, RGB.BLUE};
	private final JTextField[] colorTextFields;
	private final JLabel[] colorLabels;
	private final JSlider[] colorSliders;
	private final JPanel displayValuesPanel;
	private final JPanel displaySlidersPanel;
	
	
	public MyColorChooser() {
		super("Color Chooser");
		
		// setup the two JPanels that will hold the labels and textfields and the sliders
		displayValuesPanel = new JPanel();
		displaySlidersPanel = new JPanel();
		
		
		// setup Labels
		colorLabels = new JLabel[colorNames.length];
		for (int i = 0; i < colorLabels.length; i++) {
			String currentColor = colorNames[i].name();
			colorLabels[i] = new JLabel(currentColor.substring(0, 1).toUpperCase() + currentColor.substring(1) + ":");
		}
				
		// setup text fields
		colorTextFields = new JTextField[colorNames.length];
		for (int i = 0; i < colorTextFields.length; i++) {
			colorTextFields[i] = new JTextField(3);
		}
		
		// add labels and text fields
		for (int i = 0; i < colorLabels.length; i++) {
			for (int j = i; j <= i; j++) {
				displayValuesPanel.add(colorLabels[j]);
				displayValuesPanel.add(colorTextFields[j]);
			}
		}
		
		// setup JSliders
		colorSliders = new JSlider[colorNames.length];
		for (int i = 0; i < colorSliders.length; i++) {
			colorSliders[i] = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
			colorSliders[i].setMajorTickSpacing(10);
			colorSliders[i].setPaintTicks(true);
			colorSliders[i].setName(colorNames[i].name());
			colorSliders[i].addChangeListener(listener);
			displaySlidersPanel.add(colorSliders[i]);
		}
		
		add(displayValuesPanel, BorderLayout.NORTH);
		add(displaySlidersPanel, BorderLayout.SOUTH);
	}
	
	private ChangeListener listener = new ChangeListener() {
		
		@Override
		public void stateChanged(ChangeEvent e) {
			for (int i = 0; i < colorSliders.length;i++) {
				colorTextFields[i].setText(String.valueOf(colorSliders[i].getValue()));
			}	
		}
	};
	
}   


