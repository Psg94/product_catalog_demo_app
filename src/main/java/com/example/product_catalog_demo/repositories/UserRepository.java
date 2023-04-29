package com.example.product_catalog_demo.repositories;

import com.example.product_catalog_demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
