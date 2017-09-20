package com.ex2214;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	
	Color color;
	ArrayList<Double> xPoints =  new ArrayList<Double>();
	ArrayList<Double> yPoints=  new ArrayList<Double>();
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		xPoints = getXPoints();
		yPoints = getYPoints();
		
		color = getColor();
		
		Graphics2D g2d = (Graphics2D) g;
		GeneralPath shape = new GeneralPath();
		
		// set the initial coordinate  of the General Path
		shape.moveTo(xPoints.get(0), yPoints.get(0));
		
		// create the shape
		for (int i = 0; i < xPoints.size(); i++) {
			shape.lineTo(xPoints.get(i), yPoints.get(i));
		}
		
		shape.closePath();
		
		g2d.setColor(color);
		g2d.fill(shape);
		
	}
	
	public Color getColor() {
		return color;
	}
	
	public ArrayList<Double> getXPoints() {
		return xPoints;
	}
	
	public ArrayList<Double> getYPoints() {
		return yPoints;
	}
	
	public void setXPoint(ArrayList<Double> xPoints) {
		this.xPoints = xPoints;
		repaint();
	}
	
	public void setYPoint(ArrayList<Double> yPoints) {
		this.yPoints = yPoints;
		repaint();
	}
	
	public void setColor(Color color) {
		this.color = color;
		repaint();
	}
}
