package com.knockers.starter;

import java.net.UnknownHostException;

import com.knockers.client.KnocKnockClient;
import com.knockers.server.KnockKnockServer;

public class KnockKnockStarter {
	
	public static void main(String[] args) throws UnknownHostException {
		Runnable startServer = () -> {new KnockKnockServer(65432);};
		new Thread(startServer).start();
		
		KnocKnockClient client = new KnocKnockClient();
		
		client.chat();
	}

}
