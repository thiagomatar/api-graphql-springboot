package com.thiagomatar.api.error;

import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@Component
public class GraphqlExceptionHandler {

    private static final String NO_MESSAGE_AVAILABLE = "No message available";
    private static final Logger LOGGER = LoggerFactory.getLogger(GraphqlExceptionHandler.class);


    private final MessageSource apiErrorMessageSource;

    public GraphqlExceptionHandler(MessageSource apiErrorMessageSource) {
        this.apiErrorMessageSource = apiErrorMessageSource;
    }


    @ExceptionHandler(GraphQLException.class)
    public ThrowableGraphQLError handle(GraphQLException e) {
        return new ThrowableGraphQLError(e, toMessageError(e.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ThrowableGraphQLError handle(RuntimeException e) {
        return new ThrowableGraphQLError(e, "Internal Server Error");
    }


    private String toMessageError(String code) {
        String message;
        try {
            message = apiErrorMessageSource.getMessage(code, null, Locale.getDefault());
        } catch (NoSuchMessageException e) {
            LOGGER.error("Couldn't find any message for {} code ", code);
            message = NO_MESSAGE_AVAILABLE;
        }
        return message;
    }
}
