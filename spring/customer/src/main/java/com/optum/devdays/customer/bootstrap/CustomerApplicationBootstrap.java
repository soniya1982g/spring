package com.optum.devdays.customer.bootstrap;

import com.optum.devdays.customer.domain.Customer;
import com.optum.devdays.customer.repositories.CustomerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * The Class CustomerApplicationBootstrap.
 */
@Component
public class CustomerApplicationBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    /** The customer repository. */
    @Autowired
    private CustomerRepository customerRepository;

    /** The log. */
    private Logger log = LogManager.getLogger(CustomerApplicationBootstrap.class);

    /* (non-Javadoc)
     * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadStartUpData();
    }

    /**
     * Load start up data.
     */
    private void loadStartUpData() {
        for (int i = 1; i <= 10; i++) {
            Customer customer = new Customer();
            customer.setName("optum_user - " + i);
            customer.setEmail("dummy_" + i + "@optum.com");
            customerRepository.save(customer);
            log.info("Customer saved");
        }
    }
}



