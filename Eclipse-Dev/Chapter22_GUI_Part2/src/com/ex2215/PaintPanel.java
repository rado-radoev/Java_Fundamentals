package com.ex2215;

/*
 * https://stackoverflow.com/questions/31726395/fill-color-of-multiple-drawlines-that-intersect-forming-closed-shape
 * */

import java.awt.Point;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class PaintPanel extends JPanel {

	private int pointCount = 0;  // count number of points
	private Color color;
	private JLabel statusBar;
	
	// array of 10,000 java.awt.Point references
	private Point[] points = new Point[10000];
	
	// set up GUI and register mouse event handler
	public PaintPanel() {
		
		statusBar = new JLabel();
		add(statusBar, BorderLayout.SOUTH);
		
		
		addMouseListener(
			new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					statusBar.setText( String.format( "Released at [%d, %d]",
							e.getX(), e.getY()));	
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					statusBar.setText( String.format( "Pressed at [%d, %d]",
							e.getX(), e.getY()));	
					
					if (e.isMetaDown()) {
						points = null;
						points = new Point[10000];
						pointCount = 0;
						repaint();
					}
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					statusBar.setText( String.format( "Clicked at [%d, %d]",
							e.getX(), e.getY()));
					
					if (e.isMetaDown()) {
						points = null;
						points = new Point[10000];
						pointCount = 0;
						repaint();
					}
				}

	
				@Override
				public void mouseEntered(MouseEvent e) {
					statusBar.setText( String.format( "Entered at [%d, %d]",
							e.getX(), e.getY()));
				}
	
				@Override
				public void mouseExited(MouseEvent e) {
					statusBar.setText( String.format( "Exited at [%d, %d]",
							e.getX(), e.getY()));	
					
				}
		});
		
		
		// handle frame mouse motion event
		addMouseMotionListener (
			new MouseMotionAdapter() { // anonymous inner class
				// store drag coordinates and repaint
				public void mouseDragged(MouseEvent e) {
					if (pointCount < points.length) {
						points[pointCount] = e.getPoint(); // findPoint
						++pointCount;  // increment number of points in array
						repaint();	// repaint JFrame
					} // end if
				} // end method mouseDragged
				
				
				public void mouseMoved(MouseEvent e) {
					statusBar.setText( String.format( "Moved at [%d, %d]",
							e.getX(), e.getY()));
				}
				
			} // end anonymous inner class
		); // end call to MouseMotionListener 
	} // end PaintPanel constructor
	
	
	// draw ovals in a 4x4 bounding box at specified location on window
	public void paintComponent(Graphics g) {
		super.paintComponent(g);  // clear drawing area
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(1.0f));
		g2d.setColor(color);
		
		
		// draw all points in array
		for (int i = 1; i < pointCount; i++) {
			g2d.drawLine(points[i - 1].x, points[i - 1].y, points[i].x, points[i].y);
		}
	}
	
	
	public void setColor(Color color) {
		this.color = color;
	}
}









