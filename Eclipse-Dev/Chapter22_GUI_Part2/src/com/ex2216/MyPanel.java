package com.ex2216;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;

public class MyPanel extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(200, 300);
	}
}
