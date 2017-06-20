package com.ex1310;

import java.awt.Color;

import javax.swing.JFrame;

public class TrianglesTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Filling triangles");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Triangles triangles = new Triangles();
		frame.add(triangles);
		frame.setBackground(Color.WHITE);
		frame.setSize(500, 500);
		frame.setVisible(true);
		
	}

}
