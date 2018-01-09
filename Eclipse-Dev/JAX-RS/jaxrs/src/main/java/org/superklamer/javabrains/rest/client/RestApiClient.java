package org.superklamer.javabrains.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.superklamer.javabrains.messenger.model.Message;

public class RestApiClient {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		
		Message message = client
			.target("http://localhost:8080/jaxrs/webapi/messages/1")
			.request(MediaType.APPLICATION_JSON)
			.get(Message.class);
		
		//Message message = response.readEntity(Message.class);
		System.out.println(message.getMessage());
	}

}
