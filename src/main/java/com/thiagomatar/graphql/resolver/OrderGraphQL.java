package com.thiagomatar.graphql.resolver;

import com.thiagomatar.graphql.model.Product;

import java.util.List;

public interface ProductGraphQL {

    List<Product> products();

    Product product(Long id);

    Product saveProduct(Product product);

    Product updateProduct(Long id, Product product);

}
