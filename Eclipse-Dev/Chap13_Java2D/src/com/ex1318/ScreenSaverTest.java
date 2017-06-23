package com.ex1318;

import javax.swing.JFrame;


public class ScreenSaverTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Screen server");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(800, 800);
		
		ScreenSaver ss = new ScreenSaver();
		frame.add(ss);
	}

}
