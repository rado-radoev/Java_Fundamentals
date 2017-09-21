package com.ex2215;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.Color;
import java.awt.Dimension;


public class MyColorChooser extends JFrame implements DocumentListener, ActionListener {

	private final RGB[] colorNames = {RGB.RED, RGB.GREEN, RGB.BLUE};
	private final JTextField[] colorTextFields;
	private final JLabel[] colorLabels;
	private final JSlider[] colorSliders;
	private final JPanel displayValuesPanel;
	private final JPanel displaySlidersPanel;
	private final RectanglePane rectangle;
	private final PaintPanel paintPanel;
	private final JPanel colorChooserAndDrawingMainJPanel;
	private final JMenuItem menuItem;
	private final JMenu jMenu;
	private final JMenuBar jMenuBar;
		
	public MyColorChooser() {
		super("Color Chooser");
		
		// create file menu
		jMenu = new JMenu("File");
		jMenu.setMnemonic('F');
		
		// create exit submenu
		menuItem = new JMenuItem("Exit");
		jMenu.add(menuItem);
		menuItem.setMnemonic('x');
		menuItem.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				}
		);
		
		// create the menu bar
		jMenuBar = new JMenuBar();
		// add file menu to menu bar
		jMenuBar.add(jMenu);
			
		// create the paint panel
		paintPanel = new PaintPanel();
		
		// create rectangle pane
		rectangle = new RectanglePane();
		rectangle.setWidth(200);
		rectangle.setHeight(200);
		
		// create the main JPanel that will hold the portion where the user will be drawing 
		// and the color viewer
		colorChooserAndDrawingMainJPanel = new JPanel(new GridLayout(1, 2));
		
		colorChooserAndDrawingMainJPanel.add(rectangle);
		colorChooserAndDrawingMainJPanel.add(paintPanel, new Dimension(100, 100));
		
		// setup the two JPanels that will hold the labels and textfields and the sliders
		displayValuesPanel = new JPanel();
		displaySlidersPanel = new JPanel();
		
		// setup Labels
		// each label starts with UpperCase and then lowercase
		colorLabels = new JLabel[colorNames.length];
		for (int i = 0; i < colorLabels.length; i++) {
			String currentColor = colorNames[i].name();
			colorLabels[i] = new JLabel(currentColor.substring(0, 1) + currentColor.substring(1).toLowerCase() + ":");
		}
				
		// setup text fields
		// each text field is assigned a zero value and contains 3 characters
		// assign a Componenet name to the text field so it can be identified
		// add document listener to monitor when the value is changed (whem moving the sliders)
		// so it can updat the color
		// add actionlistener to monitor when enter key is pressed in the text field
		// so it can update the color and move the slider to the appropriate position
		colorTextFields = new JTextField[colorNames.length];
		for (int i = 0; i < colorTextFields.length; i++) {
			colorTextFields[i] = new JTextField("0", 3);
			colorTextFields[i].setName(colorNames[i].name());
			colorTextFields[i].getDocument().addDocumentListener(this);
			colorTextFields[i].addActionListener(this);
		}
		
		// add labels and text fields to the JPanel
		// order of appearance LABEL: TEXTFIELD
		for (int i = 0; i < colorLabels.length; i++) {
			for (int j = i; j <= i; j++) {
				displayValuesPanel.add(colorLabels[j]);
				displayValuesPanel.add(colorTextFields[j]);
			}
		}
		
		// setup JSliders
		// create as many sliders as colornames
		// set major ticks space to 10 and pain them on the screen
		// add Component name so the sliders can be identified (used with the document listener)
		// add each slider to the JPanel
		colorSliders = new JSlider[colorNames.length];
		for (int i = 0; i < colorSliders.length; i++) {
			colorSliders[i] = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
			colorSliders[i].setMajorTickSpacing(10);
			colorSliders[i].setPaintTicks(true);
			colorSliders[i].setName(colorNames[i].name());
			colorSliders[i].addChangeListener(listener);
			displaySlidersPanel.add(colorSliders[i]);
		}
		
		// Add all components to their respective panels
		// and display them on the appropriate location
		add(displayValuesPanel, BorderLayout.NORTH);
		add(displaySlidersPanel, BorderLayout.SOUTH);
		add(colorChooserAndDrawingMainJPanel, BorderLayout.CENTER);
		setJMenuBar(jMenuBar);
	}
	
	// Custom change listener that updates the text fields when
	// JSlider is moved
	private ChangeListener listener = new ChangeListener() {
		
		@Override
		public void stateChanged(ChangeEvent e) {
			for (int i = 0; i < colorSliders.length;i++) {
				colorTextFields[i].setText(String.valueOf(colorSliders[i].getValue()));
			}	
		}
	};
	
	// DocumentListener methods when text is inserted in the textfield
	@Override
	public void insertUpdate(DocumentEvent e) {
		changeColor();
	}

	// DocumentListener methods when text is removed from the textfield
	@Override
	public void removeUpdate(DocumentEvent e) {
		changeColor();
	}

	// DocumentListener methods when text is removed from the textfie
	@Override
	public void changedUpdate(DocumentEvent e) {
		changeColor();
	}
	
	// helper method to change the color of the rectangle
	private void changeColor() {
		try {
			// create valus fro the red, green, blue - to be updated later
			int r = 0, g = 0, b = 0;
	
			// go through all fields, grab the text, convert to integer and assign to color values
			for (JTextField textField : colorTextFields) {
				if (textField.getName() == RGB.RED.name())
					r = Integer.parseInt(textField.getText());
				else if (textField.getName() == RGB.GREEN.name())
					g = Integer.parseInt(textField.getText());
				else if (textField.getName() == RGB.BLUE.name())
					b = Integer.parseInt(textField.getText());
			}
			
			// create a color using the new values
			Color c = new Color(r, g, b);
			// repaint the rectangle, using the new color
			rectangle.setColor(c);
			paintPanel.setColor(c);
		} catch (Exception ex) {
			
		}
	}

	// Method that updates the color of the rectangle
	// and moves the JSlider position when the text field 
	// is updated and Enter is pressed
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < colorTextFields.length; i++) {
			if (e.getSource() == colorTextFields[i]) {
				colorSliders[i].setValue(Integer.parseInt(colorTextFields[i].getText()));
			}
		}

	}
	
}   


