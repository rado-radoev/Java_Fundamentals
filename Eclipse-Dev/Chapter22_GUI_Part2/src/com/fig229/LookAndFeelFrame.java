package com.fig229;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class LookAndFeelFrame extends JFrame {

	private final UIManager.LookAndFeelInfo[] looks;
	private final String[] lookNames; // look-and-feel names
	private final JRadioButton[] radio; // for selecting look-and-feel
	private final ButtonGroup group;  // group for radio buttons
	private final JButton button;  // displays look of button
	private final JLabel label;	 // display look of label
	private final JComboBox<String> comboBox; // dispalys look of combo box
	
	public LookAndFeelFrame() {
		super("Look and Feel Demo");
		
		// get installed look-and-feel information
		looks = UIManager.getInstalledLookAndFeels();
		lookNames = new String[looks.length];
		
		// get names of installed look-and-feels
		for (int i = 0; i < looks.length; i++) {
			lookNames[i] = looks[i].getName();
		}
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(3, 1, 0, 5));
		
		label = new JLabel("This is a " + lookNames[0] + " look-and-feel", SwingConstants.CENTER);
		northPanel.add(label);
	
		button = new JButton("JButton");
		northPanel.add(button);
		
		// create array for radio buttons
		radio = new JRadioButton[looks.length];
		
		comboBox = new JComboBox<String>(lookNames);
//		comboBox.addActionListener(
//			event -> {for (int i = 0; i < lookNames.length; i++) {
//				label.setText(String.format("This is a %s look-and-feel", lookNames[i]));
//				radio[i].setSelected(true);
//				changeLookAndFeel(i);  // change look-and-feel
//			}}
//			);
		northPanel.add(comboBox);
		

		
		JPanel southPanel = new JPanel();
		
		// use a GridLayout with 3 buttons in each row
		int rows = (int) Math.ceil(radio.length / 3.0);
		southPanel.setLayout(new GridLayout(rows, 3));
	
		
		group = new ButtonGroup(); // button group for look-and-feels
		ItemHandler handler = new ItemHandler();  // look-and-feels handler
		
		for (int i = 0; i < radio.length; i++) {
			radio[i] = new JRadioButton(lookNames[i]);
			radio[i].addItemListener(handler);  // add handler
			group.add(radio[i]); // add radio button to group
			southPanel.add(radio[i]);  // add radio button to panel
		}
		
		
		add(northPanel, BorderLayout.NORTH);  // add north panel
		add(southPanel, BorderLayout.SOUTH);  // add south panel
		
		radio[0].setSelected(true);
	} // end look and feel construcotr
	
	// use UIManager to change look-and-feel of GUI
	private void changeLookAndFeel(int value) {
		try {
			// change look and feel
			// set look-and-feel for this application
			UIManager.setLookAndFeel(looks[value].getClassName());
			
			// update components in this application
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// private inner class ItemHandler to handle radio button events
	private class ItemHandler implements ItemListener {
		// process user's look-and-feel selection
		@Override
		public void itemStateChanged(ItemEvent event) {
			for (int i = 0; i < radio.length; i++) {
				if (radio[i].isSelected()) {
					label.setText(String.format("This is a %s look-and-feel", lookNames[i]));
					comboBox.setSelectedIndex(i); // set combobox index
					changeLookAndFeel(i);  // change look-and-feel
				}
			}
		}
	}
}






















