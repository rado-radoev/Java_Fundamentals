package com.ex137;

import javax.swing.JFrame;

public class LinesTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Random lines");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new Lines());
		frame.setVisible(true);
		frame.setSize(450, 450);
	}
}

