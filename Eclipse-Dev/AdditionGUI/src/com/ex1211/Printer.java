package com.ex1211;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class Printer extends JFrame {
	
	private final JTextArea textArea1;
	private final JTextArea textArea2;
	private final JTextArea textArea3;
	private final JLabel printerLabel;
	private final JLabel prinQualityLabel;
	private final JCheckBox imageCheckBox;
	private final JCheckBox testCheckBox;
	private final JCheckBox codeCheckBox;
	private final JCheckBox printToFileCheckBox;
	private final JRadioButton selectionRadioButton;
	private final JRadioButton allRadioButton;
	private final JRadioButton appletRadioButton;
	private final ButtonGroup radioButtonGroup;
	private final JComboBox<String> printQualityComboBox;
	private final JButton ok;
	private final JButton cancel;
	private final JButton settings;
	private final JButton help;
	private final JPanel buttonsJPanel;
	private final JPanel mainSectionJPanel;
	private final JPanel bottomSectionJPanel;
	private final JPanel printerNameJPanel;
	private final JPanel checkBoxJPanel;
	private final JPanel radioButtonsJPanel;
	
	public Printer() {
		super("Printer");
		
		// Declare JPanels
		printerNameJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		mainSectionJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		buttonsJPanel = new JPanel(new GridLayout(4, 1, 10, 5));
		bottomSectionJPanel = new JPanel(new GridLayout(1, 3, 15, 0));
		checkBoxJPanel = new JPanel(new GridLayout(3, 1));
		radioButtonsJPanel = new JPanel(new GridLayout(3, 0));
		
		// Create and add the my printer label
		printerLabel = new JLabel("Printer: My Printer");
		printerNameJPanel.add(printerLabel);
		
		// Create 1st Text Area
		textArea1 = new JTextArea(3, 2);
		textArea1.setEditable(true);
		mainSectionJPanel.add(textArea1);
		
		// Create checkboxes
		// Add them to their own JPanel in Grid Alignment
		// Add the Check Boxes JPanel to the main JPanel which is in FlowLayout
		imageCheckBox = new JCheckBox("Image");
		testCheckBox = new JCheckBox("Test");
		codeCheckBox = new JCheckBox("Code");
		checkBoxJPanel.add(imageCheckBox);
		checkBoxJPanel.add(testCheckBox);
		checkBoxJPanel.add(codeCheckBox);
		mainSectionJPanel.add(checkBoxJPanel);
		
		// Create text area 2
		// Add it to the main JPanel
		textArea2 = new JTextArea(3,2);
		textArea2.setEditable(true);
		mainSectionJPanel.add(textArea2);
				
		// Create radio buttons
		// All will be selected by default
		// Add to their own JPanel in GridLayout
		// Add the Grid JPanel to the main JPanel
		selectionRadioButton = new JRadioButton("Selection");
		allRadioButton = new JRadioButton("All");
		allRadioButton.setSelected(true);
		appletRadioButton = new JRadioButton("Applet");
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(selectionRadioButton);
		radioButtonGroup.add(allRadioButton);
		radioButtonGroup.add(appletRadioButton);
		radioButtonsJPanel.add(selectionRadioButton);
		radioButtonsJPanel.add(allRadioButton);
		radioButtonsJPanel.add(appletRadioButton);
		mainSectionJPanel.add(radioButtonsJPanel);
		
	}
}
























































