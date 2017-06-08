package com.ex128;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class Align extends JFrame {

	private final JTextField[] textFields;
	private final JLabel[] labels;
	private final JCheckBox[] checkBoxes;
	private final JButton[] buttons;
	private final String[] labelNames = {"X", "Y"};
	private final String[] checkBoxesNames = {"Shift to Grid", "Show on Grid"};
	private final String[] buttonNames = {"OK", "Cancel", "Help"};
	private final JPanel jpanelButtons;
	private final JPanel jpanelCheckBoxes;
	private final JPanel jpanelTextFields;
	private final Container container;
	private final FlowLayout layout;

	
	public Align() {
		
		super("Align");
		layout = new FlowLayout();
		layout.setHgap(10);
		layout.setVgap(5);
		setLayout(layout);
		
		container = getContentPane();
	
		jpanelButtons = new JPanel(new GridLayout(3, 1, 5, 5));
		jpanelCheckBoxes = new JPanel(new GridLayout(2, 1, 1, -5));
		jpanelTextFields = new JPanel(new GridLayout(2, 2, -40, 15));
		
	
		// Add checkboxes to JPanel
		CheckBoxHandler checkBoxHandler = new CheckBoxHandler();
		checkBoxes = new JCheckBox[checkBoxesNames.length];
		for (int i = 0; i < checkBoxesNames.length; i++) {
			checkBoxes[i] = new JCheckBox(checkBoxesNames[i]);
			checkBoxes[i].addItemListener(checkBoxHandler);
			jpanelCheckBoxes.add(checkBoxes[i]);
		}
		
		// Generate text fields with labels
		textFields = new JTextField[labelNames.length];
		labels = new JLabel[labelNames.length];
		for (int i = 0; i < labelNames.length ;i++) {
			textFields[i] = new JTextField("8", 5);
			labels[i] = new JLabel(labelNames[i] + ":");
			jpanelTextFields.add(labels[i]);
			jpanelTextFields.add(textFields[i]);
		}
			
		// Add buttons to JPanel
		ButtonHandler handler = new ButtonHandler();
		buttons = new JButton[buttonNames.length];
		for (int i = 0; i < buttonNames.length; i++) {
			buttons[i] = new JButton(buttonNames[i]);
			buttons[i].addActionListener(handler);
			jpanelButtons.add(buttons[i]);
		}
		
	
		add(jpanelCheckBoxes);
		add(jpanelTextFields);
		add(jpanelButtons);
	}
	
	private class CheckBoxHandler implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			JOptionPane.showMessageDialog(Align.this, "Checkbox checked");
		}
	}
	
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(Align.this, "You pressed " + e.getActionCommand());
			
		}
		
	}
	
}



































