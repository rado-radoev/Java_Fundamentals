// Display the contents of Authors table in the books database
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;


public class DisplayQueryResults extends JFrame {

	// database URL, username and password
	private static final String DATABASE_URL = "jdbc:derby:books";
	private static final String USERNAME = "";
	private static final String PASSWORD = "";
	
	// default query, retrieves all data from Authors table
	private static final String DEFAULT_QUERY = "SELECT * FROM Authors";
	
	private static ResultSetTableModel tableModel;
	
	public static void main(String[] args) {
		// crate ResultSetTableModel and display database
		try {
			
			// create TableModel for results of query SELECT * FROM Authors
			tableModel = new ResultSetTableModel(DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);
			
			// set up JTextArea in which user types queries
			final JTextArea queryArea = new JTextArea(DEFAULT_QUERY, 3, 100);
			queryArea.setWrapStyleWord(true);
			queryArea.setLineWrap(true);
			
			JScrollPane scrollPane = new JScrollPane(queryArea, 
					ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			
			// set up JButton for submitting queries
			JButton submitButton = new JButton("Submit Query");
			
			// create Box to manage placement of queryArea and
			// submit button in GUI
			Box boxNorth = Box.createHorizontalBox();
			boxNorth.add(scrollPane);
			boxNorth.add(submitButton);
					
			// create JTable based on the tableModel
			JTable resultTable = new JTable(tableModel);
			
			JLabel filterLabel = new JLabel("Filter:");
			final JTextField filterText = new JTextField();
			JButton filterButton = new JButton("Apply Filter"	);
			Box boxSouth = Box.createHorizontalBox();
			
			boxSouth.add(filterLabel);
			boxSouth.add(filterText);
			boxSouth.add(filterButton);
			
			// place GUI components on JFrame content pane
			JFrame window = new JFrame("Display Query Results");
			window.add(boxNorth, BorderLayout.NORTH);
			window.add(new JScrollPane(resultTable), BorderLayout.CENTER	);
			window.add(boxSouth, BorderLayout.SOUTH);
			
			// create event listener for submit button
			submitButton.addActionListener(
					new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// perform new query
							try {
								tableModel.setQuery(queryArea.getText());
							} catch (SQLException sqlException) {
								JOptionPane.showMessageDialog(null, sqlException.getMessage(),
										"Database Error", JOptionPane.ERROR_MESSAGE);
								
								// try to recover invalid user query by executing
								// default query
								try {
									tableModel.setQuery(DEFAULT_QUERY);
									queryArea.setText(DEFAULT_QUERY);
								} catch (SQLException sqlException2) {
									JOptionPane.showInternalMessageDialog(
											null, sqlException2.getMessage(), 
											"Database Error", 
											JOptionPane.ERROR);
									
									// ensure database connection is closed
									tableModel.disconnectFromDatabase();
									
									System.exit(1);  // terminate application
								}
							}
						}
					}
				);
			
			final TableRowSorter<TableModel> sorter = 
					new TableRowSorter<TableModel>(tableModel);
			resultTable.setRowSorter(sorter);
			
			// create listener for filterButton
			filterButton.addActionListener(
					new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							String text = filterText.getText();
							
							if (text.length() == 0)
								sorter.setRowFilter(null);
							else {
								try {
									sorter.setRowFilter(RowFilter.regexFilter(text));
								} catch (PatternSyntaxException pse) {
									JOptionPane.showMessageDialog(
											null, "Bad regex pattern",
											"Bad regex pattern", JOptionPane.ERROR_MESSAGE);
								}
							}
						}
					}
				);
			
			// dispose of window when user quits the application
			window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			window.setSize(500, 250);
			window.setVisible(true);
			
			// ensure database is closed when user quits application
			window.addWindowListener(
					new WindowAdapter() {
						// disconnect from database and exit when windows has closed
						@Override
						public void windowClosed(WindowEvent event) {
							tableModel.disconnectFromDatabase();
							System.exit(0);
						}
					}
				);
		} catch (SQLException sqlException) {
			JOptionPane.showMessageDialog(null, sqlException.getMessage(),
					"Database error", JOptionPane.ERROR_MESSAGE);
			
			tableModel.disconnectFromDatabase();
			System.exit(1); // terminate applicaiton
		}
	}
} // end of class DisplayQueryResults





























