package com.ex2216;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonsPanel extends JPanel{

	private final JButton clearButton;
	private final JComboBox colorsList;
	private final String[] colorNames = {"Black", "Blue", "Cyan","DarkGray", "Gray", "Green", "LightGray",	"Magenta", 
			"Orange", "Pink", "Red", "White", "Yellow"	};
	
	private final Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, 
			Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
	
	private final String[] shapeNames = {"Arc", "Elipse", "Line", "Polygon", "Rectangle", "RoundRectangle"};
	private final JComboBox shapesList;
	private final MyShapes[] shapes = {};
	private final JCheckBox filled;
	private Color selectedColor;
	private MyShapes selectedShape;
	
	public ButtonsPanel() {
		super();

		// Create clear button
		clearButton = new JButton("Clear");
		clearButton.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
					}
				}
			);
		
		add(clearButton);
		
		// Create list of colors menu
		colorsList = new JComboBox<String>(colorNames); // create list with color names
		add(new JScrollPane(colorsList)); // add scroll bar to colors list
		
		// set listener
		colorsList.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						selectedColor = colors[colorsList.getSelectedIndex()];
						
					}
				}
			);
		
		// Create shapes 
		shapesList = new JComboBox<String>(shapeNames);
		add(new JScrollPane(shapesList));  // add scroll bar to the shapes list
		
		shapesList.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						selectedShape = shapes[shapesList.getSelectedIndex()];
						
					}
				}
			);
				
		// Create checkbox
		filled = new JCheckBox("Filled");
		filled.setSelected(false);
		filled.addChangeListener(
			new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		
		add(filled);
	}
}
