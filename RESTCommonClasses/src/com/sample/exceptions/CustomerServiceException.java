package com.sample.exceptions;

public class CustomerServiceException  extends RESTApplicationServiceException {

	private static final long serialVersionUID = 1L;
	
	public CustomerServiceException() {
		super();
	}
	
	public CustomerServiceException(String mex) {
		super(mex);
	}

}
