package com.learnings.rest.restdemoapp.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;

@Provider
public class LogRequestFilter implements ContainerRequestFilter{

	@Inject
	Logger logger;
	public void filter(ContainerRequestContext requestContext) throws IOException {
		logger.info("Request Filter:");
	}

}
