package com.leirra.sample.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//finds every resource
//bootstraping a jax-rs application using @applicationpath
@ApplicationPath("webapi")
public class MyApp extends Application {
	
	/*public Set<Class<?>> getClasses(){
		return new HashSet<Class<?>>();
	}*/
}
