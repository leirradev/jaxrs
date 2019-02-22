package com.leirra.sample.rest;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//@Path("{pathParam}/test")
@Path("test")
//@Singleton
public class MyResource {
//	private int count;
//	@PathParam("pathParam") private String pathParamExample;
//	@QueryParam("query") private String queryParamExample;
	
	@GET
	@Produces(value = {MediaType.TEXT_PLAIN,"text/shortdate"})
	public Date testMethod() {
//		count++;
//		return "It works! This method was called "+count+" time(s)";
//		return "It works! Path param used "+pathParamExample+" and Query Param used " +queryParamExample;
		
		return Calendar.getInstance().getTime();
	}
}
