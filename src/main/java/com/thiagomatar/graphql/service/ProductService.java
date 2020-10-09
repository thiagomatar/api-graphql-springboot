package com.thiagomatar.graphql.service;

import com.thiagomatar.graphql.model.Product;

import java.util.List;

public interface ProductService {
    Product findById(Long id);

    List<Product> findAll();

    Product save(Product product);
}
