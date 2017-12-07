package com.heartBeat;

import java.net.*;
import java.io.*;

public class Pulse {
	public static void main(String[] args) throws IOException {
		DatagramSocket s =
				new DatagramSocket(Integer.parseInt(args[0]));
		
		while (true) {
			DatagramPacket packet = 
					new DatagramPacket(new byte[1024], 1024);
			s.receive(packet);
			String message = new String(
					packet.getData(), 0, packet.getLength(), "UTF-8");
			System.out.println("Heartbeat from: " + packet.getAddress().getHostName() + " " + message);
		}
	}
}
