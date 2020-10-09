package com.thiagomatar.graphql.service.impl;

import com.thiagomatar.graphql.model.Order;
import com.thiagomatar.graphql.model.OrderStatus;
import com.thiagomatar.graphql.repository.OrderRepository;
import com.thiagomatar.graphql.service.OrderService;
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
        return this.repository.findById(id).orElseThrow(RuntimeException::new);
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
