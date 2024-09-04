package com.example.demo.services;

import com.example.demo.entities.CustomerOrder;
import java.util.List;
import java.util.Date;

public interface OrderService {
    List<CustomerOrder> getAllOrders();
    CustomerOrder getOrderById(Long id);
    CustomerOrder createOrder(String customerEmail, String customerAddress, Date orderDate);
    void updateOrderDeliveryStatus(Long orderId, String status);
    void sendOrderForDelivery(Long orderId);
}
