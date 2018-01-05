package org.superklamer.javabrains.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.superklamer.javabrains.messenger.model.ErrorMessage;

//@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable arg0) {
		ErrorMessage errorMessage = new ErrorMessage("Oops ... something went wrong", 500, "http://google.com/error 500");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}

	
}
