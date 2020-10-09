package com.thiagomatar.api.graphql.impl;

import com.thiagomatar.api.graphql.ProductGraphQL;
import com.thiagomatar.api.model.Product;
import com.thiagomatar.api.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductGraphQLImpl implements ProductGraphQL {

    private final ProductService service;

    public ProductGraphQLImpl(ProductService service) {
        this.service = service;
    }

    @Override
    public List<Product> products() {
        return this.service.findAll();
    }

    @Override
    public Product product(Long id) {
        return this.service.findById(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return this.service.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        this.service.findById(id);
        product.setId(id);
        return this.service.save(product);
    }
}
