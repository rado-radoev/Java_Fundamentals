package com.ex136;

import javax.swing.JFrame;

public class ArcsTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Arctic circles");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new Arcs());
		frame.setVisible(true);
		frame.setSize(450, 450);
	}
}

