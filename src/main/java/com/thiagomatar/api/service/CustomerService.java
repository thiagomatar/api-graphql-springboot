package com.thiagomatar.api.service;

import com.thiagomatar.api.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer findById(Long id);

    List<Customer> findAll();

    Customer save(Customer customer);
}
