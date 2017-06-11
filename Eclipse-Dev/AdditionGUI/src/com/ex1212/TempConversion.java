// this includes ex 12.12 and 12.13
package com.ex1212;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private final FlowLayout layout;
	
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
		fahrenheitToCelcius = new JRadioButton("Fahrenheit to Celcius");
		celciusToFahreneit.setSelected(true);
		buttongroup = new ButtonGroup();
		buttongroup.add(celciusToFahreneit);
		buttongroup.add(fahrenheitToCelcius);
		radioButtonsJPanel.add(celciusToFahreneit);
		radioButtonsJPanel.add(fahrenheitToCelcius);
		
		// set two labels and two textfields
		tempToConvert = new JLabel("Enter temperature:");
		convertedTemp = new JLabel("Converted temperature:");
		userInput = new JTextField(null, 2);
		userInput.setEditable(true);
		convertedTempResult = new JTextField(null, 2);
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
		
		add(radioButtonsJPanel, layout.LEFT);
		add(tempConversionJPanel, layout.CENTER);
		add(buttonsJPanel, layout.RIGHT);
		
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
					convertedTempResult.setText(String.valueOf(convetedTemp));
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











































