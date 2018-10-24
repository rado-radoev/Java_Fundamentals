package org.koushik.javabrains.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.eclipse.persistence.oxm.MediaType;
import org.eclipse.persistence.platform.database.PostgreSQLPlatform;
import org.koushik.javabrains.messenger.model.Message;

public class RestApiClient {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		
		WebTarget baseTarget = client.target("http://localhost:8080/advanced-jaxrs-06/webapi/");
		WebTarget messagesTarget = baseTarget.path("messages");
		WebTarget singleMessageTarget = messagesTarget.path("{messageId}");
		
		Message message1 = singleMessageTarget
					.resolveTemplate("messageId", "1")
					.request()
					.get(Message.class);
		
		Message message2 = singleMessageTarget
				.resolveTemplate("messageId", "2")
				.request()
				.get(Message.class);
		
		Message newMessage = new Message(4, "My new messge from JAX-RS client", "Rado");
		Response postResponse = messagesTarget
			.request()
			.post(Entity.json(newMessage));

		
		
		if (postResponse.getStatus() != 201) {
			System.out.println("Error");
		} else {
			Message createdMessge = postResponse.readEntity(Message.class);
			System.out.println(createdMessge.getMessage());
		}
		
		
//		Message message = response.readEntity(Message.class);
//		System.out.println(message1.getMessage());
//		System.out.println(message2.getMessage());
	}

}
