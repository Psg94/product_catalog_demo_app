package com.example.product_catalog_demo.repositories;

import com.example.product_catalog_demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();
    Optional<Product> findAllById(Long id);

    @Query(value = "SELECT * FROM products p " +
                   "WHERE p.name LIKE :nameMask " +
                   "AND p.description LIKE :descriptionMask " +
                   "AND (:categoryId IS NULL OR p.category_id = :categoryId) " +
                   "AND (:priceFrom IS NULL OR p.price >= :priceFrom)" +
                   "AND (:priceTo IS NULL OR p.price <= :priceTo)",
            nativeQuery = true)
    List<Product> findProducts(@Param("nameMask") String nameMask,
                               @Param("descriptionMask") String descriptionMask,
                               @Param("categoryId") Long categoryId,
                               @Param("priceFrom") Double priceFrom,
                               @Param("priceTo") Double priceTo);
    Product save(Product products);

    @Modifying
    @Query(value = "UPDATE products p " +
                   "SET p.category_id = NULL, " +
                   "p.status = :status " +
                   "WHERE p.category_id = :deletedCategoryId",
            nativeQuery = true)
    int updateStatusByDeletedCategory(@Param("status") String status,
                                      @Param("deletedCategoryId") Long deletedCategoryId);

    void deleteById(Long id);
}
