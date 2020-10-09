package com.thiagomatar.api.graphql;

import com.thiagomatar.api.model.Order;
import com.thiagomatar.api.model.OrderStatus;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

public interface OrderGraphQL extends GraphQLQueryResolver, GraphQLMutationResolver {

    List<Order> orders();

    Order order(Long id);

    Order saveOrder(Order order);

    Order updateOrderStatus(Long id, OrderStatus order);

}
