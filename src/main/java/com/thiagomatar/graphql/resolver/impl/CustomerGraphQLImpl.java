package com.thiagomatar.graphql.resolver.impl;

import com.thiagomatar.graphql.model.Customer;
import com.thiagomatar.graphql.repository.CustomerRepository;
import com.thiagomatar.graphql.resolver.CustomerGraphQL;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        Optional<Customer> customerInDB = this.repository.findById(customer.getId());
        if(customerInDB.isPresent() && !customer.equals(customerInDB)){
            throw new RuntimeException("Cliente ja existe");
        }
        return this.repository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        this.repository.findById(id).orElseThrow(RuntimeException::new);
        customer.setId(id);
        return this.repository.save(customer);
    }
}
