package org.example.bookstore.services;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.entities.Order;
import org.example.bookstore.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    public final OrderRepository orderRepository;

    public Order createOrder(Order order) {

        return orderRepository.save(order);
    }

    public Order findOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {

        orderRepository.deleteById(id);
    }

    public List<Order> findOrdersByUserId(Long id) {
        return orderRepository.findByUserId(id);
    }
}
