package com.emesall.restmvc.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.emesall.restmvc.model.Customer;
import com.emesall.restmvc.repositories.CustomerRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CustomerRepositoryTest {

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void testFindByFirstName() {
		Customer customer=new Customer();
		customer.setFirstname("firstname");
		customerRepository.save(customer);
		Customer customerFound=customerRepository.findByFirstname("firstname");
		assertEquals("firstname", customerFound.getFirstname());
		
	}

}
