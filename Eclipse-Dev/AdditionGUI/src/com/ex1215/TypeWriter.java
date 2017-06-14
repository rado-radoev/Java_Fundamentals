package com.ex1215;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.LayoutFocusTraversalPolicy;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardEndHandler;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class TypeWriter extends JFrame {
	
	//private final JTextArea textArea;
	private final JButton[] letterButtons; // array that will contain the number of letters from z to a
	//private final JPanel[] buttonsJPanel;
	private final JPanel keyboardPanel;
	private final JPanel keyboardPanel2;
	private final JPanel keyboardPanel3;
	private final JPanel keyboardPanel4;
	private final JPanel keyboardPanel5;
	private final String keys[] = {"~","1","2","3","4","5","6","7","8","9","0","-","+","Backspace"};
	private final String keys2[] = {"Tab","Q","W","E","R","T","Y","U","I","O","P","[","]","\\"};
	private final String keys3[] = {"Caps","A","S","D","F","G","H","J","K","L",":","\"","Enter"};
	private final String keys4[] = {"Shift","Z","X","C","V","B","N","M",",",".","?","Shift" };
	private final String keys5[]={"      Space     " ,"<" ,"\\/",">" };
	private final FlowLayout layout;
	
	public TypeWriter()	 {
		super("TypeWriter");
		layout = new FlowLayout(FlowLayout.CENTER, -5, -5);
		setLayout(layout);
		
		keyboardPanel = new JPanel();
		keyboardPanel.add(Box.createRigidArea(new Dimension(150,0)));
		keyboardPanel2 = new JPanel();
		keyboardPanel2.add(Box.createRigidArea(new Dimension(150,0)));
		keyboardPanel3 = new JPanel();
		keyboardPanel3.add(Box.createRigidArea(new Dimension(150,0)));
		keyboardPanel4 = new JPanel();
		keyboardPanel4.add(Box.createRigidArea(new Dimension(150,0)));
		keyboardPanel5 = new JPanel();
		keyboardPanel5.add(Box.createRigidArea(new Dimension(150,0)));
		
		letterButtons = new JButton[keys.length + keys2.length + keys3.length + keys4.length + keys5.length];
		
		
		for (int i = 0; i < keys.length;i++) {
			letterButtons[i] = new JButton(keys[i]);
			keyboardPanel.add(letterButtons[i]);
		}
		
		for (int i = 0; i < keys2.length;i++) {
			letterButtons[keys.length - i - 1] = new JButton(keys2[i]);
			keyboardPanel2.add(letterButtons[keys.length - i - 1]);
		}
		
		for (int i = 0; i < keys3.length;i++) {
			letterButtons[(keys.length + keys2.length) - i - 2] = new JButton(keys3[i]);
			keyboardPanel3.add(letterButtons[(keys.length + keys2.length) - i - 2]);
		}
		
		for (int i = 0; i < keys4.length;i++) {
			letterButtons[(keys.length + keys2.length + keys3.length) - i - 3] = new JButton(keys4[i]);
			keyboardPanel4.add(letterButtons[(keys.length + keys2.length + keys3.length) - i - 3]);
		}
		
		
		for (int i = 0; i < keys5.length;i++) {
			letterButtons[(keys.length + keys2.length + keys3.length + keys4.length) - i - 4] = new JButton(keys5[i]);
			keyboardPanel5.add(letterButtons[(keys.length + keys2.length + keys3.length + keys4.length) - i - 4]);
		}
		

		add(keyboardPanel, new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(keyboardPanel2, new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(keyboardPanel3, new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(keyboardPanel4, new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(keyboardPanel5, new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}


}
















































//private final String firstRow[] = {"~","1","2","3","4","5","6","7","8","9","0","-","+","Backspace"};
//private final String secondRow[] = {"Tab","Q","W","E","R","T","Y","U","I","O","P","[","]","\\"};
//private final String thirdRow[] = {"Caps","A","S","D","F","G","H","J","K","L",":","\"","Enter"};
//private final String fourthRow[] = {"Shift","Z","X","C","V","B","N","M",",",".","?","   ^" };
//private final String fifthRow[]={"      " ,"<" ,"\\/",">" };
//private final String keys[] = {"~","1","2","3","4","5","6","7","8","9","0","-","+","Backspace",
//		"Tab","Q","W","E","R","T","Y","U","I","O","P","[","]","\\",
//		"Caps","A","S","D","F","G","H","J","K","L",":","\"","Enter",
//		"Shift","Z","X","C","V","B","N","M",",",".","?","Shift", "^",
//		"Space", "<", "\\/", ">"};


