package com.learnings.rest.restdemoapp.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("messages")
public class MessageResource {

	@GET
	@Path("/ping")
	@Produces(MediaType.TEXT_PLAIN)
	public String ping() {
		return "Messages PING Success!!!";
		/*http://localhost:8080/RestDemoApp/messages/ping
*/	
		}

}
