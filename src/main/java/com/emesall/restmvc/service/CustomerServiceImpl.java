package com.emesall.restmvc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emesall.restmvc.api.v1.mapper.CustomerMapper;
import com.emesall.restmvc.api.v1.model.CustomerDTO;
import com.emesall.restmvc.model.Customer;
import com.emesall.restmvc.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		super();
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}

	@Override
	public List<CustomerDTO> getCustomers() {
		return customerRepository.findAll()
				.stream()
				.map(customerMapper::customerToCustomerDTO)
				.collect(Collectors.toList());
	}

	@Override
	public CustomerDTO getCustomerByFirstName(String firstName) {
		return customerMapper.customerToCustomerDTO(customerRepository.findByFirstname(firstName));
	}

	@Override
	public CustomerDTO createCustomer(CustomerDTO customerDTO) {
		Customer customer=customerMapper.customerDTOToCustomer(customerDTO);
		Customer savedCustomer=customerRepository.save(customer);
		
		return customerMapper.customerToCustomerDTO(savedCustomer);
	}
	
	

}
