package com.thiagomatar.graphql.resolver.impl;

import com.thiagomatar.graphql.model.Order;
import com.thiagomatar.graphql.model.OrderStatus;
import com.thiagomatar.graphql.repository.OrderRepository;
import com.thiagomatar.graphql.resolver.OrderGraphQL;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderGraphQLImpl implements OrderGraphQL {

    private final OrderRepository repository;

    public OrderGraphQLImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Order> orders() {
        return this.repository.findAll();
    }

    @Override
    public Order order(Long id) {
        return this.repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Order saveOrder(Order order) {
        return this.repository.save(order);
    }

    @Override
    public Order updateOrderStatus(Long id, OrderStatus status) {
        Order order = this.repository.findById(id).orElseThrow(RuntimeException::new);
        order.setStatus(status);
        return this.repository.save(order);
    }
}
