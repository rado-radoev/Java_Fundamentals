package com.ex2216_Test;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
		clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		undoButton = new JButton("Undo");
		undoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		// fill colorNames
		colorNames = new String[Colors.values().length];
		Colors[] col = Colors.values();
		for (int i = 0; i < colorNames.length; i++) {
			colorNames[i] = col[i].getColorName();
		}
		colors = new JComboBox<String>(colorNames	);
		colors.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		// fill shapeNames
		shapeNames = new String[Shapes.values().length];
		Shapes[] sha = Shapes.values();
		for (int i = 0; i < shapeNames.length;i++) {
			shapeNames[i] = sha[i].getShape();
		}
		shapes =  new JComboBox<String>(shapeNames);
		shapes.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		filled = new JCheckBox("Filled");
		filled.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		// setup the draw panel
		drawPanel = new DrawPanel(statusBar);
		
		componentsPanel.add(undoButton);
		componentsPanel.add(clearButton);
		componentsPanel.add(colors);
		componentsPanel.add(shapes);
		componentsPanel.add(filled);
		
		drawingPanel.add(drawPanel);
		
		statusBarPanel.add(statusBar);
		
		add(componentsPanel, BorderLayout.NORTH);
		add(drawingPanel, BorderLayout.CENTER);
		add(statusBarPanel, BorderLayout.SOUTH);
	}
}
