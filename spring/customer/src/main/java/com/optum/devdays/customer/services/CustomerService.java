package com.optum.devdays.customer.services;


import com.optum.devdays.customer.domain.Customer;
import com.optum.devdays.customer.dto.CustomerDto;
import com.optum.devdays.customer.dto.CustomerResponseDto;

/**
 * The Interface CustomerService.
 */
public interface CustomerService {

    /**
     * List all customers.
     *
     * @return the iterable
     */
    Iterable<Customer> listAllCustomers();

    /**
     * Gets the customer by id.
     *
     * @param id the id
     * @return the customer by id
     */
    Customer getCustomerById(Integer id);

    /**
     * Save customer.
     *
     * @param customer the customer
     * @return the customer
     */
    Customer saveCustomer(CustomerDto customer);

    /**
     * Update customer.
     *
     * @param id the id
     * @param customer the customer
     * @return the customer
     */
    Customer updateCustomer(Integer id, CustomerDto customer);

    /**
     * Delete customer.
     *
     * @param id the id
     * @return the customer response dto
     */
    CustomerResponseDto deleteCustomer(Integer id);
}
