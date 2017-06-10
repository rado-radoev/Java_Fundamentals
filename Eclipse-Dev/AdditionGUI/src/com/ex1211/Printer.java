package com.ex1211;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.GridLayout;import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

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
	private final String[] printQualities = {"High", "Medium", "Low"};
	private final JButton ok;
	private final JButton cancel;
	private final JButton setup;
	private final JButton help;
	private final JPanel buttonsJPanel;
	private final JPanel mainSectionJPanel;
	private final JPanel bottomSectionJPanel;
	private final JPanel printerNameJPanel;
	private final JPanel checkBoxJPanel;
	private final JPanel radioButtonsJPanel;
	
	public Printer() {
		super("Printer");
		setLayout(new FlowLayout());
		
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

		// Create text area 2
		// Add it to the main JPanel
		textArea3 = new JTextArea();
		textArea3.setEditable(true);
		mainSectionJPanel.add(textArea3);
		
		// Setting up the bottom row with buttons
		// Creating the label
		prinQualityLabel = new JLabel("Print Quality:");
		bottomSectionJPanel.add(prinQualityLabel);
		
		// creating the print quality combo box
		printQualityComboBox = new JComboBox<String>(printQualities);
		printQualityComboBox.setMaximumRowCount(3);
		add(new JScrollPane(printQualityComboBox));
		bottomSectionJPanel.add(printQualityComboBox);
		
		// creating the print to file checkbox
		printToFileCheckBox = new JCheckBox("Print to file");
		bottomSectionJPanel.add(printToFileCheckBox);
		
		// Creating the buttons
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		setup = new JButton("Setup...");
		help = new JButton("Help");
		buttonsJPanel.add(ok);
		buttonsJPanel.add(cancel);
		buttonsJPanel.add(setup);
		buttonsJPanel.add(help);
		
		// add all JPanels to JFrame
		add(printerNameJPanel);
		add(mainSectionJPanel);
		add(buttonsJPanel);
		add(checkBoxJPanel);
		add(radioButtonsJPanel);
		add(bottomSectionJPanel);
		
	}
}
























































