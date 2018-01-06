package com.superklamer.Chatter.Main;

import javax.swing.JFrame;

import com.superklamer.Chatter.Client.Client;

public class ClientTest extends JFrame{

	public static void main(String[] args) {
		Client client = new Client("127.0.0.1");	
		client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		client.startRunning();
	}
	
	
}
