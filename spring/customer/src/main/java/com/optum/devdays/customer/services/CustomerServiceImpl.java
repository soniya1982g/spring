package com.optum.devdays.customer.services;

import com.optum.devdays.customer.domain.Customer;
import com.optum.devdays.customer.dto.CustomerDto;
import com.optum.devdays.customer.dto.CustomerResponseDto;
import com.optum.devdays.customer.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Class CustomerServiceImpl.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/** The customer repository. */
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Iterable<Customer> listAllCustomers() {
		logger.info("fetching list of all customers");
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Integer id) {
		logger.info("fetching customer by customer id - {} ", id);
		return customerRepository.findById(id).orElse(null);
	}

	@Override
	public Customer saveCustomer(CustomerDto customerDto) {
		logger.info("saving customer to database");
		Customer customer = new Customer();
		customer.setEmail(customerDto.getEmail());
		customer.setName(customerDto.getName());
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Integer id, CustomerDto customer) {
		Customer storedCustomer = getCustomerById(id);
		if (customer.getEmail() != null) {
			storedCustomer.setEmail(customer.getEmail());
		}
		if (customer.getName() != null) {
			storedCustomer.setName(customer.getName());
		}
		logger.info("updating customer to database");
		return customerRepository.save(storedCustomer);
	}

	@Override
	public CustomerResponseDto deleteCustomer(Integer id) {
		Customer storedCustomer = getCustomerById(id);
		if (storedCustomer == null) {
			return new CustomerResponseDto("No Customer available with id - "
					+ id);
		}
		logger.info("deleting customer");
		customerRepository.deleteById(id);
		return new CustomerResponseDto("Customer deleted successfully");
	}
}
