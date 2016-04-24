package com.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.sample.data.Customer;
import com.sample.exceptions.CustomerServiceException;
import com.sample.interfaces.ICustomerService;

public class Main {

	public static void main(String[] args) {
		String url = "http://localhost:8080/RESTProxyServerWeb/services/";
		List<Object> providers = new ArrayList<Object>();
	    providers.add( new JacksonJaxbJsonProvider() );
	    providers.add( new ClientExceptionHandler(CustomerServiceException.class));
	    
	    ICustomerService store = JAXRSClientFactory.create(url, ICustomerService.class,providers);
	    try {
			for(Customer cust : store.getAllCustomers())	 {
				System.out.println(cust.getFirstname());
			}
			Customer filter = new Customer();
			filter.setId(0);
			ArrayList<Customer> lst = store.getSpecificCustomer(filter);
			for(Customer x : lst) {
				System.out.println("Found "+x.getFirstname()+" , "+x.getLastname()+" email =  "+x.getEmail());
			}
			// This will throw an exception.
			filter.setId(1000);
			store.getSpecificCustomer(filter);
		}
		catch(CustomerServiceException e) {
			System.err.println(e.getMessage());
			
		}
		
		
		
		
	}
	
	
	
	

}
