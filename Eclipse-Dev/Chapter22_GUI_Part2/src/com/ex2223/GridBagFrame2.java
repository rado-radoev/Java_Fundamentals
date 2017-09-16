package com.ex2223;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;

public class GridBagFrame2 extends JFrame {

	private final GridBagLayout layout;	// layout of this frame
	private final GridBagConstraints constraints; 	// layout's constraints
	
	public GridBagFrame2() {
		super("GridBagLayout");
		
		layout = new GridBagLayout();
		setLayout(layout);
		constraints = new GridBagConstraints();
		
		// create GUI components
		String[] metals = { "Copper", "Aliminium", "Silver" };
		JComboBox comboBox = new JComboBox(metals);
		
		JTextField textField = new JTextField("TextField");
		
		String[] fonts = {"Serif", "Monospaced"};
		JList list = new JList(fonts);
		
		String[] names = { "zero", "one", "two", "three", "four" };
		JButton[] buttons = new JButton[names.length];
		
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(names[i]);
		}
		
		// Define GUI component constraints for textField
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		addComponent(textField);
		
		// buttons[0] -- weightx and weighty are 1: fill is BOTH
		constraints.gridwidth = 1;
		addComponent(buttons[0]);
		
		// buttons[1] -- weightx and weighty are 1: fill is BOTH
		constraints.gridwidth = GridBagConstraints.RELATIVE;
		addComponent(buttons[1]);
		
		// buttons[2] -- weightx and weighty are 1: fill is BOTH
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		addComponent(buttons[2]);
		
		// comboBox -- weightx is 1: fill is BOTH
		constraints.weighty = 0;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		addComponent(comboBox);
		
		// buttons[3] -- weightx is 1: fill is BOTH
		constraints.weighty = 1;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		addComponent(buttons[3]);
		
		// buttons[4] -- weightx and weighty is 1: fill is BOTH
		constraints.gridwidth = GridBagConstraints.RELATIVE;
		addComponent(buttons[4]);
		
		// list -- weightx and weighty are 1: fill is BOTH
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		addComponent(list);
	} // End GridBagFrame2 constructor
	
	// add a component to the container
	private void addComponent(Component component) {
		layout.setConstraints(component, constraints);
		add(component);
	}
	
} // End class GridBagFrame2


















