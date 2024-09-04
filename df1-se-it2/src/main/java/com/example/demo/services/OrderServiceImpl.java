package com.example.demo.services;

import com.example.demo.entities.CustomerOrder;
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
    public List<CustomerOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public CustomerOrder getOrderById(Long id) {
        Optional<CustomerOrder> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElse(null);
    }

    @Override
    public CustomerOrder createOrder(String customerEmail, String customerAddress, Date orderDate) {
        CustomerOrder order = new CustomerOrder(null, customerEmail, customerAddress, orderDate);
        return orderRepository.save(order);
    }

    @Override
    public void updateOrderDeliveryStatus(Long orderId, String status) {
        CustomerOrder order = getOrderById(orderId);
        if (order != null) {
            order.updateDeliveryStatus(status);
            orderRepository.save(order);
        }
    }

    @Override
    public void sendOrderForDelivery(Long orderId) {
        CustomerOrder order = getOrderById(orderId);
        if (order != null) {
            order.sendForDelivery();
            orderRepository.save(order);
        }
    }
}
