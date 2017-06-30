package com.ex1317;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Font;

public class DrawCircleEllipse extends JPanel {
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setPaint(new Color(230, 230, 250));
		g2d.fill(new Ellipse2D.Double(UserPrompt.getPosX(), 
				UserPrompt.getPosY(), UserPrompt.getRadius(), 
				UserPrompt.getRadius()));
		
		g.setColor(Color.BLACK);
		g.drawString("Raduis is: " + UserPrompt.getRadius(), (int)UserPrompt.getPosX(), (int)UserPrompt.getPosY() + 200);
		g.drawString("Area is: " + UserPrompt.getArea(), (int)UserPrompt.getPosX(), (int)UserPrompt.getPosY() + 220);
		g.drawString("Diameter is: " + UserPrompt.getDiameter(), (int)UserPrompt.getPosX(), (int)UserPrompt.getPosY() + 240);
		g.drawString("Circumference is: " + UserPrompt.getCircumference(), (int)UserPrompt.getPosX(), (int)UserPrompt.getPosY() + 260);
	}
	
}
