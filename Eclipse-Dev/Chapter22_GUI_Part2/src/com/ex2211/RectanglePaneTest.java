package com.ex2211;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.BorderLayout;
import java.awt.Color;


import javax.swing.JPanel;


public class RectanglePaneTest extends JFrame {
	
	private Color color;
	private RectanglePane rectangle;
	private JTextField inputText;
	
	public RectanglePaneTest() {
		super("Rectangle test");
		
		color = Color.BLUE;
		
		rectangle = new RectanglePane();
		rectangle.setWidth(200);
		rectangle.setHeight(200);
		rectangle.setColor(color);
		
		inputText = new JTextField("10", 3);
		inputText.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				warn();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				warn();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				warn();
			}
			
			public void warn() {
				try {
					if (inputText.getText().equals("GREEN")) {
						rectangle.setColor(Color.GREEN);
					}
					else if (inputText.getText().equals("RED"))
						rectangle.setColor(Color.RED);
					else if (inputText.getText().equals("BLUE"))
						rectangle.setColor(Color.BLUE);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		add(inputText, BorderLayout.NORTH);
		add(rectangle, BorderLayout.CENTER);
	}
	

	public static void main(String[] args) {
		RectanglePaneTest test = new RectanglePaneTest();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setSize(450, 350);
		test.setVisible(true);
		

	}


}
