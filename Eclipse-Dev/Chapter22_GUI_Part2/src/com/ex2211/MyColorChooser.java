package com.ex2211;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextField;

public class MyColorChooser extends JFrame implements DocumentListener {

	private final RGB[] colorNames = {RGB.RED, RGB.GREEN, RGB.BLUE};
	private final JTextField[] colorTextFields;
	private final JLabel[] colorLabels;
	private final JSlider[] colorSliders;
	private final JPanel displayValuesPanel;
	private final JPanel displaySlidersPanel;
	private final JPanel displayRectanglePanel;
	private final RectanglePane rectangle;
	
	
	public MyColorChooser() {
		super("Color Chooser");
		
		// create rectangle pane
		rectangle = new RectanglePane();
		
		// setup the two JPanels that will hold the labels and textfields and the sliders
		displayValuesPanel = new JPanel();
		displaySlidersPanel = new JPanel();
		
		// set up rectangle JPanel
		displayRectanglePanel = new JPanel();
		displayRectanglePanel.add(rectangle);
		
		// setup Labels
		colorLabels = new JLabel[colorNames.length];
		for (int i = 0; i < colorLabels.length; i++) {
			String currentColor = colorNames[i].name();
			colorLabels[i] = new JLabel(currentColor.substring(0, 1).toUpperCase() + currentColor.substring(1) + ":");
		}
				
		// setup text fields
		colorTextFields = new JTextField[colorNames.length];
		for (int i = 0; i < colorTextFields.length; i++) {
			colorTextFields[i] = new JTextField("0", 3);
			colorTextFields[i].setName(colorNames[i].name());
			colorTextFields[i].getDocument().addDocumentListener(this);
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
		add(displayRectanglePanel, BorderLayout.CENTER);
	}
	
	private ChangeListener listener = new ChangeListener() {
		
		@Override
		public void stateChanged(ChangeEvent e) {
			for (int i = 0; i < colorSliders.length;i++) {
				colorTextFields[i].setText(String.valueOf(colorSliders[i].getValue()));
				
			}	
		}
	};
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		int r = 0, g = 0, b = 0;

		for (JTextField textField : colorTextFields) {
			if (textField.getName() == RGB.RED.name())
				r = Integer.valueOf(textField.getText());
			else if (textField.getName() == RGB.GREEN.name())
				g = Integer.valueOf(textField.getText());
			else if (textField.getName() == RGB.BLUE.name())
				b = Integer.valueOf(textField.getText());
		}
		
		Color c = new Color(r, g, b);
		rectangle.setColor(c);
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		int r = 0, g = 0, b = 0;

		for (JTextField textField : colorTextFields) {
			if (textField.getName() == RGB.RED.name())
				r = Integer.valueOf(textField.getText());
			else if (textField.getName() == RGB.GREEN.name())
				g = Integer.valueOf(textField.getText());
			else if (textField.getName() == RGB.BLUE.name())
				b = Integer.valueOf(textField.getText());
		}
		
		Color c = new Color(r, g, b);
		rectangle.setColor(c);
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {

		
	}
	
}   


