package com.ex243;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;

import org.apache.derby.impl.store.replication.slave.SlaveController;

import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.concurrent.SynchronousQueue;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.sql.RowSet;

public class ChashedRowSetGUI extends JFrame {
		
	private JButton prevButton;
	private JTextField currIndexTextField;
	private JLabel ofLabel;
	private JTextField maxIndexTextField;
	private JButton nextButton;
	private JLabel authorIDLabel;
	private JTextField authorIDTextField;
	private JLabel firstNameLabel;
	private JTextField firstNameTextField;
	private JLabel lastNameLabel;
	private JTextField lastNameTextField;
	private JLabel isbnLabel;
	private JTextField isbnTextField;
	private JLabel titleLabel;
	private JTextField titleTextField;
	private JLabel editionNumberLabel;
	private JTextField editionNumberTextField;
	private JLabel copyrightLabel;
	private JTextField copyrightTextField;
	private JComboBox dbTableComboBox;
	private String[] dbTableList = {"Authors", "AuthorISBN", "Titles"};
	private JScrollPane dbTableListScrollPane;
	private JButton browseAllButton;
	private JButton updateButton;
	private JButton insertButton;
	private final JPanel navigationPanel;
	private final JPanel displayPanel;
	private final JPanel queryPanel;
	
	private CashedRowSetQuery cashedRowSetQuery;
	private long currentIndex;
	private long numberOfEntries;
	private RowSet rowSet;

	public ChashedRowSetGUI() {
		super("Authors Database");
		
		prevButton = new JButton();
		currIndexTextField = new JTextField(2);
		ofLabel = new JLabel();
		maxIndexTextField = new JTextField(2);
		nextButton = new JButton();
		authorIDLabel = new JLabel();
		authorIDTextField = new JTextField(10);
		firstNameLabel = new JLabel();
		firstNameTextField = new JTextField(10);
		lastNameLabel = new JLabel();
		lastNameTextField = new JTextField(10);
		isbnLabel = new JLabel();
		isbnTextField = new JTextField(10);
		titleLabel = new JLabel();
		titleTextField = new JTextField(10);
		editionNumberLabel = new JLabel();
		editionNumberTextField = new JTextField(10);
		copyrightLabel = new JLabel();
		copyrightTextField = new JTextField(10);
		dbTableComboBox = new JComboBox<String>(dbTableList);
		dbTableListScrollPane = new JScrollPane(dbTableComboBox);
		browseAllButton = new JButton();
		updateButton = new JButton();
		insertButton = new JButton();
		navigationPanel = new JPanel();
		displayPanel = new JPanel();
		queryPanel = new JPanel();
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		setSize(400, 340);
		setResizable(false);
		
		navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.LINE_AXIS));
		
		prevButton.setText("Previous");
		prevButton.setEnabled(false);
		prevButton.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							prevButtonActionPerformed(e);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			); // end call to addActionListener
		
		navigationPanel.add(prevButton);
		navigationPanel.add(Box.createHorizontalStrut(10));
		
		currIndexTextField.setHorizontalAlignment(JTextField.CENTER);
		currIndexTextField.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							currIndexTextFieldActionPerformed(e);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			); // end call to addActionListener
		
		navigationPanel.add(currIndexTextField);
		navigationPanel.add(Box.createHorizontalStrut(10));
		
		ofLabel.setText("of");
		navigationPanel.add(ofLabel);
		navigationPanel.add(Box.createHorizontalStrut(10));
		
		maxIndexTextField.setHorizontalAlignment(JTextField.CENTER);
		maxIndexTextField.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//maxIndexTextFieldActionPerformed(e);
					}
				}
			); // end call to addActionListener
		
		navigationPanel.add(maxIndexTextField);
		navigationPanel.add(Box.createHorizontalStrut(10));
		
		nextButton.setText("Next");
		nextButton.setEnabled(false);
		nextButton.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//nextButtonActionPerformed(e);
					}
				}
			); // end call to addActionListener
		
		navigationPanel.add(nextButton);
		
		add(navigationPanel);
		
		displayPanel.setLayout(new GridLayout(7, 2, 4, 4));
		
		authorIDLabel.setText("Author ID:");
		authorIDTextField.setEditable(false);
		displayPanel.add(authorIDLabel);
		displayPanel.add(authorIDTextField);
		
		firstNameLabel.setText("First Name:");
		lastNameLabel.setText("Last Name:");
		isbnLabel.setText("ISBN:");
		titleLabel.setText("Book title:");
		editionNumberLabel.setText("Ediotion Number:");
		copyrightLabel.setText("Copyright:");
	
		displayPanel.add(firstNameLabel);
		displayPanel.add(firstNameTextField);
		displayPanel.add(lastNameLabel);
		displayPanel.add(lastNameTextField);
		displayPanel.add(isbnLabel);
		displayPanel.add(isbnTextField);
		displayPanel.add(titleLabel);
		displayPanel.add(titleTextField);
		displayPanel.add(editionNumberLabel);
		displayPanel.add(editionNumberTextField);
		displayPanel.add(copyrightLabel);
		displayPanel.add(copyrightTextField);
		
		add(displayPanel);
		
		queryPanel.setLayout(new BoxLayout(queryPanel, BoxLayout.LINE_AXIS));
		queryPanel.setBorder(BorderFactory.createTitledBorder("Query Database"));
		
		queryPanel.add(dbTableListScrollPane);
		
		browseAllButton.setText("Browse All");
		browseAllButton.addActionListener(
			new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						browseAllButtonActionPerformed(e);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		
		queryPanel.add(browseAllButton);
		
		updateButton.setText("Update");
		updateButton.addActionListener(
			new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// updateButtonActionPerformed(e);
				}
			});
		
		queryPanel.add(updateButton);
		
		insertButton.setText("Insert");
		insertButton.addActionListener(
			new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// insertButtonActionPerformed(e);
				}
			});
		
		queryPanel.add(insertButton);
		
		add(queryPanel);
		
		addWindowListener(
			new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					// TO DO: close db connection
					System.exit(0);
				}
			});
		
		setVisible(true);
	}
	
	private void outputRowSet() throws SQLException{
		while (rowSet.next()) {
			for (int i = 1; i <= cashedRowSetQuery.getNumberOfColumns(); i++) {
				if (rowSet.getString(i).equals("AuthorID"))
					authorIDTextField.setText("" + rowSet.getString(i));
				else if (rowSet.getString(i).equals("firstName"))
					firstNameTextField.setText("" + rowSet.getString(i));
				else if (rowSet.getString(i).equals("lastName"))	
					lastNameTextField.setText("" + rowSet.getString(i));
				else if (rowSet.getString(i).equals("ISBN"))	
					isbnTextField.setText("" + rowSet.getString(i));					
				else if (rowSet.getString(i).equals("Title"))	
					titleTextField.setText("" + rowSet.getString(i));
				else if (rowSet.getString(i).equals("EditionNumber"))	
					editionNumberTextField.setText("" + rowSet.getString(i));
				else if (rowSet.getString(i).equals("CopyRight"))	
					copyrightTextField.setText("" + rowSet.getString(i));
			}
		}
	}
	
	// handles call when previous button is clicked
	private void prevButtonActionPerformed(ActionEvent e) throws SQLException {
		currentIndex--;
		if (currentIndex > 0)
			currentIndex = numberOfEntries - 1;
		
		currIndexTextField.setText("" + (currentIndex + 1));
		currIndexTextFieldActionPerformed(e);
	}

	// handles call when values is entered in the text field
	private void currIndexTextFieldActionPerformed(ActionEvent e) throws SQLException {
		currentIndex = 
				Long.parseLong(currIndexTextField.getText()) - 1;
		
		if (numberOfEntries != 0 && currentIndex < numberOfEntries) {
			outputRowSet();
		}
	}
	
	// handles call when browseAll Button is clicked
	private void browseAllButtonActionPerformed(ActionEvent e) throws SQLException {
		
		
		String selectedQuery = dbTableComboBox.getSelectedItem().toString();
		System.out.println(selectedQuery);
		if (selectedQuery.equals("Authors")) 
			cashedRowSetQuery = new CashedRowSetQuery("Authors");
		else if (selectedQuery.equals("Titles"))
			cashedRowSetQuery = new CashedRowSetQuery("Titles");
		else if (selectedQuery.equals("AuthorISBN"))
			cashedRowSetQuery = new CashedRowSetQuery("AuthorISBN");
		else
			cashedRowSetQuery = new CashedRowSetQuery();
		
		rowSet = cashedRowSetQuery.getRowSet();

			outputRowSet();

	}
}













