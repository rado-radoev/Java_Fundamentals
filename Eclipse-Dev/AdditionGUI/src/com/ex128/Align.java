package com.ex128;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;


public class Align extends JFrame {

	private final GridLayout buttonsGrid;
	private final GridLayout textFieldsGrid;
	private final GridLayout checkBoxesGrid;
	private final JTextField[] textFields;
	private final JLabel[] labels;
	private final JCheckBox[] checkBoxes;
	private final JButton[] buttons;
	private final String[] labelNames = {"X", "Y"};
	private final String[] checkBoxesNames = {"Shift to Grid", "Show on Grid"};
	private final String[] buttonNames = {"OK", "Cancel", "Help"};
	private final JPanel jpanelButtons;
	private final JPanel jpanelCheckBoxes;
	private final JPanel textFields;
	private final Container container;
	private final FlowLayout layout;
	
	public Align() {
		
		super("Align");
		layout = new FlowLayout();
		layout.setHgap(10);
		layout.setVgap(5);
	
		
		
	}
}
