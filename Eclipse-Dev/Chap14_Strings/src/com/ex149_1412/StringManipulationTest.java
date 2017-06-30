package com.ex149_1412;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class StringManipulationTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame("String manipulation");
		
		StringManupulation str = new StringManupulation();
		frame.add(str, BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(600, 200);

		
	}

}
