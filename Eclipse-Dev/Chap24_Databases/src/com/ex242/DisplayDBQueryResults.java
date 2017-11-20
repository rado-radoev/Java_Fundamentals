package com.ex242;
// display the results of queries ran against the books database

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;



public class DisplayDBQueryResults extends JFrame {

	private static final String DATABASE = "jdbc:derby:" + 
			JOptionPane.showInputDialog(null, "EnterDatabase", "books");
	
	private static DBQueries tableModel = new DBQueries(DATABASE);
}
