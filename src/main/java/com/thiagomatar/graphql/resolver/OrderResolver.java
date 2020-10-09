package com.thiagomatar.graphql.resolver;

import com.thiagomatar.graphql.model.Customer;
import com.thiagomatar.graphql.model.Order;
import com.thiagomatar.graphql.model.Product;
import com.thiagomatar.graphql.repository.CustomerRepository;
import com.thiagomatar.graphql.repository.ProductRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderResolver implements GraphQLResolver<Order> {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public OrderResolver(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }


    public Customer customer(Order order) {
        return customerRepository.findById(order.getCustomer().getId()).orElseThrow(RuntimeException::new);
    }

    public List<Product> products(Order order){
        return this.productRepository.findAllByOrderId(order.getId());
    }
}
