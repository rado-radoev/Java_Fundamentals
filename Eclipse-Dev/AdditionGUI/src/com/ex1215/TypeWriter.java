package com.ex1215;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TypeWriter extends JFrame {
	
	//private final JTextArea textArea;
	private final JButton[] letterButtons = new JButton[60]; // array that will contain the number of letters from z to a
	private final Character[] chars = new Character[letterButtons.length];
	private final String firstRow[] = {"~","1","2","3","4","5","6","7","8","9","0","-","+","Backspace"};
	private final String secondRow[] = {"Tab","Q","W","E","R","T","Y","U","I","O","P","[","]","\\"};
	private final String thirdRow[] = {"Caps","A","S","D","F","G","H","J","K","L",":","\"","Enter"};
	private final String fourthRow[] = {"Shift","Z","X","C","V","B","N","M",",",".","?","   ^" };
	private final String fifthRow[]={"      " ,"<" ,"\\/",">" };
	private final JPanel keyboard;
	
	public TypeWriter()	 {
		super("TypeWriter");
		setLayout(new FlowLayout());
				
		for (int i = 0; i < firstRow.length;i++) {
			
		}
	}
}
