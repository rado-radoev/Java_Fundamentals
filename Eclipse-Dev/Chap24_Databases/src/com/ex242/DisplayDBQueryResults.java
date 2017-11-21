package com.ex242;
// display the results of queries ran against the books database

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextArea;
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

	private static final String DATABASE = "jdbc:derby:books";
	private static final String DEFAULT_QUERY = "SELECT * FROM Authors";
	private static DBQueries tableModel;
	private static String[] predefinedQueries = {"All Authors",
			"Books by Author",
			"Books by Title",
			"Books by Year"};
	
	public static void main(String[] args) {
		
		// create ResulTableModel and display database
		try {
			// create TableModel
			tableModel = new DBQueries(DATABASE);

			// setup JComboBox that will contain the predefined queries
			// and add it to a JScrollPane
			JComboBox<String> predefinedQueriesJComboBox = new JComboBox<String>(predefinedQueries);
			JScrollPane predefinedQueriesJScrollPane = new JScrollPane(predefinedQueriesJComboBox, 
					ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			
			// Text Area in which user can type queries
			JTextArea queryArea = new JTextArea(3, 100);
			queryArea.setWrapStyleWord(true);
			queryArea.setLineWrap(true);
			
			// Setup two buttons
			JButton submitQueryButton = new JButton("Submit Query");
			JButton cancelButton = new JButton("Cancel");
			JButton clearButton = new JButton("Clear");
			
			// Create a box to manage placement of combo box and text area
			Box boxNorth = Box.createVerticalBox();
			boxNorth.add(predefinedQueriesJScrollPane);
			boxNorth.add(queryArea);
			
			// Create a horizontal box to hold the 3 buttons
			Box boxNorthInner = Box.createHorizontalBox();
			boxNorthInner.add(submitQueryButton);
			boxNorthInner.add(cancelButton);
			boxNorthInner.add(clearButton);
			
			// add inner box to main north box
			boxNorth.add(boxNorthInner);
			
			// create JTable based on tableModel
			JTable resultTable = new JTable();
			
			// create filter section
			JLabel filterLabel = new JLabel("Filter: ");
			JTextField filterTextField = new JTextField();
			JButton filterButton = new JButton("Apply Filter");
			
			// create south box for filter section
			Box boxSouth = Box.createHorizontalBox();
			
			boxSouth.add(filterLabel);
			boxSouth.add(filterTextField);
			boxSouth.add(filterButton);
			
			// create GUI JFrame
			JFrame window = new JFrame("Display Query Results");
			window.add(boxNorth, BorderLayout.NORTH);
			window.add(new JScrollPane(resultTable), BorderLayout.CENTER);
			window.add(boxSouth, BorderLayout.SOUTH);
			
			window.setVisible(true);
			window.setSize(500, 250);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}



















