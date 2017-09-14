package com.fig2213;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class JTabbedPaneFrame extends JFrame {

	public JTabbedPaneFrame() {
		super("JTabbedPane Demo");
		
		JTabbedPane tabbedPane = new JTabbedPane();  // create JTabbedPane
		
		// setup panel1 and add it to JTabbedPane
		JLabel label1 = new JLabel("Panel One", SwingConstants.CENTER);
		JPanel panel1 = new JPanel();
		panel1.add(label1);
		tabbedPane.addTab("Tab One", null, panel1, "First Panel");
		
		// setup panel2 add it to JTabbedPane
		JLabel label2 = new JLabel("Panel Two", SwingConstants.CENTER);
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.YELLOW);
		panel2.add(label2);
		tabbedPane.addTab("Tab two", null, panel2, "Second Panel");
		
		// setup panel3 add it to JTabbedPane
		JLabel label3 = new JLabel("Panel three", SwingConstants.CENTER);
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BorderLayout());
		panel3.add(new JButton("North"), BorderLayout.NORTH);
		panel3.add(new JButton("West"), BorderLayout.WEST);
		panel3.add(new JButton("East"), BorderLayout.EAST);
		panel3.add(new JButton("South"), BorderLayout.SOUTH);
		panel3.add(label3);
		tabbedPane.addTab("Tab Three", null, panel3, "Third panel");
	
		add(tabbedPane);
	}

}











