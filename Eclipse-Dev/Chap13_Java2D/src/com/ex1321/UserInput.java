package com.ex1321;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

public class UserInput extends JFrame {
	
	private final JLabel repeatesLabel;
	private final JTextField repeatsTextField;
	private final BorderLayout borderLayout;
	private final FlowLayout flowLayout;
	private final JPanel userPanel;
	private final JPanel screenSaverPanel;
	private ScreenSaver screenSaver;
	private static int iterations = 100;
	
	public static int getIterations() {
		return iterations;
	}
	
	public UserInput() {
		super("Iterations screen saver");
		borderLayout = new BorderLayout();
		flowLayout = new FlowLayout();
		setLayout(borderLayout);
		
		screenSaverPanel = new JPanel();
		screenSaverPanel.setLayout(borderLayout);
		
		userPanel = new JPanel();
		userPanel.setLayout(flowLayout);
		
		repeatesLabel = new JLabel("Enter number of iterations");
		userPanel.add(repeatesLabel);
		
		textFieldHandler tHandler = new textFieldHandler();
		repeatsTextField = new JTextField(10);
		repeatsTextField.addActionListener(tHandler);
		userPanel.add(repeatsTextField);
		
		add(userPanel, borderLayout.NORTH);
		
		screenSaver = new ScreenSaver();
		add(screenSaver, borderLayout.CENTER);
		
	}


	private class textFieldHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == repeatsTextField)
				iterations = Integer.valueOf(repeatsTextField.getText());
		}
		

	}
}


