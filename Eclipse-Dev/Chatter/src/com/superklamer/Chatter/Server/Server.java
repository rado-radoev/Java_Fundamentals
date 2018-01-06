package com.superklamer.Chatter.Server;


import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Server extends JFrame {

	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection; 
	
	public Server() {
		super("Chatter");
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
		add(new JScrollPane(chatWindow));
		setSize(300,150);
		setVisible(true);
	}

	// set up and run the server
	public void startRunning() {
		try {
			server = new ServerSocket(6789, 100);
			while ( true ) {
				 try {
					 waitForConnection();
					 setuStreams();
					 whileChatting();
				 } catch (EOFException eofException) {
					 showMessage("\n Server ended the connection!");
				 } finally {
					 close();
				 }
				 
			}
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
	
	private void close() {
		showMessage(" Closing connections ...");
		ableToType(false);
		
		try {
			output.close();
			input.close();
			server.close();
			connection.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}

	private void whileChatting() throws IOException {
		String message = " You are now connected! ";
		sendMessage(message);
		ableToType(true);
		
		do {
			try {
				message = (String) input.readObject();
				showMessage("\n" + message);
			} catch (ClassNotFoundException cnfe) {
				showMessage("\n Text only accepted! \n");
			}
			
		} while (!message.equals("CLIENT - END"));
	}

	private void ableToType(final boolean b) {
		SwingUtilities.invokeLater(
				new Runnable() {
					
					@Override
					public void run() {
						userText.setEditable(b);
					}
				});
		
	}

	private void setuStreams() throws IOException {
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\n Streams are now setup! \n");
	}

	// wait for connection and display connection information
	private void waitForConnection() throws IOException {
		showMessage("Waiting for someone to connect ...\n");
		connection = server.accept();
		showMessage("Now connected to " + connection.getInetAddress().getHostName());
	}

	private void showMessage(final String text) {
		SwingUtilities.invokeLater(
			new Runnable() {
				
				@Override
				public void run() {
					chatWindow.append(text);					
				}
			});
	}

	protected void sendMessage(String message) {
		try {
			output.writeObject("SERVER: " + message);
			output.flush();
			showMessage("\n SERVER: " + message);
		} catch (IOException e) {
			chatWindow.append("Cannot send message!");
		}
	}
	
}


































