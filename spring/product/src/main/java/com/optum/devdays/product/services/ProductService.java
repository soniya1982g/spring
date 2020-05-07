package com.optum.devdays.product.services;

import com.optum.devdays.product.domain.Product;
import com.optum.devdays.product.dto.ProductDto;
import com.optum.devdays.product.dto.ProductResponseDto;

/**
 * The Interface ProductService.
 */
public interface ProductService {

    /**
     * List all products.
     *
     * @return the iterable
     */
    Iterable<Product> listAllProducts();

    /**
     * Gets the product by id.
     *
     * @param id the id
     * @return the product by id
     */
    Product getProductById(Integer id);

    /**
     * Save product.
     *
     * @param product the product
     * @return the product
     */
    Product saveProduct(ProductDto product);

    /**
     * Update product.
     *
     * @param id the id
     * @param product the product
     * @return the product
     */
    Product updateProduct(Integer id, ProductDto product);

    /**
     * Delete product.
     *
     * @param id the id
     * @return the product response dto
     */
    ProductResponseDto deleteProduct(Integer id);
}
