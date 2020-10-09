package com.thiagomatar.api.service;

import com.thiagomatar.api.model.Order;
import com.thiagomatar.api.model.OrderStatus;

import java.util.List;

public interface OrderService {

    Order findById(Long id);

    List<Order> findAll();

    Order save(Order order);

    Order updateOrderStatus(Long id, OrderStatus status);
}
