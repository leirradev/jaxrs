package com.leirra.sample.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.leirra.sample.messenger.model.Message;

//creating rest api client using jax-rs
public class RestApiClient {
	private static Response post;

	public static void main(String[] args) {
//		could make multiple rest api calls. get holds of webtarget
		Client client = ClientBuilder.newClient();
		WebTarget baseTarget = client.target("http://localhost:8080/advanced-jaxrs-01/webapi/");
		WebTarget messagesTarget = baseTarget.path("messages");
		WebTarget singleMessageTarget = messagesTarget.path("{messageId}");
		
//		Response response = client
//		Message message = client
//		String message = client
		Message message = singleMessageTarget
				.resolveTemplate("messageId", "1")
//				.target("http://localhost:8080/advanced-jaxrs-01/webapi/messages/2")
				.request(MediaType.APPLICATION_JSON)
//				.get(String.class);
				.get(Message.class);
//		Message message = response.readEntity(Message.class);
		
		Message message2 = singleMessageTarget
				.resolveTemplate("messageId", "2")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		
		Message newMessage = new Message(4, "My new message for JAX-RS Client", "leirra");
		Response postResponse = messagesTarget
		.request()
		.post(Entity.json(newMessage));
		if(postResponse.getStatus() != 201)
		{
			System.out.println("Error");
		}
		Message createdMessage = postResponse.readEntity(Message.class);
		System.out.println(createdMessage.getMessage());
		
//		broken down into pieces
		/*WebTarget target = client.target("http://localhost:8080/advanced-jaxrs-01/webapi/messages/1");
		Builder builder = target.request(); //preparing target's request
		Response response = builder.get();
		Message message = response.readEntity(Message.class);*/
		
//		System.out.println(message.getMessage());
//		System.out.println(message2.getMessage());
//		System.out.println(message);
	}
}
