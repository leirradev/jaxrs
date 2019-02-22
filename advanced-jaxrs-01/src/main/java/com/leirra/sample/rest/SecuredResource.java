package com.leirra.sample.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("secured")
public class SecuredResource {

	@GET
	@Path("messages")
	@Produces(MediaType.APPLICATION_JSON)
	public String securedMethod() {
		return "This API is secured";
	}
}
