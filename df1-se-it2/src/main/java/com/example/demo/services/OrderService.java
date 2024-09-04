package com.example.demo.services;

import com.example.demo.entities.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order createOrder(String customerEmail, String customerAddress, Date orderDate);
    void updateOrderDeliveryStatus(Long orderId, String status);
    void sendOrderForDelivery(Long orderId);
}
