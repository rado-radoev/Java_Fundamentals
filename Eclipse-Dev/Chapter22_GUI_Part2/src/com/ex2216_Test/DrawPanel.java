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
	private final int TRIANGLE = 2;
	private final int LINE = 3;

	private MyShape[] shapes;		// An array shapes of type MyShape that will store all the shapes the user draws
	private int shapeCount;			// An integer shapeCount that counts the number of shapes in the array
	private int shapeType; 			//An integer shapeType that determines the type of shape to draw.
	private MyShape currentShap;  	// A MyShape currentShape that represents the current shape the user is drawing.
	private Color currentColor;		// A Color currentColor that represents the current drawing color.
	private boolean filledShape;		// A boolean filledShape that determines whether to draw a filled shape.
	private JLabel statusLabel; 		// A JLabel statusLabel that represents the status bar. The status bar will display the coordinates of the current mouse position
	
	public DrawPanel() { }
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int i = 0; i < shapeCount; i++) {
			if (shapes[i] != null) {
				shapes[i].draw(g);
			}
		}
	}
	
	public void setShapeType(MyShape shape) {
		if (shape instanceof Oval)
			shapeType = OVAL;
		else if(shape instanceof Rectangle)
			shapeType = RECTANGLE;
		else if (shape instanceof Triangle)
			shapeType = TRIANGLE;
		else if (shape instanceof Line) {
			shapeType = LINE;
		}
	}
	
	public int getShapeType() {
		return shapeType;
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
			
		}
	}
	
}











