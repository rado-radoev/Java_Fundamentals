package com.ex2214;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;	

public class Shapes extends JFrame implements MouseListener {
	
	private ArrayList<Double> xPoints;
	private ArrayList<Double> yPoints;
	private Color color;
	private DrawPanel drawPanel;
	
	public Shapes() {
		
		xPoints =  new ArrayList<Double>();
		yPoints=  new ArrayList<Double>();
		
		color = Color.BLACK;
		
		drawPanel = new DrawPanel();
		drawPanel.setColor(color);
		drawPanel.setXPoint(xPoints);
		drawPanel.setYPoint(yPoints);
		
		this.addMouseListener(this);

		add(drawPanel);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		xPoints.add(getMousePosition().getX());
		yPoints.add(getMousePosition().getY());
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
