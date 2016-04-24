package com.test;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.ResponseExceptionMapper;

import com.google.gson.Gson;
import com.sample.exceptions.RESTApplicationServiceException;

public class ClientExceptionHandler<T extends RESTApplicationServiceException> implements ResponseExceptionMapper<T> {
	
	private Class<T> claz;
	Gson gson = new Gson();
	
	public ClientExceptionHandler(Class<T> claz) {
		this.claz = claz;
	}
	
	@Override
	public T fromResponse(Response r) {
		try {
			T actual   								 = claz.newInstance();
			RESTApplicationServiceException response = gson.fromJson(r.readEntity(String.class),RESTApplicationServiceException.class);
			actual.setMessage(response.getMessage());
			return actual;
		}
		catch(Exception e) {
			return null;
		}
	}
}
