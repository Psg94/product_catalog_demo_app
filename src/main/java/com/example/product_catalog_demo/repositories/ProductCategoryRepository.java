package com.example.product_catalog_demo.repositories;

import com.example.product_catalog_demo.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    List<ProductCategory> findAll();
    Optional<ProductCategory> findAllById(Long id);
    List<ProductCategory> findAllByNameOrDescription(String name, String description);

    ProductCategory save(ProductCategory productCategory);
    void deleteById(Long id);
}
