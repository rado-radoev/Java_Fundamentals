package com.ex138;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class ElipseTest extends JFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Random Elipses");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		frame.add(new Ellipse());
		frame.setVisible(true);
		frame.setSize(450, 450);
	}
}

