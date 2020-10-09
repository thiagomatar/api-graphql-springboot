package com.thiagomatar.graphql.graphql.impl;

import com.thiagomatar.graphql.model.Customer;
import com.thiagomatar.graphql.repository.CustomerRepository;
import com.thiagomatar.graphql.graphql.CustomerGraphQL;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerGraphQLImpl implements CustomerGraphQL {

    private final CustomerRepository repository;

    public CustomerGraphQLImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> customers() {
        return this.repository.findAll();
    }

    @Override
    public Customer customer(Long id) {
        return this.repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return this.repository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        this.repository.findById(id).orElseThrow(RuntimeException::new);
        customer.setId(id);
        return this.repository.save(customer);
    }
}
