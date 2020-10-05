package com.thiagomatar.graphql.resolver.impl;

import com.thiagomatar.graphql.model.Product;
import com.thiagomatar.graphql.repository.ProductRepository;
import com.thiagomatar.graphql.resolver.ProductGraphQL;

import java.util.List;

public class ProductGraphQLImpl implements ProductGraphQL {

    private final ProductRepository repository;

    public ProductGraphQLImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> products() {
        return null;
    }

    @Override
    public Product product(Long id) {
        return null;
    }

    @Override
    public Product saveProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }
}
