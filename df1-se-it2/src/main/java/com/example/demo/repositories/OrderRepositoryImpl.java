package com.example.demo.services;

import com.example.demo.entities.Order;
import com.example.demo.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElse(null);
    }

    @Override
    public Order createOrder(String customerEmail, String customerAddress, Date orderDate) {
        Order order = new Order(null, customerEmail, customerAddress, orderDate);
        return orderRepository.save(order);
    }

    @Override
    public void updateOrderDeliveryStatus(Long orderId, String status) {
        Order order = getOrderById(orderId);
        if (order != null) {
            order.updateDeliveryStatus(status);
            orderRepository.save(order);
        }
    }

    @Override
    public void sendOrderForDelivery(Long orderId) {
        Order order = getOrderById(orderId);
        if (order != null) {
            order.sendForDelivery();
            orderRepository.save(order);
        }
    }
}
