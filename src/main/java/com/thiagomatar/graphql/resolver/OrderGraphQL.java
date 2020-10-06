package com.thiagomatar.graphql.resolver;

import com.thiagomatar.graphql.model.Order;
import com.thiagomatar.graphql.model.OrderStatus;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

public interface OrderGraphQL extends GraphQLQueryResolver, GraphQLMutationResolver {

    List<Order> orders();

    Order order(Long id);

    Order saveOrder(Order order);

    Order updateOrderStatus(Long id, OrderStatus order);

}
