package com.ex2214;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;	

public class Shapes extends JFrame {
	
	private ArrayList<Double> xPoints;
	private ArrayList<Double> yPoints;
	private Color color;
	private DrawPanel drawPanel;
	private JPanel drawingJPanel;
	
	public Shapes() {
		
		xPoints = new ArrayList<Double>();
		yPoints = new ArrayList<Double>();
		
		color = Color.BLACK;
		
		drawingJPanel = new JPanel();
		
		drawPanel = new DrawPanel();
		drawPanel.setColor(color);

		addMouseListener(new MouseClickedHandler());
		
		drawingJPanel.add(drawPanel);
		add(drawingJPanel, BorderLayout.CENTER);

	}
	
	private class MouseClickedHandler extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			xPoints.add((double)e.getX());
			yPoints.add((double)e.getY());
			drawPanel.setXPoint(xPoints);
			drawPanel.setYPoint(yPoints);
		}
	}

}
