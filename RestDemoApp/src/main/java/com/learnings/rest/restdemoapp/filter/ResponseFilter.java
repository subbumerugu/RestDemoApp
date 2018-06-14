package com.learnings.rest.restdemoapp.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;

@Provider
public class ResponseFilter implements ContainerResponseFilter{

	@Inject
	Logger logger;
	
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		logger.info("Response Filter:");
		
	}

}
