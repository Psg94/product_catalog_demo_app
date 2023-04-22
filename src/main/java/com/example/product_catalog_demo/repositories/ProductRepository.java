package com.example.product_catalog_demo.repositories;

import com.example.product_catalog_demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();
    Optional<Product> findAllById(Long id);
    List<Product> findByNameOrDescriptionOrPriceBetween(String name,
                                                        String description,
                                                        Double priceFrom,
                                                        Double priceTo);
    Product save(Product products);

    void deleteById(Long id);
}
