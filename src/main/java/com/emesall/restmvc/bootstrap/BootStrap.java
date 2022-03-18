package com.emesall.restmvc.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.emesall.restmvc.model.Category;
import com.emesall.restmvc.model.Customer;
import com.emesall.restmvc.repositories.CategoryRepository;
import com.emesall.restmvc.repositories.CustomerRepository;

@Component
public class BootStrap implements CommandLineRunner {

	private CategoryRepository categoryRepository;
	private CustomerRepository customerRepository;

	@Autowired
	public BootStrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		addCategories();
		addCustomers();

	}

	private void addCategories() {
		Category fruits = new Category();
		fruits.setName("Fruits");

		Category dried = new Category();
		dried.setName("Dried");

		Category fresh = new Category();
		fresh.setName("Fresh");

		Category exotic = new Category();
		exotic.setName("Exotic");

		Category nuts = new Category();
		nuts.setName("Nuts");

		categoryRepository.save(fruits);
		categoryRepository.save(dried);
		categoryRepository.save(fresh);
		categoryRepository.save(exotic);
		categoryRepository.save(nuts);
		System.out.println("Categories Loaded = " + categoryRepository.count());
	}

	private void addCustomers() {
		Customer c1 = new Customer("Peter", "Last");
		Customer c2 = new Customer("John", "Tyrel");
		Customer c3 = new Customer("Pavel", "Car");
		Customer c4 = new Customer("Jakob", "Rotate");
		Customer c5 = new Customer("Sam", "Dance");

		customerRepository.save(c1);
		customerRepository.save(c2);
		customerRepository.save(c3);
		customerRepository.save(c4);
		customerRepository.save(c5);

		System.out.println("Customers Loaded = " + customerRepository.count());
	}
}
