package com.optum.devdays.order.integration;

import com.optum.devdays.order.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * The Class ProductServiceClient.
 */
@Component
@PropertySource("classpath:application.properties")
public class ProductServiceClient {

    /** The logger. */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /** The product service url. */
    @Value("${product.service.url}")
    private String productServiceUrl;

    /** The rest template. */
    @Autowired
    private RestTemplate restTemplate;


    /**
     * Gets the product by product id.
     *
     * @param productId the product id
     * @return the product by product id
     */
    public ProductDto getProductByProductId(Integer productId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ProductDto productDto = null;
        try {
            productDto = restTemplate.exchange(productServiceUrl + "/" + productId, HttpMethod.GET, entity, ProductDto.class).getBody();
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        return productDto;
    }
}
