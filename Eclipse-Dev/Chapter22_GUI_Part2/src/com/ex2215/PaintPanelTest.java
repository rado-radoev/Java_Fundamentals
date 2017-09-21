package com.ex2215;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PaintPanelTest {

	public static void main(String[] args) {
		JFrame app = new JFrame("Demo painter program");

		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setLocation(400, 200);
		app.setVisible(true);
		PaintPanel paintPanel = new PaintPanel();  // create paint panel
		app.add(paintPanel, BorderLayout.CENTER);
		
	}

}
