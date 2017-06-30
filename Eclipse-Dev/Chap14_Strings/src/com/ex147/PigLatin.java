package com.ex147;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class PigLatin extends JFrame implements ActionListener, KeyListener {
	
	// assign attributes
	private final JPanel userInputPanel;
	private final JButton ok;
	private final JButton clear;
	private final JLabel textLabel;
	private final JTextArea convertedSentancesTextArea;
	private final JTextField userTextInput;
	private final JScrollPane scroller;
	private ArrayList<String> convertedStringsArray;
	
	public PigLatin() {
		// set title
		super("PigLating translator");
			
		// crate JPanel that will hold the Label, TextField, and the two buttons
		userInputPanel = new JPanel(new FlowLayout());
		
		// setting up the label
		textLabel = new JLabel("Enter sentance");
		userInputPanel.add(textLabel);
		
		// setting up the text field
		userTextInput = new JTextField(20);
		userInputPanel.add(userTextInput);
		
		// setting up the buttons and adding the actionlistener
		ok = new JButton("OK");
		clear = new JButton("Clear");
		ok.addActionListener(this);
		clear.addActionListener(this);
		userInputPanel.add(ok);
		userInputPanel.add(clear);
		
		// setting up the text area that will hold all the sentances and adding it to a scrollbar
		convertedSentancesTextArea = new JTextArea();
		convertedSentancesTextArea.setEditable(false);
		convertedSentancesTextArea.setFont(new Font("Serif", Font.PLAIN, 14));
		convertedSentancesTextArea.setLineWrap(true);
		scroller = new JScrollPane(convertedSentancesTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroller.setPreferredSize(new Dimension(50,200));
		add(scroller, BorderLayout.SOUTH);
		
		add(userInputPanel, BorderLayout.CENTER);
		
		userTextInput.addKeyListener(this);
		
	}

	// overriding the action perfomed method for the OK and Clear buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			convertedSentancesTextArea.append(translateSentance(userTextInput.getText()) + "\n");
		}
		else if (e.getSource() == clear) {
			userTextInput.setText("");
		}
		
	}
	
	 /**
	  * <p>Accept a sentance send as a string. The string of text
	  * is then splitted into separate words. Separation is done
	  * by looking for empty spaces. Each word is passed to a helper 
	  * method <a href="#printLatinWord">pigLatinWord</a>. The outputed word
	  * is converted to pig latin and assigned back to the array 
	  * created in method translateSentace.
	  * When there are no more words. The array is converted to 
	  * a string and returned to the calling method.</p>

     * @param    sentance   the sentance
     * @see      #printLatinWord
     * @since    JDK1.1
     * @return	 <strong>String</strong> 	the converted string
     */
	private String translateSentance (String sentance) {
		String[] tempArr;
		tempArr = sentance.split(" ");
		for (int i = 0; i < tempArr.length;i++) {
			tempArr[i] = printLatinWord(tempArr[i]) + " ";
		}
		
		StringBuilder sb = new StringBuilder();;
		for (String s : tempArr) {
			sb.append(s + " ");
		}
		return sb.toString();
	}

	/**
	 * <a name="printLatinWord"></a>
	 * <p> This is helper method. It accepts a string, a single word
	 * Then it creates a substring starting from position 1 until the end of the
	 * string. The first letter is then appended to the end of the word and
	 * "ay" is also added to the word. 
	 * </p>
	 * <pre>
	 *    jump -> umpjay
	 *    the -> hetay
	 * </pre>
	 * 
	 * @param	word 	to convert as a String
	 * @return	<strong>String</strong>		converted word as a String
	 * */
	private String printLatinWord(String word) {
		return word.substring(1).concat(String.valueOf(word.charAt(0))).concat("ay"); 
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			ok.doClick();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}




































