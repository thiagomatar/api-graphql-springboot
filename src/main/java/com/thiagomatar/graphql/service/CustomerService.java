package com.thiagomatar.graphql.service;

import com.thiagomatar.graphql.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer findById(Long id);

    List<Customer> findAll();

    Customer save(Customer customer);
}
