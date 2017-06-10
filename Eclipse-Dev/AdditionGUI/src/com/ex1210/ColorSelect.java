package com.ex1210;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JPanel;


public class ColorSelect extends JFrame {

	private final Font font;
	private final Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY, Color.DARK_GRAY, Color.MAGENTA, Color.GREEN, Color.ORANGE, Color.PINK,
			Color.RED, Color.WHITE, Color.YELLOW};
	private final String[] colorNames = {"Black", "Blue", "Cyan", "Gray", "Dark Gray", "Magenta", "Green", "Orange", "Pink", "Red", "White", "Yellow"};
	private final JCheckBox boldCheckBox;
	private final JCheckBox italicCheckBox;
	private final JButton ok;
	private final JButton cancel;
	private final JComboBox<String> colorList;
	private final JPanel colorsJPanel;
	private final JPanel checkBoxesJPanel;
	private final JPanel buttonsJPanel;
	
	public ColorSelect() {
		
		super("Color select");
		setLayout(new BorderLayout(0,0));
		
		boldCheckBox = new JCheckBox("Bold");
		italicCheckBox = new JCheckBox("Italic");
		checkBoxesJPanel = new JPanel(new FlowLayout());

		
		ButtonHandler bhandler = new ButtonHandler();
		ok = new JButton("OK");
		ok.addActionListener(bhandler);
		cancel = new JButton("Cancel");
		cancel.addActionListener(bhandler);
		buttonsJPanel = new JPanel(new FlowLayout());
		
		
		CheckBoxHandler handler = new CheckBoxHandler();
		colorList = new JComboBox<String>(colorNames);
		colorList.setPreferredSize(new Dimension(300, 18));
		add(new JScrollPane(colorList));
		colorList.addItemListener(handler);
		colorsJPanel = new JPanel(new FlowLayout());
		
		
		font = new Font("Serif", Font.PLAIN, 14);
		
		checkBoxesJPanel.add(boldCheckBox);
		checkBoxesJPanel.add(italicCheckBox);
		buttonsJPanel.add(ok);
		buttonsJPanel.add(cancel);
		colorsJPanel.add(colorList);
		
		
		add(colorsJPanel, BorderLayout.NORTH);
		add(checkBoxesJPanel, BorderLayout.CENTER);
		add(buttonsJPanel, BorderLayout.SOUTH);
	}

	private class CheckBoxHandler implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String color = e.getItem().toString();
				JComboBox cb = (JComboBox)e.getItem();
				int i = 0;
				for (; i < colorNames.length; i++) {
					if (colorNames[i].equals(color)) {
						break;
					}
				}
			}
			
		}
	}
	
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == ok) {
				JOptionPane.showMessageDialog(getParent(), "Color should be changed");
			}
			else if (e.getSource() == cancel) {
				JOptionPane.showMessageDialog(null, "this should close");
			}
			
		}
		
	}
}

































