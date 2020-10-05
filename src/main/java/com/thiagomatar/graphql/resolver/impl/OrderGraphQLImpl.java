package com.thiagomatar.graphql.resolver.impl;

import com.thiagomatar.graphql.model.Order;
import com.thiagomatar.graphql.repository.OrderRepository;
import com.thiagomatar.graphql.resolver.OrderGraphQL;

import java.util.List;

public class OrderGraphQLImpl implements OrderGraphQL {

    private final OrderRepository repository;

    public OrderGraphQLImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Order> orders() {
        return null;
    }

    @Override
    public Order order(Long id) {
        return null;
    }

    @Override
    public Order saveOrder(Order order) {
        return null;
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        return null;
    }
}
