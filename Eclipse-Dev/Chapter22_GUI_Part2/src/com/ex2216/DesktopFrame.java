 package com.ex2216;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class DesktopFrame extends JFrame {

	private JDesktopPane theDesktop;
	private JMenuBar bar;
	private JMenu addMenu;
	private JMenu fileMenu;
	private JMenuItem newFrame;
	private JMenuItem exitMenuItem;
	private ButtonsPanel buttonsPanel;
	
	public DesktopFrame() {
		super ("Shapes drawing application");
	
		bar = new JMenuBar(); // create menu bar
		
		addMenu = new JMenu("Add"); // create Add menu
		fileMenu = new JMenu("File"); // create File Menu
		
		newFrame = new JMenuItem("Internal Frame");
		newFrame.addActionListener(listener);
		exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(listener);
		
		fileMenu.add(exitMenuItem); // add exit menu item to file menu
		bar.add(fileMenu); // add file menu to menu bar
		
		addMenu.add(newFrame);	// add new frame item to Add menu
		bar.add(addMenu);	// add Add menu to menu bar
			
		setJMenuBar(bar);  // set menu bar for this application
		
		theDesktop = new JDesktopPane(); // create desktop pane
		add(theDesktop); // add desktop pane to JFrame
		
		setContentPane(theDesktop);
		
	}
	
	private ActionListener listener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == exitMenuItem)
				System.exit(0);
			else if (e.getSource() == newFrame) {
				JInternalFrame frame = new JInternalFrame("Internal Frame", true, true, true, true);
				
				buttonsPanel = new ButtonsPanel();
				frame.add(buttonsPanel, BorderLayout.NORTH);
				
				MyPanel panel = new MyPanel(); // create new panel
				frame.add(panel, BorderLayout.CENTER);  // add panel
				frame.pack(); // set internal frame to size of contents
				
				
				theDesktop.add(frame); // attach internal frame to desktop pane
				frame.setVisible(true); // show internal frame
			} // end new frame if statement
		} // end method actionPerformed
	}; // end ActionListener method
} // end class Desktop frame






























