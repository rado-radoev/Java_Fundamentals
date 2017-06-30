package com.ex1328_1329;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class UserPanel extends JFrame implements ItemListener {

	private final JPanel comboBoxPanel;
	private final JPanel paintPanel;
	private final JLabel comboBoxLabel;
	private final JComboBox<String> comboBox;
	private final String[] comboBoxChoices = {"Rectangle", "Oval", "Arc", "Pie Chart", "Line"};
	private ShapeChooser shape = new ShapeChooser();
	private static int selectedItem = -1;
	
	public static int getSelectedItem () {
		return selectedItem;
	}
	
	public UserPanel() {
		
		comboBoxPanel = new JPanel(new FlowLayout());
		paintPanel = new JPanel(new FlowLayout());
		
		comboBoxLabel = new JLabel("Select shape: ");
		comboBoxPanel.add(comboBoxLabel);
		
		comboBox =  new JComboBox<String>(comboBoxChoices);
		comboBox.addItemListener(this);
		comboBox.setMaximumRowCount(comboBox.getItemCount());
		comboBox.setSelectedIndex(0);
		
		comboBoxPanel.add(comboBox);
		
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
}
