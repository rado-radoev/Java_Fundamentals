package com.fig227;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.ButtonGroup;

public class PopupFrame extends JFrame {

	private final JRadioButtonMenuItem[] items;	// holds items for colors
	private final Color[] colorValues = 
		{Color.BLUE, Color.YELLOW, Color.RED}; // colors to be used
	private final JPopupMenu popupMenu;		// allow user to select color
	
	public PopupFrame() {
		super("Using JPopupMenus");
		
		ItemHandler handler = new ItemHandler();  // handler for menu items
		String[] colors = { "Blue", "Yellow", "Red" };
		
		ButtonGroup colorGroup = new ButtonGroup();  // manages color items
		popupMenu = new JPopupMenu();  // create pop-up menu
		items = new JRadioButtonMenuItem[colors.length];
		
		// construct menu item, add to pop-up menu, enable event handling
		for (int i = 0; i < items.length; i++) {
			items[i] = new JRadioButtonMenuItem(colors[i]); 
			popupMenu.add(items[i]);  // add item to pop-up menu
			colorGroup.add(items[i]); // add item to button group
			items[i].addActionListener(handler);  // add handler
		}
		
		setBackground(Color.WHITE);
		
		// declare a mouseListener for the window to display pop-up menu
		addMouseListener(
				new MouseAdapter()// annonymous inner class
				{
					// handle mouse press event
					@Override
					public void mousePressed(MouseEvent event) {
						checkForTriggerEvent(event);
					}
					
					// handle mouse release event
					@Override
					public void mouseReleased(MouseEvent event) {
						checkForTriggerEvent(event);
					}
					
					// determine whether event should trigger pop-up menu
					private void checkForTriggerEvent(MouseEvent event) {
						if (event.isPopupTrigger()) {
							popupMenu.show(event.getComponent(), event.getX(), event.getY());
						}
					}
				}
			);
	}  // end popup consturctor
	
	
	// private inner class to handle menu item events
	private class ItemHandler implements ActionListener {
		// process menu item selections
		@Override
		public void actionPerformed(ActionEvent event) {
			// determine which menu item was selected
			for (int i = 0; i < items.length; i++) {
				if (event.getSource() == items[i]) {
					getContentPane().setBackground(colorValues[i]);
					return;
				}
			}
		}
	} // end private inner class ItemHandler
} // end class popupframe







































