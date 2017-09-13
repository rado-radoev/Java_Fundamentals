package com.fig2211;

import javax.swing.JFrame;

public class DesktopFrameTest {

	public static void main(String[] args) {
		DesktopFrame df = new DesktopFrame();
		df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		df.setSize(600, 480);
		df.setVisible(true);
	}
}
