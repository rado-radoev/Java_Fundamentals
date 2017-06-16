package com.ex1300;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.nio.channels.InterruptedByTimeoutException;

import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.GradientPaint;

import javax.swing.JColorChooser;

public class Shapes extends JPanel  {
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
//		g.setColor(Color.BLACK);
//		g.drawLine(0, 300, 300, 0);
//		g.setColor(new Color(255,0,0));
//		g.drawLine(300, 300, 0, 0);
//		
//		Font f = new Font(Font.MONOSPACED, Font.BOLD + Font.ITALIC, 14);
//		g.setFont(f);
//		String s = "Хакуна Матата!";
//		g.drawString(s, 100, 50);
//		g.setColor(new Color(255,10,10));
//		g.drawString("String length is " + s.length() + "Font style is " + f.getStyle() + 
//				"Font name is " + f.getName() + "Font size is " + f.getSize() + 
//				"Font family is " + f.getFamily(),  50, 150);
		
		Graphics2D leftEye = (Graphics2D) g;
		Graphics2D rightEye = (Graphics2D) g;
		Graphics2D leftIris = (Graphics2D) g;
		Graphics2D rightIris = (Graphics2D) g;
	
		for (int i = 0; i < 10; i++) {
			leftEye.setPaint(Color.WHITE);
			leftEye.fill(new Ellipse2D.Double(5, 30, 70, 100));
			rightEye.setPaint(Color.WHITE);
			rightEye.fill(new Ellipse2D.Double(70, 30, 70, 100));
			
			leftIris.setPaint(Color.BLACK);
			leftIris.fill(new Ellipse2D.Double(20, 40, 40, 40));
			rightIris.setPaint(Color.BLACK);
			rightIris.fill(new Ellipse2D.Double(85, 40, 40, 40));

			leftEye.setPaint(Color.WHITE);
			leftEye.fill(new Ellipse2D.Double(5, 30, 70, 100));
			rightEye.setPaint(Color.WHITE);
			rightEye.fill(new Ellipse2D.Double(70, 30, 70, 100));
			
			leftIris.setPaint(Color.BLACK);
			rightIris.setPaint(Color.BLACK);
			rightIris.fill(new Ellipse2D.Double(20, 80, 40, 40));
			leftIris.fill(new Ellipse2D.Double(85, 80, 40, 40));
			
		}


	}

}
