package com.ex1330;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


// This is the main JFrame
// Two action interfaces are inherited by the class and implement in its body
public class UserPanel extends JFrame implements ItemListener, ActionListener {

	// Setup all arguments that will be used in the app
	private final FlowLayout layout;
	private final JPanel comboBoxPanel;
	private final JPanel paintPanel;
	private final JLabel comboBoxLabel;
	private final JButton colorChooser;
	private final JComboBox<String> comboBox;
	private final String[] comboBoxChoices = {"Rectangle", "Oval", "Arc", "Pie Chart", "Line"};
	private ShapeChooser shape = new ShapeChooser();
	private static int selectedItem = -1;
	private static Color currentColor;
	
	// used from the shapeChooser class to determine which item is selected
	public static int getSelectedItem () {
		return selectedItem;
	}
	
	// used from the shapeChooser class to determine which color is selected
	public static Color getCurrentColor() {
		return currentColor;
	}
	
	public UserPanel() {
		
		// Create default layout that will be used in the JPanel to display the color chooser combo box and the color chooser button
		layout = new FlowLayout();
		comboBoxPanel = new JPanel(layout);
		paintPanel = new JPanel(layout);
		
		// Create the label
		comboBoxLabel = new JLabel("Select shape: ");
		comboBoxPanel.add(comboBoxLabel);
		
		// crate the combo box and all the String array with all the shapes
		// Add the action listener
		// set how many rows will be visible and which index to be displayed. in this case none.
		comboBox =  new JComboBox<String>(comboBoxChoices);
		comboBox.addItemListener(this);
		comboBox.setMaximumRowCount(comboBox.getItemCount());
		comboBox.setSelectedIndex(selectedItem);
		comboBoxPanel.add(comboBox);
		
		// create the button that allows changing the color
		colorChooser = new JButton("Choose color");
		colorChooser.addActionListener(this);
		comboBoxPanel.add(colorChooser);
		
		// add the two panels to the Border layout.
		// the JPanel that contains the label, combo box and color chooser button are added to the NORTH
		// the ShapeChooser class, which extends JPanel and is JPanel is added to the center.
		add(comboBoxPanel, BorderLayout.NORTH);
		add(shape, BorderLayout.CENTER);
		
	}

	// overloaded method that peforms an action when an item from the combo box is selected
	// in this case it sets the index that is selected, so the ShapeChooser class can use it
	// to draw the selected shape
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			selectedItem = comboBox.getSelectedIndex();
			shape.repaint();
		}
		
	}

	// overloaded method that displays the ColorChooser dialog.
	// if no color is selected, by default the color is set to black
	@Override
	public void actionPerformed(ActionEvent e) {
		currentColor = JColorChooser.showDialog(UserPanel.this, "Choose a color", currentColor);
		
		if (currentColor == null) {
			currentColor = Color.BLACK;
		}
		
		shape.repaint();
	}
}
