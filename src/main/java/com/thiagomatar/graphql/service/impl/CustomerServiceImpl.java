package com.thiagomatar.graphql.service.impl;

import com.thiagomatar.graphql.model.Customer;
import com.thiagomatar.graphql.repository.CustomerRepository;
import com.thiagomatar.graphql.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer findById(Long id) {
        return this.repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Customer> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        return this.repository.save(customer);
    }

}
