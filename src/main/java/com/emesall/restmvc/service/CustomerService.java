package com.emesall.restmvc.service;

import java.util.List;

import com.emesall.restmvc.api.v1.model.CustomerDTO;

public interface CustomerService {

	List<CustomerDTO> getCustomers();
	CustomerDTO getCustomerByFirstName(String firstName);
	
}