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



public class UserPanel extends JFrame implements ItemListener, ActionListener {

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
	
	public static int getSelectedItem () {
		return selectedItem;
	}
	
	public static Color getCurrentColor() {
		return currentColor;
	}
	
	public UserPanel() {
		
		layout = new FlowLayout();
		comboBoxPanel = new JPanel(layout);
		paintPanel = new JPanel(layout);
		
		comboBoxLabel = new JLabel("Select shape: ");
		comboBoxPanel.add(comboBoxLabel);
		
		comboBox =  new JComboBox<String>(comboBoxChoices);
		comboBox.addItemListener(this);
		comboBox.setMaximumRowCount(comboBox.getItemCount());
		comboBox.setSelectedIndex(0);
		comboBoxPanel.add(comboBox);
		
		
		colorChooser = new JButton("Choose color");
		colorChooser.addActionListener(this);
		comboBoxPanel.add(colorChooser);
		
		
		
		add(comboBoxPanel, BorderLayout.NORTH);
		add(shape, BorderLayout.CENTER);
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			selectedItem = comboBox.getSelectedIndex();
			shape.repaint();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		currentColor = JColorChooser.showDialog(UserPanel.this, "Choose a color", currentColor);
		
		if (currentColor == null) {
			currentColor = Color.BLACK;
		}
	}
}
