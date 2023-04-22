package com.example.product_catalog_demo.repositories;

import com.example.product_catalog_demo.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    List<ProductCategory> findAll();
    Optional<ProductCategory> findAllById(Long id);
    @Query(value = "SELECT * FROM product_categories pc " +
                   "WHERE pc.name LIKE :nameMask " +
                   "AND pc.description LIKE :descriptionMask",
           nativeQuery = true)
    List<ProductCategory> findAllByNameAndDescription(@Param("nameMask") String nameMask,
                                                      @Param("descriptionMask") String descriptionMask);

    ProductCategory save(ProductCategory productCategory);
    void deleteById(Long id);
}
