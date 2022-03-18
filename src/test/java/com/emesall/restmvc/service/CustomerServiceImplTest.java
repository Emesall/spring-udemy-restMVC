package com.emesall.restmvc.service;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.emesall.restmvc.api.v1.mapper.CustomerMapper;
import com.emesall.restmvc.api.v1.model.CustomerDTO;
import com.emesall.restmvc.model.Customer;
import com.emesall.restmvc.repositories.CustomerRepository;

class CustomerServiceImplTest {

	
	CustomerService customerService;
	@Mock
	CustomerRepository customerRepository;

	
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);		
		customerService=new CustomerServiceImpl(customerRepository, CustomerMapper.INSTANCE);
	}

	@Test
	void testGetCustomers() {
		//given
		List<Customer> customers=new ArrayList<>();
		customers.add(new Customer());
		customers.add(new Customer());
		
		//when
		when(customerRepository.findAll()).thenReturn(customers);
		List<CustomerDTO> CustomerDTOS=customerService.getCustomers();
		//then
		Assertions.assertEquals(2, CustomerDTOS.size() );
		
	}
	
	@Test
	void testGetCustomerByName() {
		//given
		Customer customer=new Customer();
		customer.setFirstname("firstName");
		customer.setLastname("LastName");
		customer.setId(1L);
		//when
		when(customerRepository.findByFirstname(anyString())).thenReturn(customer);
		CustomerDTO CustomerDTO=customerService.getCustomerByFirstName("firstname");
		//then
		Assertions.assertNotNull(CustomerDTO);
		Assertions.assertEquals("firstName", CustomerDTO.getFirstname() );
		Assertions.assertEquals(1L, CustomerDTO.getId() );
		
	}

}