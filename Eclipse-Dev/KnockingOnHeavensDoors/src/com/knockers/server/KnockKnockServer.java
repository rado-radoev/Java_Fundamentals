package com.knockers.server;

import java.io.IOException;
import java.net.ServerSocket;

public class KnockKnockServer {
	
	private static int PORT;
	private boolean listening = true;
	
	public KnockKnockServer(int port) throws IllegalArgumentException {
		
		if (port <= 0) throw new IllegalArgumentException("Port must be positive integer");
		
		this.PORT = port;
		
		
		try (ServerSocket serverSocket = new ServerSocket(port)) {
				while (listening) {
					new KnockKnockMultiServerThread(serverSocket.accept()).start();
				}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println(String.format("Could not listen on port %d", port));
			System.exit(-1);
		}
		
		
		
	}
}
