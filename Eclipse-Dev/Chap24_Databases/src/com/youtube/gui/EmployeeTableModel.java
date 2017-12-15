package com.youtube.gui;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class EmployeeTableModel extends AbstractTableModel {
	
	private static final int LAST_NAME_COL = 0;
	private static final int FIRST_NAME_COL = 1;
	private static final int EMAIL_COL = 2;
	private static final int SALARY_COL = 3;
	
	private String[] columnNames = {"Last Name", "First Name", "Email", "Salary"};
	private List<Employee> employees;
	
	public EmployeeTableModel(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public int getRowCount() {
		return employees.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int column) {
		Employee empTemp = employees.get(row);
		
		switch (column) {
		case LAST_NAME_COL:
			return empTemp.getLastName();
		case FIRST_NAME_COL:
			return empTemp.getFirstName();
		case EMAIL_COL:
			return empTemp.getEmail();
		case SALARY_COL:
			return empTemp.getSalary();
		default:
			return empTemp.getLastName();
		}
	}

	@Override
	public Class getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}
}
