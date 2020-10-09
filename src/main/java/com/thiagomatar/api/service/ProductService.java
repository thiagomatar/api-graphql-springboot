package com.thiagomatar.api.service;

import com.thiagomatar.api.model.Product;

import java.util.List;

public interface ProductService {
    Product findById(Long id);

    List<Product> findAll();

    Product save(Product product);
}
