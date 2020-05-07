package com.optum.devdays.product.repositories;

import com.optum.devdays.product.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface ProductRepository.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
