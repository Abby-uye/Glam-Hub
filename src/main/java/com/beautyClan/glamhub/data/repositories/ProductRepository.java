package com.beautyClan.glamhub.data.repositories;

import com.beautyClan.glamhub.data.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findBySku(Long sku);
}
