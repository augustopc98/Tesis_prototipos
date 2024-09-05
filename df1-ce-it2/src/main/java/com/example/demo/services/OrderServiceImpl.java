package com.example.demo.services;

import com.example.demo.entities.CustomerOrder;
import com.example.demo.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    private void validateOrder(CustomerOrder order) {
        // Agregar lógica de validación aquí
    }

    @Override
    public CustomerOrder createOrder(String customerEmail, String customerAddress, Date orderDate) {
        CustomerOrder order = new CustomerOrder(null, customerEmail, customerAddress, orderDate);
        validateOrder(order);
        return orderRepository.save(order);
    }

    @Override
    public CustomerOrder getOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void updateDeliveryStatus(Long orderId, String status) {
        CustomerOrder order = getOrder(orderId);
        if (order != null) {
            order.updateDeliveryStatus(status);
            orderRepository.save(order);
        }
    }

    @Override
    public void sendOrderForDelivery(Long orderId) {
        CustomerOrder order = getOrder(orderId);
        if (order != null) {
            order.sendForDelivery();
            orderRepository.save(order);
        }
    }
}
