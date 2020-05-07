package com.optum.devdays.customer.controller;

import com.optum.devdays.customer.domain.Customer;
import com.optum.devdays.customer.dto.CustomerDto;
import com.optum.devdays.customer.dto.CustomerResponseDto;
import com.optum.devdays.customer.services.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The Class CustomerController.
 */
@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    /** The customer service. */
    @Autowired
    private CustomerService customerService;

    /**
     * Gets the all customers.
     *
     * @return the all customers
     */
    @ApiOperation(value = "View a list of all available customers", response = Iterable.class)
    @GetMapping
    public Iterable<Customer> getAllCustomers() {
       	//TODO :: Please add the code as part of your training lab

        return null;
    }

    /**
     * Gets the customer by id.
     *
     * @param id the id
     * @return the customer by id
     */
    @ApiOperation(value = "View a customer by customer id", response = Customer.class)
    @GetMapping("{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "customerId") Integer id) {
        Customer customer = customerService.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /**
     * Save customer.
     *
     * @param customerDto the customer dto
     * @return the response entity
     */
    @ApiOperation(value = "add a new customer", response = Customer.class)
    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = customerService.saveCustomer(customerDto);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    /**
     * Update customer.
     *
     * @param id the id
     * @param customer the customer
     * @return the response entity
     */
    @ApiOperation(value = "update customer detail", response = CustomerResponseDto.class)
    @PutMapping("{customerId}")
    public ResponseEntity<CustomerResponseDto> updateCustomer(@PathVariable(value = "customerId") Integer id, @RequestBody CustomerDto customer) {
        customerService.updateCustomer(id, customer);
        return new ResponseEntity<>(new CustomerResponseDto("Customer updated successfully"), HttpStatus.OK);
    }

    /**
     * Delete customer.
     *
     * @param id the id
     * @return the response entity
     */
    @ApiOperation(value = "delete customer", response = CustomerResponseDto.class)
    @DeleteMapping("{customerId}")
    public ResponseEntity<CustomerResponseDto> deleteCustomer(@PathVariable(value = "customerId") Integer id) {
        CustomerResponseDto customerResponseDto = customerService.deleteCustomer(id);
        return new ResponseEntity<>(customerResponseDto, HttpStatus.OK);
    }

}
