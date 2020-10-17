package com.thiagomatar.api.service.exception;

import graphql.GraphQLException;

public class ProductNotFoundException extends GraphQLException {
    public ProductNotFoundException() {
        super("product-not-found");
    }
}
