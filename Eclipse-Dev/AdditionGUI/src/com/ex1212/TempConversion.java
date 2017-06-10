// this includes ex 12.12 and 12.13
package com.ex1212;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TempConversion extends JFrame {

	private final JButton convert;
	private final JButton clear;
	private final JRadioButton celciusToFahreneit;
	private final JRadioButton fahrenheitToCelcius;
	private final ButtonGroup buttongroup;
	private final JLabel tempToConvert;
	private final JLabel convertedTemp;
	private final JTextField userInput;
	private final JTextField convertedTempResult;
	private final JPanel radioButtonsJPanel;
	private final JPanel tempConversionJPanel;
	private final JPanel buttonsJPanel;
	private final FlowLayout layout;
	//private final JPanel mainJPanel;
	
	public TempConversion() {
		super("Temperature convertor");
		layout = new FlowLayout();
		setLayout(layout);
		
		// setup JPanels;
		radioButtonsJPanel = new JPanel(new GridLayout(2, 1));
		tempConversionJPanel = new JPanel(new GridLayout(2, 2, 5, 5));
		buttonsJPanel = new JPanel(new GridLayout(1, 2, 15, 5));
		
		// Set two radio buttons
		celciusToFahreneit = new JRadioButton("Celcius to Fahrenheit");
		fahrenheitToCelcius = new JRadioButton("Fahrenheit to celcius");
		celciusToFahreneit.setSelected(true);
		buttongroup = new ButtonGroup();
		buttongroup.add(celciusToFahreneit);
		buttongroup.add(fahrenheitToCelcius);
		radioButtonsJPanel.add(celciusToFahreneit);
		radioButtonsJPanel.add(fahrenheitToCelcius);
		
		// set two labels and two textfields
		tempToConvert = new JLabel("Enter temperature:");
		convertedTemp = new JLabel("Converted temperature:");
		userInput = new JTextField(2);
		userInput.setEditable(true);
		convertedTempResult = new JTextField(2);
		convertedTempResult.setEditable(false);
		tempConversionJPanel.add(tempToConvert);
		tempConversionJPanel.add(userInput);
		tempConversionJPanel.add(convertedTemp);
		tempConversionJPanel.add(convertedTempResult);
		
		// add buttons
		convert = new JButton("Convert");
		clear = new JButton("Clear");
		buttonsJPanel.add(convert);
		buttonsJPanel.add(clear);
		
		add(radioButtonsJPanel, layout.LEFT);
		add(tempConversionJPanel, layout.CENTER);
		add(buttonsJPanel, layout.RIGHT);
		
	}
}











































