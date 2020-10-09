package com.thiagomatar.graphql.repository;

import com.thiagomatar.graphql.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByOrderId(Long orderId);
}
