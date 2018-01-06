package com.superklamer.Chatter.Main;
import javax.swing.JFrame;

import com.superklamer.Chatter.Server.Server;;

public class ServerTest {

	public static void main(String[] args) {
		Server server = new Server();
		server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		server.startRunning();
	}
}
