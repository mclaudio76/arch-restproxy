package com.sample.restsrv;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.sample.data.Customer;
import com.sample.exceptions.CustomerServiceException;
import com.sample.interfaces.ICustomerService;


@Stateless
@Local(ICustomerService.class)
public class CustomerService implements ICustomerService {
	
	public ArrayList<Customer> getAllCustomers() throws CustomerServiceException {
		ArrayList<Customer> lst = new ArrayList<>();
		lst.add(new Customer(0,"John", "Doe", "john.doe@nowhere.com"));
		lst.add(new Customer(1,"Jane", "Doe", "jane.doe@nowhere.com"));
		return lst;
	}

	@Override
	public ArrayList<Customer> getSpecificCustomer(Customer filter) throws CustomerServiceException {
		ArrayList<Customer> result = new ArrayList<>();
		for(Customer customer : getAllCustomers()) {
			if (filter.getId() == customer.getId()) {
				result.add(customer);
			}
		}
		if (result.isEmpty()) {
			throw new CustomerServiceException("No customer found with given ID");
		}
		return result;
	}
	
	
	
}
