package com.optum.devdays.product.controller;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optum.devdays.product.domain.Product;
import com.optum.devdays.product.dto.ProductDto;
import com.optum.devdays.product.dto.ProductResponseDto;
import com.optum.devdays.product.services.ProductService;

/**
 * The Class ProductController.
 */
@RestController
@RequestMapping("/v1/products")
public class ProductController {

    /** The product service. */
    @Autowired
    private ProductService productService;

    /**
     * Gets the all products.
     *
     * @param model the model
     * @return the all products
     */
    @ApiOperation(value = "View a list of all available products", response = Iterable.class)
    @GetMapping
    public Iterable<Product> getAllProducts(Model model) {
       	//TODO :: Please add the code as part of your training lab

        return null;
    }

    /**
     * Gets the product.
     *
     * @param id the id
     * @param model the model
     * @return the product
     */
    @ApiOperation(value = "View a product by product id", response = Product.class)
    @GetMapping("{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable(value = "productId") Integer id, Model model) {
       	//TODO :: Please add the code as part of your training lab

        return null;
    }

    /**
     * Save product.
     *
     * @param productDto the product dto
     * @return the response entity
     */
    @ApiOperation(value = "add a new product", response = Product.class)
    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody ProductDto productDto) {
       	//TODO :: Please add the code as part of your training lab
        return null;
    }

    /**
     * Update product.
     *
     * @param id the id
     * @param productDto the product dto
     * @return the response entity
     */
    @ApiOperation(value = "update product detail", response = ProductResponseDto.class)
    @PutMapping("{productId}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable(value = "productId") Integer id, @RequestBody ProductDto productDto) {
       	//TODO :: Please add the code as part of your training lab

    	return null;
    }

    /**
     * Delete product.
     *
     * @param id the id
     * @return the response entity
     */
    @ApiOperation(value = "delete product", response = ProductResponseDto.class)
    @DeleteMapping("{productId}")
    public ResponseEntity<ProductResponseDto> deleteProduct(@PathVariable(value = "productId") Integer id) {
        return null;
    }

}
