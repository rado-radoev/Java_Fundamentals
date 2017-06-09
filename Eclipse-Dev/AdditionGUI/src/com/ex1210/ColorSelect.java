package com.ex1210;

import java.awt.FlowLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;


public class ColorSelect extends JFrame {

	private final Font font;
	private final Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY, Color.DARK_GRAY, Color.MAGENTA, Color.GREEN, Color.ORANGE, Color.PINK,
			Color.RED, Color.WHITE, Color.YELLOW};
	private final String[] colorNames = {"Black", "Blue", "Cyan", "Gray", "Dark Gray", "Magenta", "Green", "Orange", "Pink", "Red", "White", "Yellow"};
	private final JCheckBox boldCheckBox;
	private final JCheckBox italicCheckBox;
	private final JButton ok;
	private final JButton cancel;
	private final JList colorList;
	
	public ColorSelect() {
		super("Color select");
		setLayout(new FlowLayout());
		
		boldCheckBox = new JCheckBox("Bold");
		italicCheckBox = new JCheckBox("Italic");
		
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		
		
	}

}

































