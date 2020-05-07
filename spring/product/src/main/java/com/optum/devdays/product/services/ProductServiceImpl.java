package com.optum.devdays.product.services;

import com.optum.devdays.product.domain.Product;
import com.optum.devdays.product.dto.ProductDto;
import com.optum.devdays.product.dto.ProductResponseDto;
import com.optum.devdays.product.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Class ProductServiceImpl.
 */
@Service
public class ProductServiceImpl implements ProductService {

    /** The logger. */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /** The product repository. */
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> listAllProducts() {
        logger.info("fetching list of all products");
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        logger.info("fetching product by product id - {} " , id);
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveProduct(ProductDto productDto) {
        logger.info("saving product to database");
        Product product = new Product();
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Integer id, ProductDto productDto) {
        Product storedProduct = getProductById(id);
        storedProduct.setDescription(productDto.getDescription());
        storedProduct.setPrice(productDto.getPrice());
        logger.info("updating product to database");
        return productRepository.save(storedProduct);
    }

    @Override
    public ProductResponseDto deleteProduct(Integer id) {
        Product storedProduct = getProductById(id);
        if (storedProduct == null) {
            return new ProductResponseDto("No Product available with id - " + id);
        }
        logger.info("deleting product from database");
        productRepository.deleteById(id);
        return new ProductResponseDto("Product deleted successfully");
    }
}
