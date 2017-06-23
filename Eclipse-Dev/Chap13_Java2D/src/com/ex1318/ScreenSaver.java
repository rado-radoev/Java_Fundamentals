package com.ex1318;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;


public class ScreenSaver extends JPanel {

	private Random rnd;
	private Color color;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		rnd = new Random(System.currentTimeMillis());
		
		for (int i = 0; i < 101; i++) {
			g.setColor(new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
			g.drawLine(rnd.nextInt(200), rnd.nextInt(400), rnd.nextInt(200), rnd.nextInt(400));
		}
		
		repaint();
		
	}
}
