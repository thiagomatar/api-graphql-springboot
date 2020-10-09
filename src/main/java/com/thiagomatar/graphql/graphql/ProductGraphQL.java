package com.thiagomatar.graphql.graphql;

import com.thiagomatar.graphql.model.Product;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

public interface ProductGraphQL extends GraphQLQueryResolver, GraphQLMutationResolver {

    List<Product> products();

    Product product(Long id);

    Product saveProduct(Product product);

    Product updateProduct(Long id, Product product);

}