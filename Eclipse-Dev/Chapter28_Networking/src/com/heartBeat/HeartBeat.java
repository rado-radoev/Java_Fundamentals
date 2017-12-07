package com.heartBeat;

import java.net.*;
import java.io.*;

public class HeartBeat extends java.applet.Applet {
	String host;
	int port;
	
	public void init() {
		host = getCodeBase().getHost();
		port = Integer.parseInt(getParameter("port"));
	}
	
	private void sendMessage(String message) {
		try {
			byte[] data = message.getBytes("UTF-8");
			InetAddress addr = InetAddress.getByName(host);
			DatagramPacket packet = 
					new DatagramPacket(data, data.length, addr, port);
			DatagramSocket socket = 
					new DatagramSocket();
			socket.send(packet);
			socket.close();
		} catch (IOException e) {
			System.out.println(e); //Error creating socket 
		}
	}
	
	public void start() {
		sendMessage("Arrived");
	}
	
	public void stop() {
		sendMessage("Departed");
	}
}
