package com.emesall.restmvc.controller.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	@ResponseStatus(HttpStatus.OK)
	public CustomerListDTO getCategories(){
		return new CustomerListDTO(customerService.getCustomers());
	}
	@GetMapping("{firstname}")
	@ResponseStatus(HttpStatus.OK)
	public CustomerDTO getCategoryByName(@PathVariable String firstname){
		
		return customerService.getCustomerByFirstName(firstname);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO){
		
		return customerService.createCustomer(customerDTO);
	}
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO,@PathVariable Long id){
		return customerService.updateCustomer(id,customerDTO);
	}
	
	@PatchMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public CustomerDTO updatePartOfCustomer(@RequestBody CustomerDTO customerDTO,@PathVariable Long id){
		return customerService.updatePartOfCustomer(id,customerDTO);
	}
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteCustomer(@PathVariable Long id){
		customerService.deleteCustomerById(id);
	}
	
	
	

}
