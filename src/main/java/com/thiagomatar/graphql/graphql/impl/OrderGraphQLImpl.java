package com.thiagomatar.graphql.graphql.impl;

import com.thiagomatar.graphql.graphql.OrderGraphQL;
import com.thiagomatar.graphql.model.Order;
import com.thiagomatar.graphql.model.OrderStatus;
import com.thiagomatar.graphql.service.OrderService;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class OrderGraphQLImpl implements OrderGraphQL {

    private final OrderService service;

    public OrderGraphQLImpl(OrderService service) {
        this.service = service;
    }

    @Override
    public List<Order> orders() {
        return this.service.findAll();
    }

    @Override
    public Order order(Long id) {
        return this.service.findById(id);
    }

    @Override
    @Transactional
    public Order saveOrder(Order order) {
        return this.service.save(order);
    }

    @Override
    public Order updateOrderStatus(Long id, OrderStatus status) {
        return this.service.updateOrderStatus(id, status);
    }
}
