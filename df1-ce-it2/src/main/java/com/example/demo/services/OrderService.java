package com.example.demo.services;

import com.example.demo.entities.CustomerOrder;

import java.util.Date;

public interface OrderService {
    CustomerOrder createOrder(String customerEmail, String customerAddress, Date orderDate);
    CustomerOrder getOrder(Long id);
    void updateDeliveryStatus(Long orderId, String status);
    void sendOrderForDelivery(Long orderId);
}
