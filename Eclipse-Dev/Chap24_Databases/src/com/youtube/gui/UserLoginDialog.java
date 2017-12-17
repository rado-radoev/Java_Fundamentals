package com.youtube.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

public class UserLoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final JPanel mainPanel = new JPanel();
	private JComboBox<String[]> userNamesComboBox = new JComboBox<String[]>();
	private JLabel userLabel = new JLabel("User");
	private JLabel password = new JLabel("Password");
	private JPasswordField passwordField = new JPasswordField();
	private EmployeeDAO employeeDAO;

	public void populateUsers(List<User> users) {
		userNamesComboBox.setModel(new DefaultComboBoxModel(users.toArray(new User[0])));
	}
	
	/**
	 * Create the dialog.
	 */
	public UserLoginDialog() {
		
		User u = new User(5, "peshteradko", "radko", "radko.piratko@gmail.com");
		
		addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		try {
			employeeDAO = new EmployeeDAO(u);
			populateUsers(employeeDAO.getUsers());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setBounds(100, 100, 300, 120);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.SOUTH);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(
						new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// get the user id
								if (userNamesComboBox.getSelectedIndex() == -1) {						
									JOptionPane.showMessageDialog(UserLoginDialog.this, "You must select a user.", "Error", JOptionPane.ERROR_MESSAGE);				
									return;
								}
								
								User user = (User) userNamesComboBox.getSelectedItem();
								int userId = user.getId();
								
								// get the password
								char[] password = passwordField.getPassword();
								
								// hide the login window
								setVisible(false);
								dispose();
								
								// show the main app window
								EmployeeSearchApp empSearchApp = new EmployeeSearchApp(userId, employeeDAO);
								empSearchApp.setLoggedInUserName(user.getFirstName(), user.getLastName());
								
								empSearchApp.setVisible(true);
							}
						});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		GridLayout mainPanelLayout = new GridLayout(2, 2, 5, 5);
		mainPanel.setLayout(mainPanelLayout);	
		mainPanel.add(userLabel);
		mainPanel.add(userNamesComboBox);
		mainPanel.add(password);
		mainPanel.add(passwordField);
		
		getContentPane().add(mainPanel, BorderLayout.CENTER);
	}

}
