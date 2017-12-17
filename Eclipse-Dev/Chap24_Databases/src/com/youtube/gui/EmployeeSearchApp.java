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
	private final JButton showHistoryButton;
	private final EmployeeDAO dao;
	private int userId;
	JLabel loggedInUserLabel = new JLabel("New label");
	JLabel loggedInLabel = new JLabel("Logged in:");
	private User user;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public EmployeeSearchApp(int userId, EmployeeDAO employeeDAO) {

		super("Employee Search App");

		
		this.userId = userId;
		this.dao = employeeDAO;
		
		AuditHistory ah = new AuditHistory(userId, employeeId, action, actionDateTime, userFirstName, userLastName)

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
		
		
		searchPanel.add(loggedInLabel);
		
		
		searchPanel.add(loggedInUserLabel);
		
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
		showHistoryButton = new JButton("Show History");
		manipulateDBPanel.add(showHistoryButton);
		showHistoryButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				// make sure a row is selected
				if (row < 0) {
					JOptionPane.showMessageDialog(EmployeeSearchApp.this, "You must select an employee", "Error",
							JOptionPane.ERROR_MESSAGE);				
					return;
				}
				
				// get the current employee
				Employee tempEmployee = (Employee) table.getValueAt(row, EmployeeTableModel.OBJECT_COL);
				
				try {
					// get audit history for this employee
					int employeeId = tempEmployee.getId();
					List<AuditHistory> auditHistoryList = employeeDAO.getAuditHistory(employeeId);

					// show audit history dialog
					AuditHistoryDialog dialog = new AuditHistoryDialog();
					dialog.populate(tempEmployee, auditHistoryList);
					
					dialog.setVisible(true);
				}
				catch (Exception exc) {
					exc.printStackTrace();
					JOptionPane.showMessageDialog(EmployeeSearchApp.this, "Error retrieving audit history", "Error",
							JOptionPane.ERROR_MESSAGE);				
					return;					
				}
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
	
	public void setLoggedInUserName(String firstName, String lastName) {
		loggedInUserLabel.setText(firstName + " " + lastName);
	}
}










