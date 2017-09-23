package com.ex2216_Test;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class DrawFrame extends JFrame {

	private final BorderLayout layout;
	private final DrawPanel drawPanel;
	private final JPanel componentsPanel;
	private final JPanel drawingPanel;
	private final JPanel statusBarPanel;
	private final JButton clearButton;
	private final JButton undoButton;
	private final JLabel statusBar;
	private final String[] shapeNames;
	private final JComboBox<String> shapes;
	private final String[] colorNames;
	private final JComboBox<String> colors;
	private final JCheckBox filled;
	
	public DrawFrame() {
		super();
		
		// setup the JFRame layout
		layout =  new BorderLayout();
		setLayout(layout);
				
		// create the 3 panels
		componentsPanel = new JPanel();
		drawingPanel = new JPanel();
		statusBarPanel = new JPanel();
		
		statusBar = new JLabel();
		
		clearButton = new JButton("Clear");
		
		undoButton = new JButton("Undo");
		
		// fill colorNames
		colorNames = new String[Colors.values().length];
		Colors[] col = Colors.values();
		for (int i = 0; i < colorNames.length; i++) {
			colorNames[i] = col[i].getColorName();
		}
		colors = new JComboBox<String>(colorNames	);
		
		
		// fill shapeNames
		shapeNames = new String[Shapes.values().length];
		Shapes[] sha = Shapes.values();
		for (int i = 0; i < shapeNames.length;i++) {
			shapeNames[i] = sha[i].getShape();
		}
		shapes =  new JComboBox<String>(shapeNames);
		
		filled = new JCheckBox("Filled");		
		
		// setup the draw panel
		drawPanel = new DrawPanel(statusBar);
		
		
		
	}
}
