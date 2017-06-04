package com.button;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Button extends JFrame {

	private final JTextField textfield;
	private final Font plainFont;
	private final Font boldFont;
	private final Font italicFont;
	private final Font boldItalicFont;
	private final JRadioButton plainJRadioButton;
	private final JRadioButton boldJRadioButton;
	private final JRadioButton italicJRadioButton;
	private final JRadioButton boldItalicJRadioButton;
	private final ButtonGroup radioGroup;
	
	public Button() {
		super("Radio button test");
		setLayout(new FlowLayout());
		
		textfield = new JTextField("Watch the font style change");
		add(textfield);
		
		// create radio buttons
		plainJRadioButton = new JRadioButton("Plain", true);
		boldJRadioButton = new JRadioButton("Bold", false);
		italicJRadioButton = new JRadioButton("Italic", false);
		boldItalicJRadioButton = new JRadioButton("Bold/Italic", false);
		add(plainJRadioButton);
		add(boldJRadioButton);
		add(italicJRadioButton);
		add(boldItalicJRadioButton);
		
		// add buttons to radio group
		radioGroup = new ButtonGroup();
		radioGroup.add(plainJRadioButton);
		radioGroup.add(boldJRadioButton);
		radioGroup.add(italicJRadioButton);
		radioGroup.add(boldItalicJRadioButton);
		
		// create font objects
		plainFont = new Font("Serif", Font.PLAIN, 14);
		boldFont = new Font("Serif", Font.BOLD, 14);
		italicFont = new Font("Serif", Font.ITALIC, 14);
		boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
		textfield.setFont(plainFont);	
		
		// register events for RadioButtons
		plainJRadioButton.addItemListener(new RadioButtonHandler(plainFont));
		boldJRadioButton.addItemListener(new RadioButtonHandler(boldFont));
		italicJRadioButton.addItemListener(new RadioButtonHandler(italicFont));
		boldItalicJRadioButton.addItemListener(new RadioButtonHandler(boldItalicFont));
	}
	
	
	// private inner class to handle radio buttons
	private class RadioButtonHandler implements ItemListener {
		private Font font;
		
		public RadioButtonHandler(Font font) {
			this.font = font;
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			textfield.setFont(font);
			
		}
	}
}









