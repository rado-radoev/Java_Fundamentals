package com.ex2211;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class RectanglePane extends JPanel {

	private Color color;
	private int width;
	private int height;
	
//	public RectanglePane(int widht, int height, Color color) {
//		setWidth(widht);
//		setHeight(height);
//		this.color = color;
//	}
//	
//	public RectanglePane(int width, int height) {
//		setWidth(width);
//		setHeight(height);
//	}
//	
//	public RectanglePane() {
//		this(100, 100);
//	}
		
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(color);
		g.fillRect(5, 5, getWidth(), getHeight());
		
	}
	
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setHeight(int height) {
		this.height = height;
		repaint();
	}
	
	public void setWidth(int width) {
		this.width = width;
		repaint();
	}
	
	public void setColor(Color color) {
		this.color = color;
		repaint();
	}
	
}
