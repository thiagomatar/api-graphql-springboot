package com.thiagomatar.graphql.graphql.impl;

import com.thiagomatar.graphql.graphql.CustomerGraphQL;
import com.thiagomatar.graphql.model.Customer;
import com.thiagomatar.graphql.service.CustomerService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerGraphQLImpl implements CustomerGraphQL {

    private final CustomerService service;

    public CustomerGraphQLImpl(CustomerService service) {
        this.service = service;
    }

    @Override
    public List<Customer> customers() {
        return this.service.findAll();
    }

    @Override
    public Customer customer(Long id) {
        return this.service.findById(id);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return this.service.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        this.service.findById(id);
        customer.setId(id);
        return this.service.save(customer);
    }
}
