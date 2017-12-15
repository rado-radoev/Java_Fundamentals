package com.youtube.gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class EmployeeSearchApp extends JFrame {

	private final JPanel searchPanel;
	private final JButton searchButton;
	private final JLabel lastNameLabel;
	private final JTextField lastNameTextField;
	private final JScrollPane tableScrollPane;
	private final JTable table;
	private final JPanel tablePanel;
	private EmployeeDAO dao;
	
	public EmployeeSearchApp() {
	
		super("Employee Search App");
		
		try {
			dao = new EmployeeDAO();
		} catch ( Exception e) {
			JOptionPane.showMessageDialog(this, "Error " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		FlowLayout searchPanelLayout = new FlowLayout(FlowLayout.CENTER);
		TextFieldHandler handler = new TextFieldHandler();
		searchPanel = new JPanel(searchPanelLayout);
		lastNameLabel = new JLabel("Enter Last Name");
		lastNameTextField = new JTextField(10);
		searchButton = new JButton("Search");
		searchButton.addActionListener(handler);
		
		searchPanel.add(lastNameLabel);
		searchPanel.add(lastNameTextField);
		searchPanel.add(searchButton);
		
		add(searchPanel, BorderLayout.NORTH);
		
		FlowLayout tablePanelLayout = new FlowLayout(FlowLayout.CENTER);
		tablePanel = new JPanel(tablePanelLayout);
		table = new JTable();
		tableScrollPane = new JScrollPane(table);
		tablePanel.add(tableScrollPane);
		
		add(tablePanel, BorderLayout.CENTER);
		
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private class TextFieldHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// get last name from text field
			String lastName = lastNameTextField.getText();
			
			List<Employee> employees = new ArrayList<Employee>();
			
			// call dao and get employees for the last name
			try {
				// if last name is empty then get all employees
				if (lastName == null || lastName.toLowerCase().equals("")) {
					employees = dao.getAllEmployees();
				} else {
					employees = dao.searchEmployees(lastName);	
				}
				
				// create the model and update the table
				EmployeeTableModel model = new EmployeeTableModel(employees);
				table.setModel(model);
				
// 				print out employees
//				for (Employee emp : employees) {
//					System.out.println(emp);		
//				}

				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}










