package com.optum.devdays.order.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.optum.devdays.order.domain.Order;

/**
 * The Interface OrderRepository.
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
