package com.ex149_1412;

import javax.swing.JPanel;
import java.awt.Graphics;

public class DrawString extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		
		g.drawString("String", 150, 150);
		
	}
}
