package com.sample.exceptions;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RESTApplicationServiceException")
public class RESTApplicationServiceException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @XmlElement(required=true)
	public String actualExceptionClass = "";
    
	@XmlElement(required=true)
	public String message			   = "";
	
	public RESTApplicationServiceException() {
		super();
		this.actualExceptionClass = getClass().getCanonicalName();
	}
	
	public void setMessage(String mex) {
		this.message = mex;
	}
	
	public RESTApplicationServiceException(String mex) {
		super(mex);
		this.message = mex;
		this.actualExceptionClass = getClass().getCanonicalName();
	}


	public String getActualException() {
		return actualExceptionClass;
	}
	
	
	@Override
	public String getMessage() {
		return message;
	}
	
}
