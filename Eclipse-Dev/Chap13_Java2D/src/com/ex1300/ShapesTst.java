package com.ex1300;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShapesTst {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Shapes test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Shapes shapes = new Shapes();

		
		frame.add(shapes);
		frame.setSize(300, 300);
		frame.setVisible(true);

	}
}
