package com.optum.devdays.order.services;

import com.optum.devdays.order.domain.Order;
import com.optum.devdays.order.dto.CustomerDto;
import com.optum.devdays.order.dto.OrderDto;
import com.optum.devdays.order.dto.OrderResponseDto;
import com.optum.devdays.order.dto.ProductDto;
import com.optum.devdays.order.integration.CustomerServiceClient;
import com.optum.devdays.order.integration.ProductServiceClient;
import com.optum.devdays.order.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Class OrderServiceImpl.
 */
@Service
public class OrderServiceImpl implements OrderService {

    /** The logger. */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /** The order repository. */
    @Autowired
    private OrderRepository orderRepository;

    /** The product service client. */
    @Autowired
    private ProductServiceClient productServiceClient;

    /** The customer service client. */
    @Autowired
    private CustomerServiceClient customerServiceClient;

    @Override
    public Iterable<Order> listAllOrders() {
        logger.info("fetching list of all orders");
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Integer id) {
        logger.info("fetching order by order id - {} ", id);
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public OrderResponseDto saveOrder(OrderDto orderDto) {
        logger.info("placing new order");
        Order order = new Order();
        ProductDto productDto = productServiceClient.getProductByProductId(orderDto.getProductId());
        if (productDto == null) {
            return new OrderResponseDto("No Product available with given id - " + orderDto.getProductId());
        }
        CustomerDto customerDto = customerServiceClient.getCustomerByCustomerId(orderDto.getCustomerId());
        if (customerDto == null) {
            return new OrderResponseDto("No Customer available with given id - " + orderDto.getCustomerId());
        }
        order.setCustomerId(orderDto.getCustomerId());
        order.setProductId(orderDto.getProductId());
        order.setProductDescription(productDto.getDescription());
        order.setCustomerName(customerDto.getName());
        orderRepository.save(order);
        return new OrderResponseDto("Order placed successfully");
    }

}
