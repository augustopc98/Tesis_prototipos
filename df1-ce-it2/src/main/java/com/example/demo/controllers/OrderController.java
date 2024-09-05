package com.example.demo.controllers;

import com.example.demo.entities.CustomerOrder;
import com.example.demo.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public CustomerOrder createOrder(@RequestBody CustomerOrder request) {
        return orderService.createOrder(request.getCustomerEmail(), request.getCustomerAddress(), new Date());
    }

    @GetMapping("/{id}")
    public CustomerOrder getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @PutMapping("/{id}/status")
    public void updateDeliveryStatus(@PathVariable Long id, @RequestParam String status) {
        orderService.updateDeliveryStatus(id, status);
    }

    @PostMapping("/{id}/sendForDelivery")
    public void sendOrderForDelivery(@PathVariable Long id) {
        orderService.sendOrderForDelivery(id);
    }
}
