package com.ex1300;

import javax.swing.JFrame;

public class ShapesTst {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Shapes test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		Shapes shape = new Shapes();
		Eyes eyes = new Eyes();
		Iris iris = new Iris();
		
		shape.add(eyes);
		shape.add(iris);
		
		
		frame.setSize(300, 300);
		frame.setVisible(true);

	}
}
