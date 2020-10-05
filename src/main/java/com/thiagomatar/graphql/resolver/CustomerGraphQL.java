package com.thiagomatar.graphql.resolver;

import com.thiagomatar.graphql.model.Customer;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

public interface CustomerQuery extends GraphQLQueryResolver {

    List<Customer> customers();

    Customer customer(Long id);

}
