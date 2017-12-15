package com.youtube.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AddEmployeeForm extends JFrame {

	private final JPanel mainPanel;
	private final JLabel firstNameLabel;
	private final JLabel lastNameLabel;
	private final JLabel emailLabel;
	private final JLabel salaryLabel;
	private final JTextField firstNameTextField;
	private final JTextField lastNameTextFieldd;
	private final JTextField emailTextFieldd;
	private final JTextField salaryTextFieldd;
	private final JButton saveButton;
	private final JButton cancelButton;
	
	public AddEmployeeForm() {
		super("Add Employee");
		
		mainPanel = new JPanel();
		
		firstNameLabel = new JLabel("First Name");
		lastNameLabel = new JLabel("Last Name");
	}
}
