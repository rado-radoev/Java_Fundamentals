package com.ex1316;

import javax.swing.JFrame;

public class DrawCubesTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Drawing cubes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DrawCubes cubes = new DrawCubes();
		frame.add(cubes);
		frame.setVisible(true);
		frame.setSize(350, 350);

	}

}
