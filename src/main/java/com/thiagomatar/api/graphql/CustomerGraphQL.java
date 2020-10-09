package com.thiagomatar.api.graphql;

import com.thiagomatar.api.model.Customer;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

public interface CustomerGraphQL extends GraphQLQueryResolver, GraphQLMutationResolver {

    List<Customer> customers();

    Customer customer(Long id);

    Customer saveCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer customer);

}
