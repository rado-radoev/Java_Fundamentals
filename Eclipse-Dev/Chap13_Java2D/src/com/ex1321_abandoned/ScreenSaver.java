package com.ex1321_abandoned;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.awt.Shape;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;


public class ScreenSaver extends JPanel implements ActionListener {

	private int[] shapes;
	private Color c;
	private JTextField textField;
	private JLabel label;
	private JButton button;
	private JPanel userInputPanel;
	private JPanel displayPanel;
	private FlowLayout flowLayout;
	private BorderLayout borderLayout;
	private Random rnd;
	
	
	private static int userChoice;
	
	public static int getUserChoice() {
		return userChoice;
	}
	
	
	public ScreenSaver() {
		shapes = new int[11];	
		
		userInputPanel = new JPanel(flowLayout);
		
		label = new JLabel("Enter number from 1 to 10");
		userInputPanel.add(label);
		
		textField = new JTextField(5);
		userInputPanel.add(textField);
		
		// TO DO: implement button handler
		button = new JButton("OK");
		button.addActionListener(this);
		userInputPanel.add(button);
		
		add(userInputPanel, borderLayout.NORTH);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		ShapesGenerator shape = new ShapesGenerator();
		// inovke the shape;
		
	}
	
	
	
	
}
