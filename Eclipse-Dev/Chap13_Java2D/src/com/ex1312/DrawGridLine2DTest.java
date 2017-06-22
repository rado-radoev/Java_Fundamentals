package com.ex1312;

import javax.swing.JFrame;

public class DrawGridLine2DTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Draw 8x8 grid using Line2D.Double");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DrawGridLine2D grid = new DrawGridLine2D();
		
		frame.add(grid);
		frame.setSize(600, 600);
		frame.setVisible(true);
		
	}

}
