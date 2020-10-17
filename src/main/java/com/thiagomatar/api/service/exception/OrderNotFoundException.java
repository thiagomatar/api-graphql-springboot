package com.thiagomatar.api.service.exception;

import graphql.GraphQLException;

public class OrderNotFoundException extends GraphQLException {
    public OrderNotFoundException() {
        super("order-not-found");
    }
}
