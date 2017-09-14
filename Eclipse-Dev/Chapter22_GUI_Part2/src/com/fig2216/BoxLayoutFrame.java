package com.fig2216;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class BoxLayoutFrame extends JFrame {

	public BoxLayoutFrame() {
		super("Demonstrating BoxLayout");
		
		// create Box containers with BoxLayout
		Box horizontal1 = Box.createHorizontalBox();
		Box vertical1 = Box.createVerticalBox();
		Box horizontal2 = Box.createHorizontalBox();
		Box vertical2 = Box.createVerticalBox();
		
		final int SIZE = 3; // number of buttons on each Box
		
		// add buttons to Box horizontal1
		for (int i = 0; i < SIZE; i++) {
			horizontal1.add(new JButton("Button" + i));
		}
		
		// create strut and add buttons to Box vertical1
		for (int i = 0; i < SIZE; i++) {
			vertical1.add(Box.createVerticalStrut(25));
			vertical1.add(new JButton("Button" + i));
		}
		
		// create horizontal glue and add buttons to Box horizonal 
		for (int i = 0; i < SIZE; i++) {
			horizontal2.add(Box.createHorizontalGlue());
			horizontal2.add(new JButton("Button" + i));
		}
		
		// create rigid area and add buttons to Box vertical2
		for (int i = 0; i < SIZE; i++) {
			vertical2.add(Box.createRigidArea(new Dimension(12, 8)));
			vertical2.add(new JButton("Button" + i));
		}
		
		// create vertical glue and add buttons to panel
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		for (int i = 0; i < SIZE; i++) {
			panel.add(Box.createGlue());
			panel.add(new JButton("Button" + i));
		}
		
		// create a JTabbedPane
		JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		
		// place each container on tabbed pane
		tabs.addTab("Horizontal Box", horizontal1);
		tabs.addTab("Vertical Box with Struts", vertical1);
		tabs.addTab("Horizontal Box with Glue", horizontal2);
		tabs.addTab("Vertical Box with Rigid Areas", vertical2);
		tabs.addTab("Vertical Box with Glue", panel);
		
		add(tabs);
	}
}



















