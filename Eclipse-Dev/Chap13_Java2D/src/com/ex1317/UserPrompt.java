package com.ex1317;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
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
	private DrawCircleEllipse elipse;
	
	private static float radius;
	private static float x;
	private static float y;
	private static float diameter;
	private static float circumference;
	private static float area;
	
	public static float getRadius() {
		return radius;
	}
	
	public static float getPosX()	{
		return x;
	}
	
	public static float getPosY() {
		return y;
	}
	
	public static float getArea() {
		return area;
	}
	
	public static float getDiameter() {
		return diameter;
	}
	
	public static float getCircumference() {
		return circumference;
	}
	
	private void setArea(float radius) {
		this.area = (float)Math.pow(radius, 2);
	}
	
	private void setDiameter(float radius) {
		this.diameter = (float)2 * radius;
	}
	
	private void setCircumference(float radius) {
		this.circumference = (float) (2 * Math.PI) * radius;
	}
	
	
	public UserPrompt() {
		super("User prompt");
		setLayout(new FlowLayout());
		
		jPanel = new JPanel();
		
		radiusLabel = new JLabel("Enter radius: ");
		radiusTextField = new JTextField(5);
		
		xCoordLabel = new JLabel("Enter x coordinate: ");
		xCoordTextField = new JTextField(5);
		
		yCoordLabel = new JLabel("Enter y coordinate: ");
		yCoordTextField = new JTextField(5);
		
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
		jPanel.add(ok);
		jPanel.add(cancel);
		
				
		add(jPanel);
		
	}
	
	
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == ok) {
				if (testCoordinateFiled(radiusTextField.getText()))
					radius = Float.valueOf(radiusTextField.getText());
				else
					radius = .1f;
				
				if (testCoordinateFiled(xCoordTextField.getText()))
					x = Float.valueOf(xCoordTextField.getText());
				else 
					x = .0f;
				
				if (testCoordinateFiled(yCoordTextField.getText()))
					y = Float.valueOf(yCoordTextField.getText());
				else
					y = .0f;
				
				setArea(getRadius());
				setDiameter(getRadius());
				setCircumference(getRadius());
				
				EllipseFrame eFrame = new EllipseFrame();
				elipse = new DrawCircleEllipse();
				eFrame.add(elipse);
				
			}
			else if(e.getSource() == cancel) {
				// implement close of JFrame
			}
			
			
		}
		
		private boolean testCoordinateFiled(String text) {
			try {
				if (!text.equals(null)) {
					return true;
				}
				return false;
			} catch (NullPointerException npe) {
				return false;
			}

		}

		
	}
	
}






