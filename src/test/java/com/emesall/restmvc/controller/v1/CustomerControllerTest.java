package com.emesall.restmvc.controller.v1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.emesall.restmvc.api.v1.model.CustomerDTO;
import com.emesall.restmvc.service.CustomerService;

class CustomerControllerTest extends AbstractRestControllerTest {

	@Mock
	CustomerService customerService;
	@InjectMocks
	CustomerController customerController;

	MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	@Test
	void testGetCategories() throws Exception {
		// given
		List<CustomerDTO> customer = new ArrayList<>();
		customer.add(new CustomerDTO());
		customer.add(new CustomerDTO());

		// when
		when(customerService.getCustomers()).thenReturn(customer);

		// then
		mockMvc.perform(get("/api/v1/customers/").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.customers", hasSize(2)));
	}

	@Test
	void testGetCustomerByName() throws Exception {
		// given
		CustomerDTO customer = new CustomerDTO();
		customer.setId(1L);
		customer.setFirstname("name");

		// when
		when(customerService.getCustomerByFirstName(anyString())).thenReturn(customer);

		// then
		mockMvc.perform(get("/api/v1/customers/name").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstname", equalTo("name")));
	}

	@Test
	void testCreateCustomer() throws Exception {
		// given
		CustomerDTO customer = new CustomerDTO();
		customer.setId(1L);
		customer.setFirstname("name");

		// when
		when(customerService.createCustomer(any(CustomerDTO.class))).thenReturn(customer);

		// then
		mockMvc.perform(
				post("/api/v1/customers").contentType(MediaType.APPLICATION_JSON).content(asJsonString(customer)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.firstname", equalTo("name")));
	}

	@Test
	void testUpdateCustomer() throws Exception {
		// given
		CustomerDTO customer = new CustomerDTO();
		customer.setId(1L);
		customer.setFirstname("name");

		// when
		when(customerService.updateCustomer(anyLong(), any(CustomerDTO.class))).thenReturn(customer);

		// then
		mockMvc.perform(put("/api/v1/customers/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(customer)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstname", equalTo("name")))
				.andExpect(jsonPath("$.id", equalTo(1)));
	}

}
