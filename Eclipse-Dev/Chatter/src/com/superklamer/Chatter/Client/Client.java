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
					sendMessage(e.getActionCommand());
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
			connectToServer();
			setupStreams();
			whileChatting();
		} catch (EOFException eofe) {
			showMessage("\n Client terminated connection!");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			close();
		}
	}

	private void showMessage(final String message) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				chatWindow.append(message);
			}
		});
	}

	private void sendMessage(String messge) {
		try {
			output.writeObject("CLIENT: " + message);
			output.flush();
			showMessage("\nCLIENT: " + message);
		} catch (IOException e) {
			chatWindow.append("Cannot send messge!");
		}
	}

	private void close() {
		showMessage("Closing session...");
		ableToType(false);
		try {
			output.close();
			input.close();
			connection.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private void ableToType(boolean b) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				userText.setEditable(b);
				
			}
		});
	}

	private void whileChatting() throws IOException {
		ableToType(true);
		do {
			try {
				message = (String) input.readObject();
				showMessage("\n" + message);
			} catch (ClassNotFoundException cnfe) {
				showMessage("Only text accepted!");
			}
		} while (!message.equals("SERVER = END"));
	}

	private void setupStreams() throws IOException {
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("Streams are all set!");
	}

	private void connectToServer() throws IOException {
		showMessage("Attempting connection ...");
		connection = new Socket(InetAddress.getByName(serverIP), 6789);
		showMessage("Connected to " + connection.getInetAddress().getHostName());
	}

	protected void sendData(String actionCommand) {
		// TODO Auto-generated method stub
		
	}
	
}
