package com.ex2214;

import javax.swing.JFrame;

public class MianDemo {

	public static void main(String[] args) {
		MyColorChooser myColorChooser = new MyColorChooser();
		myColorChooser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myColorChooser.setSize(650, 400);
		myColorChooser.setVisible(true);

	}

}
