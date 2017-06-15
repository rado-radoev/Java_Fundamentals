package com.ex1300;

import javax.swing.JFrame;

public class ShapesTst {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Shapes test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Shapes shape = new Shapes();
		
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.add(shape);
	}
}
