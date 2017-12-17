package com.youtube.gui;

import java.sql.SQLException;
import javax.swing.JFrame;

public class MainApp {

	public static void main(String[] args) throws SQLException {
//		EmployeeDAO dao = new EmployeeDAO();
//		System.out.println(dao.searchEmployees("thom"));
//		System.out.println(dao.getAllEmployees());

		UserLoginDialog frame = new UserLoginDialog();
		frame.setVisible(true);
	}

}
