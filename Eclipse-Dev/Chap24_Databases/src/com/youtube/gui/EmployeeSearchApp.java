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
import javax.swing.table.TableModel;
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
	private final JPanel manipulateDBPanel;
	private final JButton addEmployeeButton;
	private final JButton updateEmployeeButton;
	private final EmployeeDAO dao;
	
	public EmployeeSearchApp() {
	
		super("Employee Search App");
		

		dao = new EmployeeDAO();

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
		
		FlowLayout manipulateDBPanelLayout = new FlowLayout(FlowLayout.CENTER);
		manipulateDBPanel = new JPanel(manipulateDBPanelLayout);
		addEmployeeButton = new JButton("Add Employee");
		manipulateDBPanel.add(addEmployeeButton);
		addEmployeeButton.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						AddEmployeeForm addEmployee = new AddEmployeeForm(EmployeeSearchApp.this, dao);
						addEmployee.setVisible(true);
					}
				});
		updateEmployeeButton = new JButton("Update Employee");
		manipulateDBPanel.add(updateEmployeeButton);
		updateEmployeeButton.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int row = table.getSelectedRow();
						Employee tempEmployee = (Employee) table.getValueAt(row, EmployeeTableModel.OBJECT_COL);
						UpdateEmployeeForm updateEmpFm = new UpdateEmployeeForm(EmployeeSearchApp.this, dao, tempEmployee);
						updateEmpFm.setVisible(true);
					}
				});
		add(manipulateDBPanel, BorderLayout.SOUTH);
	}
	
	public void refreshEmployeeView() {
		try {
			List<Employee> employees = dao.getAllEmployees();
			
			// create the model and update the table
			EmployeeTableModel model = new EmployeeTableModel(employees);
			
			table.setModel(model); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
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










