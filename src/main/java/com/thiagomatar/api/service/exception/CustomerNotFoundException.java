package com.thiagomatar.api.service.exception;

import graphql.GraphQLException;

public class CustomerNotFoundException extends GraphQLException {
    public CustomerNotFoundException() {
        super("customer-not-found");
    }
}
