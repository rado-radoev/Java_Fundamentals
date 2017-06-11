// this includes ex 12.12 and 12.13
package com.ex1212;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private final GridLayout layout;
	
	public TempConversion() {
		super("Temperature convertor");
		layout = new GridLayout(3,1,0,0);
		setLayout(layout);
		
		// setup JPanels;
		radioButtonsJPanel = new JPanel(new GridLayout(2, 1, -10, -10));
		tempConversionJPanel = new JPanel(new FlowLayout());
		buttonsJPanel = new JPanel(new FlowLayout());
		
		// Set two radio buttons
		RadioButtonHandler radioButtonHandler = new RadioButtonHandler();
		celciusToFahreneit = new JRadioButton("Celcius to Fahrenheit");
		fahrenheitToCelcius = new JRadioButton("Fahrenheit to Celcius");
		celciusToFahreneit.setSelected(true);
		buttongroup = new ButtonGroup();
		buttongroup.add(celciusToFahreneit);
		buttongroup.add(fahrenheitToCelcius);
		radioButtonsJPanel.add(celciusToFahreneit);
		radioButtonsJPanel.add(fahrenheitToCelcius);
		celciusToFahreneit.addItemListener(radioButtonHandler);
		fahrenheitToCelcius.addItemListener(radioButtonHandler);
		
		// set two labels and two textfields
		tempToConvert = new JLabel(String.format("Enter temperature:\t\t\t"));
		convertedTemp = new JLabel("Converted temperature:");
		userInput = new JTextField(null,4);
		userInput.setEditable(true);
		convertedTempResult = new JTextField(null,4);
		convertedTempResult.setEditable(false);
		tempConversionJPanel.add(tempToConvert);
		tempConversionJPanel.add(userInput);
		tempConversionJPanel.add(convertedTemp);
		tempConversionJPanel.add(convertedTempResult);
		
		// add buttons
		ButtonHandler buttonHandler = new ButtonHandler();
		convert = new JButton("Convert");
		clear = new JButton("Clear");
		convert.addActionListener(buttonHandler);
		clear.addActionListener(buttonHandler);
		buttonsJPanel.add(convert);
		buttonsJPanel.add(clear);
		
		add(radioButtonsJPanel);
		add(tempConversionJPanel);
		add(buttonsJPanel);
		
	}
	
	private class RadioButtonHandler implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getSource() == celciusToFahreneit) {
				
			} else if (e.getSource() == fahrenheitToCelcius) {
				
			}
			
		}
		
	}
	
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == convert) {
				String userInputStr = userInput.getText();
				double convetedTemp = 0.0;
				double userEnteredTemp;
				try {
					userEnteredTemp = Double.parseDouble(userInputStr);
					if (celciusToFahreneit.isSelected()) {
						convetedTemp = ((userEnteredTemp * 9) / 5) + 32;
					}
					else if (fahrenheitToCelcius.isSelected()) {
						convetedTemp = ((userEnteredTemp - 32) * 5) / 9;
					}
					convertedTempResult.setText(String.format("%.2f", convetedTemp));
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(getParent(), "Numbers only accepted");
				} 
			} else if (e.getSource() == clear) {
				userInput.setText("");
				convertedTempResult.setText("");
			}
			
		}
		
	}
}











































