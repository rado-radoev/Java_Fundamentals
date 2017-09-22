package com.ex2216_Test;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.font.ShapeGraphicAttribute;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawPanel extends JPanel {
	
	private final int OVAL = 0;
	private final int RECTANGLE = 1;
	private final int LINE = 2;

	private MyShape[] shapes;		// An array shapes of type MyShape that will store all the shapes the user draws
	private int shapeCount;			// An integer shapeCount that counts the number of shapes in the array
	private int shapeType; 			//An integer shapeType that determines the type of shape to draw.
	private MyShape currentShape;  	// A MyShape currentShape that represents the current shape the user is drawing.
	private Color currentColor;		// A Color currentColor that represents the current drawing color.
	private boolean filledShape;		// A boolean filledShape that determines whether to draw a filled shape.
	private JLabel statusLabel; 		// A JLabel statusLabel that represents the status bar. The status bar will display the coordinates of the current mouse position
	
	public DrawPanel() { }
	
	public DrawPanel (JLabel label) {
		statusLabel = label;
		
		for (int i = 0; i < 100; i++) {
			shapes[i] = null;
		}
		
		shapeCount = 0;
		shapeType = 2;
		currentShape = null;
		currentColor = Color.BLACK;
		
		this.setBackground(Color.WHITE);
		MouseHandler mh = new MouseHandler();
		addMouseListener(mh);
		addMouseMotionListener(mh);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int i = 0; i < shapeCount; i++) {
			if (shapes[i] != null) {
				shapes[i].draw(g);
			}
		}
	}
	
	public MyShape getCurrentShape() {
		switch (shapeType) {
		case 0:
			currentShape = new Oval();
			return currentShape;
		case 1:
			currentShape = new Rectangle();
			return currentShape;
		case 2: 
			currentShape = new Line();
			return currentShape;
		}
		
		return null;
	}
	
	public void getShapeType() {
		if (currentShape != null) {
			if (currentShape instanceof Oval)
				shapeType = 0;
			else if (currentShape instanceof Rectangle)
				shapeType = 1;
			else if (currentShape instanceof Line)
				shapeType = 2;
		}
	}

	public void setCurrentColor(Color color) {
		currentColor = color;
	}
	
	public void setFilledShape(boolean filled) {
		filledShape = filled;
	}
	
	public void clearLastShape() {
		if (shapeCount >= 1) {
			--shapeCount;
		}
		else {
			shapeCount = 0;
		}
		repaint();
	}
	
	
	public void clearDrawing() {
		shapeCount = 0;
		repaint();
	}
	
	private class MouseHandler extends MouseAdapter implements MouseMotionListener {
		@Override
		public void mousePressed(MouseEvent event) {
			// assign currentShape a new shape of the specified type by shapeType
			// and initialize both points to the mouse position
			getShapeType();
			currentShape.setX1(event.getX());
			currentShape.setY1(event.getY());
		}
		
		@Override
		public void mouseReleased(MouseEvent event) {
			// set the second point of currentShape to the current mouse position
			currentShape.setX2(event.getX());
			currentShape.setY2(event.getY());
			
			// add currentShape to the array
			shapes[shapeCount] = currentShape;
			
			// set currentShape to null 
			currentShape = null;
			// and call repaint to update the drawing with the new shape.
			repaint();
		}
		
		
		@Override
		public void mouseMoved(MouseEvent event) {
			// update the label with the current coordinates
			statusLabel.setText(String.format("x:%d y:%d", event.getX(), event.getY()));
		}
		
		
		@Override
		public void mouseDragged(MouseEvent event) {
			// this will allow the user to shape while dragging mouse
			// update the label with the current coordinates
			statusLabel.setText(String.format("x:%d y:%d", event.getX(), event.getY()));
			currentShape.setX2(event.getX());
			currentShape.setY2(event.getY());
			repaint();
		}
	}
	
}











