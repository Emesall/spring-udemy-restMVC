package com.emesall.restmvc.api.v1.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.emesall.restmvc.api.v1.model.CustomerDTO;
import com.emesall.restmvc.model.Customer;
class CustomerMapperTest {

	CustomerMapper customerMapper = CustomerMapper.INSTANCE;
	public static final String NAME = "Joe";
	public static final long ID = 1L;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCustomerToDTO() throws Exception {
		// given
		Customer customer = new Customer();
		customer.setFirstname(NAME);
		customer.setId(ID);

		// when
		CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

		// then
		assertEquals(Long.valueOf(ID), customerDTO.getId());
		assertEquals(NAME, customerDTO.getFirstname());
	}
	
	@Test
	void testDTOToCustomer() throws Exception {
		// given
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setFirstname(NAME);
		customerDTO.setId(ID);

		// when
		Customer customer = customerMapper.customerDTOToCustomer(customerDTO);

		// then
		assertEquals(Long.valueOf(ID), customer.getId());
		assertEquals(NAME, customer.getFirstname());
	}

}
