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
	
	private static JButton submitQueryButton;
	private static JButton cancelButton;
	private static JButton clearButton;
	private static JButton filterButton;
	private static JComboBox<String> predefinedQueriesJComboBox;
	private static JTextArea queryArea;
	private static JTable resultTable;
	private static JLabel filterLabel;
	private static JTextField filterTextField;
	private QueryWorker query;
	
	public static void main(String[] args) {
		
		// create ResulTableModel and display database
		try {
			// create TableModel
			tableModel = new DBQueries(DATABASE, "authors");

			// combobox handler
			ComboBoxHandler comboBoxHandler = new ComboBoxHandler();
			
			// setup JComboBox that will contain the predefined queries
			// and add it to a JScrollPane
			predefinedQueriesJComboBox = new JComboBox<String>(predefinedQueries);
			predefinedQueriesJComboBox.addActionListener(comboBoxHandler);
			JScrollPane predefinedQueriesJScrollPane = new JScrollPane(predefinedQueriesJComboBox, 
					ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			
			// Text Area in which user can type queries
			queryArea = new JTextArea(3, 100);
			queryArea.setWrapStyleWord(true);
			queryArea.setLineWrap(true);
			
			// Setup buttons
			// Button handler
			ButtonHandler buttonHandler = new ButtonHandler();
			submitQueryButton = new JButton("Submit Query");
			submitQueryButton.addActionListener(buttonHandler);
			cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(buttonHandler);
			clearButton = new JButton("Clear");
			clearButton.addActionListener(buttonHandler);
			
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
			JTable resultTable = new JTable(tableModel);
			
			// create filter section
			filterLabel = new JLabel("Filter: ");
			filterTextField = new JTextField();
			filterButton = new JButton("Apply Filter");
			
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
			
			// set default index for combo box
			predefinedQueriesJComboBox.setSelectedIndex(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		final TableRowSorter<TableModel> sorter = 
				new TableRowSorter<TableModel>(tableModel);
		resultTable.setRowSorter(sorter);
	}
	
	private static class ComboBoxHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String query = (String)predefinedQueriesJComboBox.getSelectedItem();
			if (query.
					toLowerCase().
					contains("authors")) {
				queryArea.setText("SELECT * FROM Authors");
			}
		}
		
	}
	
	private static class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			String query = queryArea.getText();
			if (event.getSource() == submitQueryButton) {
				// if combo box with title is selected
				if (String.valueOf(predefinedQueriesJComboBox.getSelectedItem()).
						toLowerCase().
						contains("authors")) {
					tableModel = new DBQueries(DATABASE, "authors");
				}
				else if (String.valueOf(predefinedQueriesJComboBox.getSelectedItem()).
						toLowerCase().
						contains("title")) {
					tableModel.getBooksByTitle(query);
				}
				// if combo box with Author is selected
				else if (String.valueOf(predefinedQueriesJComboBox.getSelectedItem()).
						toLowerCase().
						contains("author")) {
					tableModel.getBooksByAuthor(query);
				}
				// if combo box with Year is selected
				else if (String.valueOf(predefinedQueriesJComboBox.getSelectedItem()).
						toLowerCase().
						contains("year")) {
					tableModel.getBooksByYear(query);
				}
			}
			else if (event.getSource() == cancelButton) {
				JOptionPane.showMessageDialog(null, "Cancel button not implemented");
			}
			else if (event.getSource() == clearButton) {
				// reset query
				predefinedQueriesJComboBox.setSelectedIndex(0);
				queryArea.setText("");
				resultTable.clearSelection();
			}			
		}
	}
}



















