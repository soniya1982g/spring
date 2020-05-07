package com.optum.devdays.order.integration;

import com.optum.devdays.order.dto.CustomerDto;
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
 * The Class CustomerServiceClient.
 */
@Component
@PropertySource("classpath:application.properties")
public class CustomerServiceClient {

    /** The logger. */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /** The customer service url. */
    @Value("${customer.service.url}")
    private String customerServiceUrl;

    /** The rest template. */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Gets the customer by customer id.
     *
     * @param customerId the customer id
     * @return the customer by customer id
     */
    public CustomerDto getCustomerByCustomerId(Integer customerId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        CustomerDto customerDto = null;
        try {
            customerDto = restTemplate.exchange(customerServiceUrl + "/" + customerId, HttpMethod.GET, entity, CustomerDto.class).getBody();
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        return customerDto;
    }
}
