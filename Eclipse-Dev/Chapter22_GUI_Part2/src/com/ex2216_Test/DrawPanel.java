package com.ex2216_Test;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;

public class DrawPanel extends JPanel {

	private MyShape[] shapes;	// An array shapes of type MyShape that will store all the shapes the user draws
	private int shapeCount;		// An integer shapeCount that counts the number of shapes in the array
	private int shapeType; 		//An integer shapeType that determines the type of shape to draw.
	private MyShape currentShap;  // A MyShape currentShape that represents the current shape the user is drawing.
	private Color currentColor;		// A Color currentColor that represents the current drawing color.
	private boolean filledShape;	// A boolean filledShape that determines whether to draw a filled shape.
	private JLabel statusLabel; 	// A JLabel statusLabel that represents the status bar. The status bar will display the coordinates of the current mouse position
	
	public DrawPanel() {
		MyShape circle = new Circle(10,20,30);
		MyShape rectangle = new Rectangle(20,30,40,50);
	}
}
