package com.emesall.restmvc.controller.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emesall.restmvc.api.v1.model.CustomerDTO;
import com.emesall.restmvc.api.v1.model.CustomerListDTO;
import com.emesall.restmvc.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
	
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping
	public ResponseEntity<CustomerListDTO> getCategories(){
		return new ResponseEntity<CustomerListDTO>(new CustomerListDTO(customerService.getCustomers()), HttpStatus.OK);
	}
	@GetMapping("{firstname}")
	public ResponseEntity<CustomerDTO> getCategoryByName(@PathVariable String firstname){
		
		return new ResponseEntity<CustomerDTO>(customerService.getCustomerByFirstName(firstname),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO){
		
		return new ResponseEntity<CustomerDTO>(customerService.createCustomer(customerDTO),HttpStatus.CREATED);
	}
	@PutMapping("{id}")
	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO,@PathVariable Long id){
		return new ResponseEntity<CustomerDTO>(customerService.updateCustomer(id,customerDTO),HttpStatus.OK);
	}
	
	@PatchMapping("{id}")
	public ResponseEntity<CustomerDTO> updatePartOfCustomer(@RequestBody CustomerDTO customerDTO,@PathVariable Long id){
		return new ResponseEntity<CustomerDTO>(customerService.updatePartOfCustomer(id,customerDTO),HttpStatus.OK);
	}
	
	
	

}
