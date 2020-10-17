package com.thiagomatar.api.service.impl;

import com.thiagomatar.api.model.Product;
import com.thiagomatar.api.repository.ProductRepository;
import com.thiagomatar.api.service.ProductService;
import com.thiagomatar.api.service.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product findById(Long id) {
        return this.repository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public List<Product> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Product save(Product product) {
        return this.repository.save(product);
    }

}
