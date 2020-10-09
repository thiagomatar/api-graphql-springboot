package com.thiagomatar.graphql.service;

import com.thiagomatar.graphql.model.Order;
import com.thiagomatar.graphql.model.OrderStatus;

import java.util.List;

public interface OrderService {

    Order findById(Long id);

    List<Order> findAll();

    Order save(Order order);

    Order updateOrderStatus(Long id, OrderStatus status);
}
