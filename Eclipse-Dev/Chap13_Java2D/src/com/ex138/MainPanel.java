package com.ex138;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private final JPanel mPanel;
	private final Ellipse ellipse;
	
	public MainPanel() {
		super();
				
		ellipse = new Ellipse();
		mPanel = new JPanel();
		mPanel.add(ellipse);
	}
}
