package com.ex1314;

import javax.swing.JFrame;

import com.ex1312.DrawGridLine2D;

public class GridDrawRect2DTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Draw 8x8 grid using Line2D.Double");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GrdDrawRect2D grid = new GrdDrawRect2D();
		
		frame.add(grid);
		frame.setSize(600, 600);
		frame.setVisible(true);

	}

}
