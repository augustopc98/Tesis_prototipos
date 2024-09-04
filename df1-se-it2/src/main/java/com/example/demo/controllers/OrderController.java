package com.example.demo.controllers;

import com.example.demo.entities.CustomerOrder;
import com.example.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<CustomerOrder> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public CustomerOrder getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public CustomerOrder createOrder(@RequestBody CustomerOrder order) {
        return orderService.createOrder(order.getCustomerEmail(), order.getCustomerAddress(), order.getOrderDate());
    }

    @PutMapping("/{id}/status")
    public void updateOrderDeliveryStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        orderService.updateOrderDeliveryStatus(id, status);
    }

    @PutMapping("/{id}/send")
    public void sendOrderForDelivery(@PathVariable Long id) {
        orderService.sendOrderForDelivery(id);
    }
}
