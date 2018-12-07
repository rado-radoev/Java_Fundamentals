package com.knockers.client;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;

import com.knockers.server.KnockKnockServer;

public class KnocKnockClient  {

	private final int port = 6542;
	private final String hostname = Inet4Address.getLocalHost().getHostName();
	
	public KnocKnockClient() throws UnknownHostException {}
	
	public void chat() {
		try (Socket socket = new Socket(hostname, port);
			 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
			
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			
			String fromServer, fromUser;
			
			while ((fromServer = in.readLine()) != null) {
				System.out.println("Server: " + fromServer);
				if (fromServer.equalsIgnoreCase("Bye.")) break;
				
				fromUser = stdIn.readLine();
				if (fromUser != null) {
					System.out.println("From User: " + fromUser);
					out.print(fromUser);
				}
			}
			
			
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to " +
	                hostname);
	            System.exit(1);
		}
	}
}
