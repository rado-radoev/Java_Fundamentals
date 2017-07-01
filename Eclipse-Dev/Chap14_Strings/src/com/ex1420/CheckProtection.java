package com.ex1420;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JButton;


public class CheckProtection extends JFrame {
	
	private final JLabel label;
	private final JTextField textField;
	private final JButton button;
	private final JPanel panel;
	private JTextField result;

	public CheckProtection() {
		super("Ceck protection");
		setLayout(new FlowLayout());
		
		panel = new JPanel();
		
		label = new JLabel("Enter check amount here: ");
		panel.add(label);
		
		textField = new JTextField(8);
		panel.add(textField);
		
		ButtonHandler handler = new ButtonHandler();
		button = new JButton("Convert");
		button.addActionListener(handler);
		panel.add(button);
		
		add(panel);

		result = new JTextField(8);
		result.setEditable(false);
		
		add(result, FlowLayout.CENTER);
	}
	
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button) {
				try {
					result.setText(convert(textField.getText()));
				}
				catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Amount cannot be null");
				}
			}
		}		
	}
	
	private String convert(String amount) {
		StringBuffer sb = new StringBuffer();
		double number = Double.valueOf(amount);
		int digits = 6;
		char[] zeros = new char[digits];
		Arrays.fill(zeros, '0');
		String format = String.valueOf(zeros);
		DecimalFormat df = new DecimalFormat(format);
		df.setMinimumFractionDigits(2);
		df.getCurrencyInstance(new Locale("en", "US"));
		sb.append(df.format(number));
		
		
		int position = 0;
		while (sb.charAt(position) == '0') {
			sb.replace(position, position, "*");
			sb.deleteCharAt(position + 1);
			position++;
		}
		
		return sb.toString();
	}
}
























