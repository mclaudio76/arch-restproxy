package com.sample.exceptions.handlers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.google.gson.Gson;
import com.sample.exceptions.RESTApplicationServiceException;

/****
 * We need to define an ExceptionMapper to deal with custom exceptions thrown by EJB methods exposed as
 * REST services. Otherwise, application server will treat them as regular exceptions (logging them on System.err
 * and, more important, not propagating them to the client). 
 *
 * To avoid to implement an ExceptionMapper for any custom exception, we define a simple hierarchy of exceptions,
 * whose root is RESTApplicationServiceException. We may have used WebApplicationException as well, but that's a
 * RuntimeException and it causes Wildfly to log on SystemErr, no matter if we defined an ExceptionMapper.
 * 
 * A less simplistic approach would provide a mean to trace the stack trace of thrown exceptions.
 * 
 */

@Provider
public class RESTApplicationServiceExceptionHandler implements ExceptionMapper<RESTApplicationServiceException>  {
	@Override
	public Response toResponse(RESTApplicationServiceException ex) {
		  Gson gson = new Gson();
		  String json = gson.toJson(ex);
		  System.err.println(" A RESTService method returned an exception --> "+ex.getMessage()+" of type "+ex.getActualException());
		  return Response.serverError().entity(json).type(MediaType.APPLICATION_JSON).build();
	}
}
