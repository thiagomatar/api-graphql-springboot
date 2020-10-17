package com.thiagomatar.api.service.impl;

import com.thiagomatar.api.model.Order;
import com.thiagomatar.api.model.OrderStatus;
import com.thiagomatar.api.repository.OrderRepository;
import com.thiagomatar.api.service.OrderService;
import com.thiagomatar.api.service.exception.OrderNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order findById(Long id) {
        return this.repository.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    @Override
    public List<Order> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Order save(Order order) {
        return this.repository.save(order);
    }

    @Override
    public Order updateOrderStatus(Long id, OrderStatus status) {
        Order order = this.findById(id);
        order.setStatus(status);
        return this.repository.save(order);
    }
}
