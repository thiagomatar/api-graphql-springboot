package com.thiagomatar.api.resolver;

import com.thiagomatar.api.model.Customer;
import com.thiagomatar.api.model.Order;
import com.thiagomatar.api.model.Product;
import com.thiagomatar.api.repository.CustomerRepository;
import com.thiagomatar.api.repository.ProductRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.List;

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
