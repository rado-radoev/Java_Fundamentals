package com.ex243;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class ChashedRowSetGUI extends JFrame {

	private JButton prevButton;
	private JTextField currIndexTextField;
	private JLabel ofLabel;
	private JTextField maxIndexTextField;
	private JButton nextButton;
	private JLabel authorIDLabel;
	private JTextField authorIDTextField;
	private JLabel firstNameLabel;
	private JTextField firstNameTextField;
	private JLabel lastNameLabel;
	private JTextField lastNameTextField;
	private JLabel titleLabel;
	private JTextField titleTextField;
	private JLabel editionNumberLabel;
	private JTextField editionNumberTextField;
	private JLabel copyrightLabel;
	private JTextField copyrightTextField;
	private JComboBox dbTableComboBox;
	private String[] dbTableList = {"Authors", "AuthorISBN", "Titles"};
	private JScrollPane dbTableListScrollPane;
	private JButton browseAllButton;
	private JButton updateButton;
	private JButton insertButton;
	

	public ChashedRowSetGUI() {
		super("Authors Database");
		
	
		
	}

}













