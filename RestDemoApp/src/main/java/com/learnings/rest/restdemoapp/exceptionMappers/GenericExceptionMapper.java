package com.learnings.rest.restdemoapp.exceptionMappers;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;

import com.learnings.rest.restdemoapp.model.ExceptionModel;


@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Inject
	Logger logger;
	
	public Response toResponse(Throwable arg0) {
		logger.info("GenericExceptionMapper Response Method");
		ExceptionModel exceptionModel = new ExceptionModel(arg0.getMessage(),500);
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(exceptionModel).build();
	}
	

}
