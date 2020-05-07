package com.optum.devdays.order.services;

import com.optum.devdays.order.domain.Order;
import com.optum.devdays.order.dto.OrderDto;
import com.optum.devdays.order.dto.OrderResponseDto;

/**
 * The Interface OrderService.
 */
public interface OrderService {

    /**
     * List all orders.
     *
     * @return the iterable
     */
    Iterable<Order> listAllOrders();

    /**
     * Gets the order by id.
     *
     * @param id the id
     * @return the order by id
     */
    Order getOrderById(Integer id);

    /**
     * Save order.
     *
     * @param order the order
     * @return the order response dto
     */
    OrderResponseDto saveOrder(OrderDto order);
}
