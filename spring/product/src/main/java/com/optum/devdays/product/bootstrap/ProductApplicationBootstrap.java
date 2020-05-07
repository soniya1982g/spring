package com.optum.devdays.product.bootstrap;

import com.optum.devdays.product.domain.Product;
import com.optum.devdays.product.repositories.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * The Class ProductApplicationBootstrap.
 */
@Component
public class ProductApplicationBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    /** The product repository. */
    @Autowired
    private ProductRepository productRepository;

    /** The logger. */
    private Logger logger = LogManager.getLogger(ProductApplicationBootstrap.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadStartUpData();
    }

    /**
     * Load start up data.
     */
    private void loadStartUpData() {
        Product book = new Product();
        book.setDescription("2 States");
        book.setPrice(new BigDecimal("13.75"));
        productRepository.save(book);

        Product book2 = new Product();
        book2.setDescription("Wings of Fire - APJ Kalam");
        book2.setPrice(new BigDecimal("19.75"));
        productRepository.save(book2);

        logger.info("Saved Shirt - id: " + book.getId());

        for (int i = 2; i <= 7; i++) {
            Product mobile = new Product();
            mobile.setDescription("Xiaomi MI Note " + i + " Pro");
            mobile.setPrice(new BigDecimal("105.99"));
            productRepository.save(mobile);
            logger.info("Saved mobile - id:" + mobile.getId());
        }

        for (int i = 1; i <= 5; i++) {
            Product mug = new Product();
            mug.setDescription("White Mug - " + i);
            mug.setPrice(new BigDecimal("5.99"));
            productRepository.save(mug);
            logger.info("Saved Mug - id:" + mug.getId());
        }

        for (int i = 1; i <= 5; i++) {
            Product shirt = new Product();
            shirt.setDescription("Stylish Checked Shirt - " + i);
            shirt.setPrice(new BigDecimal("13.19"));
            productRepository.save(shirt);
            logger.info("Saved shirt - id:" + shirt.getId());
        }

    }


}



