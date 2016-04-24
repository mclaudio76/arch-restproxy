package com.sample.interfaces;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.sample.data.Customer;
import com.sample.exceptions.CustomerServiceException;


@Path("/customers")
public interface ICustomerService {
	
	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Customer> getAllCustomers() throws CustomerServiceException;
	
	@POST
	@Path("/specific")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Customer> getSpecificCustomer(Customer filter) throws CustomerServiceException;
	
	
}