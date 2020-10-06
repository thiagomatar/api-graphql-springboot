package com.thiagomatar.graphql.resolver.impl;

import com.thiagomatar.graphql.model.Product;
import com.thiagomatar.graphql.repository.ProductRepository;
import com.thiagomatar.graphql.resolver.ProductGraphQL;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductGraphQLImpl implements ProductGraphQL {

    private final ProductRepository repository;

    public ProductGraphQLImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> products() {
        return this.repository.findAll();
    }

    @Override
    public Product product(Long id) {
        return this.repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Product saveProduct(Product product) {
        Optional<Product> productInDB = this.repository.findById(product.getId());
        if(productInDB.isPresent() && !product.equals(productInDB.get())){
            throw new RuntimeException();
        }
        return this.repository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        this.repository.findById(id).orElseThrow(RuntimeException::new);
        product.setId(id);
        return this.repository.save(product);
    }
}
