package com.ex129;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Calculator extends JFrame {

	private final JPanel buttonsJpanel;
	private final JButton[] buttons; 
	private final String[] buttonNames = {
			"7", "8", "9", "/",
			"4", "5", "6", "*",
			"1", "2", "3", "-",
			"0", ".", "=", "+"};
	private final JTextField textField;
	
	private static String str1;
	private static String str2;
	private static String operator;
	private static int str1AndOperatorIndexPosition;
	private static boolean operatorSelected;
	
	public Calculator() {
		super("Calculator");
		setLayout(new BorderLayout(100, 1));
		
		textField = new JTextField(50);
		textField.setEditable(false);	
		
		buttonsJpanel = new JPanel(new GridLayout(4, 4, 5, 10));
		
		buttons = new JButton[buttonNames.length];
		for (int i = 0; i < buttonNames.length; i++) {
			buttons[i] = new JButton(buttonNames[i]);
			buttonsJpanel.add(buttons[i]);
			buttons[i].addActionListener( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {			
					textField.setText(textField.getText() + e.getActionCommand());
					
					if (e.getActionCommand() == "/" || e.getActionCommand() == "*" ||
							e.getActionCommand() == "-" || e.getActionCommand() == "+") {
						str1 = textField.getText().substring(0, textField.getText().length() - 1);
						operator = textField.getText().substring(textField.getText().length() - 1);
						str1AndOperatorIndexPosition = textField.getText().length();
						operatorSelected = true;
					}
					
					if (operatorSelected && e.getActionCommand() == "=") {
						str2 = textField.getText().substring(str1AndOperatorIndexPosition, textField.getText().length() - 1);
						textField.setText(String.valueOf(calculate(str1, str2, operator)));
					}
				}
			});
		}
		
		add(textField, BorderLayout.NORTH);
		add(buttonsJpanel, BorderLayout.CENTER);
	}
	
	private double calculate (String str1, String str2, String operator) {
		double num1 = Double.parseDouble(str1);
		double num2 = Double.parseDouble(str2);
		double result = num1;
		
		
		switch (operator) {
		case "/":
			result =  num1 / num2;
			break;
		case "*":
			result =  num1 * num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "+":
			result = num1 + num2;
			break;
		}
		
		return result;
	}
}



















































