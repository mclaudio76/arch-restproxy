package com.sample.exceptions.handlers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.google.gson.Gson;
import com.sample.exceptions.RESTApplicationServiceException;

/****
 * This class is needed to intercept business-logic exceptions, and to avoid
 * Wildfly to handle them by simply logging stacktrace on System.err.
 * 
 * This class simply wraps into a JSON response the exception message. A better implementation
 * should analyze stacktrace and report it to caller.
 * 
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
