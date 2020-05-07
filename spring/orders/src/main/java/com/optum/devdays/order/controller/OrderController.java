package com.optum.devdays.order.controller;

import com.optum.devdays.order.domain.Order;
import com.optum.devdays.order.dto.OrderDto;
import com.optum.devdays.order.dto.OrderResponseDto;
import com.optum.devdays.order.services.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * The Class OrderController.
 */
@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    /** The order service. */
    @Autowired
    private OrderService orderService;

    /**
     * Gets the all orders.
     *
     * @param model the model
     * @return the all orders
     */
    @ApiOperation(value = "View a list of all placed orders", response = Iterable.class)
    @GetMapping
    public Iterable<Order> getAllOrders(Model model) {
        return orderService.listAllOrders();
    }

    /**
     * Gets the order by order id.
     *
     * @param id the id
     * @param model the model
     * @return the order by order id
     */
    @ApiOperation(value = "View a order by order id", response = Order.class)
    @GetMapping("{orderId}")
    public ResponseEntity<Order> getOrderByOrderId(@PathVariable(value = "orderId") Integer id, Model model) {
        Order order = orderService.getOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    /**
     * Place order.
     *
     * @param order the order
     * @return the response entity
     */
    @ApiOperation(value = "Place a new order", response = OrderResponseDto.class)
    @PostMapping("/place")
    public ResponseEntity<OrderResponseDto> placeOrder(@RequestBody OrderDto order) {
        OrderResponseDto orderResponseDto = orderService.saveOrder(order);
        return new ResponseEntity<>(orderResponseDto, HttpStatus.OK);
    }

}
