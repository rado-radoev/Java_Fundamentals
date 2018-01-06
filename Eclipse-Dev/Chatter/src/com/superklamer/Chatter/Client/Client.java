package com.superklamer.Chatter.Client;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client extends JFrame {

	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message;
	private String serverIP;
	private Socket connection;
	
	public Client(String host) {
		super("Chatter client");
		serverIP = host;
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(
			new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					sendData(e.getActionCommand());
					userText.setText("");
				}
			});
		
		add(userText, BorderLayout.NORTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow), BorderLayout.CENTER);
		setSize(300, 150);
		setVisible(true);
	}
	
	public void startRunning() {
		try {
			
		} catch (EOFException eofe) {
			showMessage("\n Client terminated connection!");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			close();
		}
	}

	protected void sendData(String actionCommand) {
		// TODO Auto-generated method stub
		
	}
	
}
