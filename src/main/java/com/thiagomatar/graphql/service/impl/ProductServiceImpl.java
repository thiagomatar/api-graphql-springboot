package com.thiagomatar.graphql.service.impl;

import com.thiagomatar.graphql.model.Product;
import com.thiagomatar.graphql.repository.ProductRepository;
import com.thiagomatar.graphql.service.ProductService;
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
        return this.repository.findById(id).orElseThrow(RuntimeException::new);
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
