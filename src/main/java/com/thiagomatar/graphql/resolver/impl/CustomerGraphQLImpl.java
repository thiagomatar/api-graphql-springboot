package com.thiagomatar.graphql.resolver.impl;

import com.thiagomatar.graphql.model.Customer;
import com.thiagomatar.graphql.repository.CustomerRepository;
import com.thiagomatar.graphql.resolver.CustomerQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerQueryImpl implements CustomerQuery {

    private final CustomerRepository repository;

    public CustomerQueryImpl(CustomerRepository repository) {
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
}
