package com.ex1300;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Font;
import javax.swing.JColorChooser;

public class Shapes extends JPanel {
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
//		g.setColor(Color.BLACK);
//		g.drawLine(0, 300, 300, 0);
//		g.setColor(new Color(255,0,0));
//		g.drawLine(300, 300, 0, 0);
		
		Font f = new Font(Font.MONOSPACED, Font.BOLD + Font.ITALIC, 14)
		g.setFont(f);
		//Color c = JColorChooser.showDialog(this, "Избери цвят", new Color(100,200,255));
		String s = "Хакуна матата";
		g.drawString(s, 100, 50);
		g.drawString("String length is " + s.length() + "Font style is " + f.getStyle() + 
				"Font name is " + f.getName() + "Font size is " + f.getSize() + 
				"Font family is " + f.getFamily() + ,  x, y);
	}
}
