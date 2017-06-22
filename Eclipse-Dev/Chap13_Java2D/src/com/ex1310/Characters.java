package com.ex1310;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Characters extends JPanel {
	
	private Random rand;
	private final String[] fontFamily = {"Monospaced", "SansSerif", "Serif"};
	private char c;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		rand = new Random(System.currentTimeMillis());
		
		for (int i = 0; i < 50; i++) {
			c = (char) (rand.nextInt(25) + 97);
			g.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
			g.setFont(new Font(fontFamily[rand.nextInt(fontFamily.length)], rand.nextInt(4), (rand.nextInt(50) + 1)));
			g.drawString(String.valueOf(c), rand.nextInt(400), rand.nextInt(400));
		}
	}
}
