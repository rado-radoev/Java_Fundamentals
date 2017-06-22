package com.ex1317;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserPrompt extends JFrame {

	private final JButton ok;
	private final JButton cancel;
	private final JTextField radiusTextField;
	private final JTextField xCoordTextField;
	private final JTextField yCoordTextField;
	private final JLabel radiusLabel;
	private final JLabel xCoordLabel;
	private final JLabel yCoordLabel;
	private final JPanel jPanel;
	
	private String radius;
	private float x;
	private float y;
	
	public UserPrompt() {
		super("User prompt");
		setLayout(new FlowLayout());
		
		jPanel = new JPanel();
		
		radiusLabel = new JLabel("Enter radius: ");
		radiusTextField = new JTextField("radius");
		
		xCoordLabel = new JLabel("Enter x coordinate: ");
		xCoordTextField = new JTextField("x coordinate");
		
		yCoordLabel = new JLabel("Enter y coordinate: ");
		yCoordTextField = new JTextField("y coordinate");
		
		ButtonHandler buttonHandler = new ButtonHandler();
		ok = new JButton("OK");
		ok.addActionListener(buttonHandler);
		cancel = new JButton("Cancel");
		cancel.addActionListener(buttonHandler);
		
		jPanel.add(radiusLabel);
		jPanel.add(radiusTextField);
		jPanel.add(yCoordLabel);
		jPanel.add(yCoordTextField);
		jPanel.add(xCoordLabel);
		jPanel.add(xCoordTextField);
		
				
		add(jPanel);
		
	}
	
	
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == ok) {
				radius = radiusTextField.getText();
				
				if (testCoordinateFiled(xCoordTextField.getText()))
					x = Float.valueOf(xCoordTextField.getText());
				else 
					x = .0f;
				
				if (testCoordinateFiled(yCoordTextField.getText()))
					y = Float.valueOf(yCoordTextField.getText());
				else
					y = .0f;
			}
			else if(e.getSource() == cancel) {
				// implement close of JFrame
			}
			
			
		}
		
		private boolean testCoordinateFiled(String text) {
			try {
				if (Float.valueOf(text) != null) {
					return true;
				}
				return false;
			} catch (NullPointerException npe) {
				return false;
			}

		}
		
	}
	
	
	
	
}






