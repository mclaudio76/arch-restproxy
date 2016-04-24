package com.sample.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
	
@XmlRootElement	(name="customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
    
	@XmlAttribute(required=true) 
    protected int id;
    
    @XmlElement(required=true)
    protected String firstname;
    
    @XmlElement(required=true)
    protected String lastname;
    
    @XmlElement(required=true)
    protected String email;
    
    
    public Customer() { 
    	
    }
    
    
    
    public Customer(int ID, String firstname, String lastname, String email) {
    	this.id = ID;
    	this.firstname = firstname;
    	this.lastname  = lastname;
    	this.email = email;
    }




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getFirstname() {
		return firstname;
	}




	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}




	public String getLastname() {
		return lastname;
	}




	public void setLastname(String lastname) {
		this.lastname = lastname;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}


	

    
}