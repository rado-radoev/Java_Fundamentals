package com.ex2211;

import javax.swing.JFrame;

public class Demo {

	public static void main(String[] args) {
		MyColorChooser myColorChooser = new MyColorChooser();
		myColorChooser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myColorChooser.setSize(450, 400);
		myColorChooser.pack();
		myColorChooser.setVisible(true);
	}
}
