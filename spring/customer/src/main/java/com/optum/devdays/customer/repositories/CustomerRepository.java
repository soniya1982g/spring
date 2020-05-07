package com.optum.devdays.customer.repositories;

import com.optum.devdays.customer.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface CustomerRepository.
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
