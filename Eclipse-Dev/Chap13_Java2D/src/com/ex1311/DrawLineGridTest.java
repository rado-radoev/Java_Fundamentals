package com.ex1311;

import javax.swing.JFrame;

public class DrawLineGridTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Draw 8x8 grid using DrawLine");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DrawLineGrid grid = new DrawLineGrid();
		frame.add(grid);
		frame.setVisible(true);
		frame.setSize(400, 400);

	}

}
