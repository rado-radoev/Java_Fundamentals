package com.ex149_1412;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class StringManupulation extends JPanel implements ActionListener, KeyListener, ItemListener {
	
	private final FlowLayout flowLayout;
	private final JPanel userInputRevers;
	private final JPanel userInputSearch;
	private final JPanel stringAletrationOptions;
	private final JPanel textAreaPanel;
	private final JButton buttonReverse;
	private final JButton buttonSearch;
	private final JButton buttonClear;
	private final JCheckBox checkBoxUpperCase;
	private final JCheckBox checkBoxLowerCase;
	private final JScrollPane scroller;
	private final JLabel userLabelReverse;
	private final JLabel userLabelSearch;
	private final JTextField userTextFieldReverse;
	private final JTextField userTextFIeldSearch;
	private final JTextArea textArea;
	private DrawString strToDraw;
	private static String returnedString = "";
	

	public StringManupulation() {
		
		flowLayout = new FlowLayout();
		userInputRevers = new JPanel();
		userInputSearch = new JPanel();
		stringAletrationOptions = new JPanel();
		textAreaPanel = new JPanel();
		buttonReverse = new JButton("Reverse");
		buttonSearch = new JButton("Search");
		buttonClear = new JButton("Clear");
		checkBoxUpperCase = new JCheckBox("UppserCase", false);
		checkBoxLowerCase = new JCheckBox("LowerCase", false);
		checkBoxLowerCase.addItemListener(this);
		checkBoxUpperCase.addItemListener(this);
		
		userLabelReverse = new JLabel("String to reverse:");
		userLabelSearch = new JLabel("Character to search for:");
		userTextFieldReverse = new JTextField(20);
		userTextFIeldSearch = new JTextField(1);
		textArea = new JTextArea();
		strToDraw = new DrawString();
		
		userInputRevers.add(userLabelReverse, flowLayout);
		userInputRevers.add(userTextFieldReverse, flowLayout);
		userInputRevers.add(buttonReverse, flowLayout);
		buttonReverse.addActionListener(this);
		
		userInputSearch.add(userLabelSearch, flowLayout);
		userInputSearch.add(userTextFIeldSearch, flowLayout);
		userInputSearch.add(buttonSearch, flowLayout);
		buttonSearch.addActionListener(this);
		
		stringAletrationOptions.add(buttonClear, flowLayout);
		buttonClear.addActionListener(this);
		
		stringAletrationOptions.add(checkBoxLowerCase, flowLayout);
		stringAletrationOptions.add(checkBoxUpperCase, flowLayout);
		
		//textAreaPanel.add(strToDraw);
		
		textArea.setVisible(true);
		textArea.setFont(new Font("Serif", Font.PLAIN, 14));
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setForeground(Color.BLACK);
		scroller = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setVisible(true);
		scroller.setPreferredSize(new Dimension(300,200));
		textAreaPanel.add(scroller, flowLayout);
		
		add(userInputRevers, flowLayout);
		add(userInputSearch, flowLayout);
		add(stringAletrationOptions, flowLayout);
		add(textAreaPanel, flowLayout);
		
		

	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (checkBoxLowerCase.isSelected() && checkBoxUpperCase.isSelected()) {
			checkBoxUpperCase.setSelected(false);
			checkBoxLowerCase.setSelected(false);
		}
		else if (checkBoxLowerCase.isSelected()) {
			userTextFieldReverse.setText(userTextFieldReverse.getText().toLowerCase());
		}
		else if (checkBoxUpperCase.isSelected()) {
			userTextFieldReverse.setText(userTextFieldReverse.getText().toUpperCase());
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	// TO DO: Not working!!!
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER && userTextFieldReverse.isFocusOwner())  {
			buttonReverse.doClick();
		}
		else if (e.getKeyCode() == KeyEvent.VK_ENTER && userTextFIeldSearch.isFocusOwner()) {
			buttonSearch.doClick();
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonReverse) {
			reverseText(userTextFieldReverse.getText());
			textArea.append(getReversedString() + "\n");
		}
		else if (e.getSource() == buttonClear) {
			textArea.setText("");
		}
		else if (e.getSource() == buttonSearch) {
			// if the search button is pressed
			if (userTextFIeldSearch.getText().length() > 0) {	// check to see if the lenght of the field contains any letters
				textArea.append(countChars(userTextFieldReverse.getText(), userTextFIeldSearch.getText().charAt(0))); 	// if it does grab the first char search how many times is appears in the string
			}
			else {
				textArea.append(countAllChars(userTextFieldReverse.getText()));	// we count each char occurance in the string.
			}

		
		}
		
	}
	
	public static String getReversedString() {
		return returnedString;
	}
	
	private void reverseText (String text) {	
		// SB to hold the newly generated string
		StringBuilder sb = new StringBuilder();
		
		String[] splittedText = text.split(" ");
		for (int i = splittedText.length - 1; i >= 0; i--) {
			sb.append(splittedText[i].concat(" "));
		}
		returnedString = sb.toString();
	}
	
	private String countChars(String text, char c) {
		int[] chars = new int[128];
		text = text.toLowerCase();
		
		int start = text.indexOf(c, 0);
		while (start > -1) {
			chars[c]++;
			start = text.indexOf(c, start + 1);
		}

		return String.format("Character %s, found: %d times%n", Character.valueOf(c), chars[c]);
	}


	private String countAllChars(String text) {
		int[] chars = new int[128];
		boolean[] found = new boolean[128];
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < text.length(); i++) {	// loop through each letter
			if (!found[text.charAt(i)]) {	// if letter is already added found, skip it
				int start = text.indexOf(text.charAt(i), 0);	// get the index of the first occurance of the letter
				while (start > -1) {	// loop until there are no more occurances of the letter
					chars[text.charAt(i)]++;	// when the letter is encountered, increment the array index, corresponding to that letter		
					start = text.indexOf(text.charAt(i), start + 1);	// search for the next occurance or exit loop
				}
			}
			found[text.charAt(i)] = true;	// set the array that the letter has already been found, so next time it can be skipped, otherwise
			//	multiple occurances of the same letter will appear in the output
		}
		
		// loop thorught the array by skypping everything but letters
		// output the letter and how many times it was found
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] > 0 && // check if the current index is not 0
					((i >= 65 && i <= 90) ||	// and check if the index is in the ASCII letter range
					(i >=97 && i <= 122))) {	// 65-90 for uppercase 97-122 for lower case
								
				sb.append(String.format("Chacacter %s, found: %d times.%n", (char)i, chars[i]));
			}
		}
		
		return sb.toString();
	}

	
}





















